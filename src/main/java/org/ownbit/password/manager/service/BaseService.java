package org.ownbit.password.manager.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.ownbit.password.manager.gui.MainGUI;
import org.ownbit.password.manager.model.CategoryModel;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.Util;

/**
 * The Class BaseService.
 */
public class BaseService extends Constants {

    /**
     * Creates the database.
     */
    private static void createDatabase() {

	Statement stmt = null;
	Connection conn = H2Connection.getConnection(MainGUI.getDatabaseModel());
	if (conn != null) {
	    try {
		stmt = conn.createStatement();
		String sql = "CREATE TABLE CATEGORY(" + " ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, "
        			+ " CATEGORY_NAME VARCHAR(50) NOT NULL);" +
        
        			" CREATE TABLE MANAGEMENT(" + " ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
        			+ " TITLE VARCHAR(100) NOT NULL," + " USERNAME VARCHAR(100) NOT NULL,"
        			+ " PASSWORD VARCHAR(255) NOT NULL," + " URL VARCHAR(255) NOT NULL,"
        			+ " CATEGORYID INT NOT NULL," + " COMMENT VARCHAR(255) NOT NULL);";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
            "The database can't create. Please try again: " + e.getMessage(), "Create database...",
            JOptionPane.ERROR_MESSAGE);
      }

    }
  }

    /**
     * Insert data.
     *
     * @param passwordModel
     *            the password model
     * @return true, if successful
     */
    private static boolean insertData(PasswordModel passwordModel) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	boolean status = false;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = "INSERT INTO MANAGEMENT (TITLE, USERNAME, PASSWORD, URL, CATEGORYID, COMMENT) "
		    + " VALUES (?, ?, ?, ?, ?, ?)";

	    preparedStatement = connection.prepareStatement(sqlQuery);
	    preparedStatement.setString(1, passwordModel.getTitle());
	    preparedStatement.setString(2, passwordModel.getUserName());
	    preparedStatement.setString(3, passwordModel.getPassword());
	    preparedStatement.setString(4, passwordModel.getUrl());
	    preparedStatement.setInt(5, passwordModel.getCategory().getId());
	    preparedStatement.setString(6, passwordModel.getComment());

	    preparedStatement.executeUpdate();
	    status = true;

      } catch (SQLException se) {
        se.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        H2Connection.closePreparedStatement(preparedStatement);
        H2Connection.closeConnection(connection);
      }
      return status;
    }

    /**
     * Update row data.
     *
     * @param passwordModel
     *            the password model
     * @return true, if successful
     */
    private static boolean updateRowData(PasswordModel passwordModel) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	boolean status = false;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = " UPDATE MANAGEMENT SET TITLE = ?, USERNAME = ?, PASSWORD = ?, "
		    + " URL = ?, CATEGORYID = ?, COMMENT = ? WHERE ID = ?";

	    preparedStatement = connection.prepareStatement(sqlQuery);
	    preparedStatement.setString(1, passwordModel.getTitle());
	    preparedStatement.setString(2, passwordModel.getUserName());
	    preparedStatement.setString(3, passwordModel.getPassword());
	    preparedStatement.setString(4, passwordModel.getUrl());
	    preparedStatement.setInt(5, passwordModel.getCategory().getId());
	    preparedStatement.setString(6, passwordModel.getComment());
	    preparedStatement.setInt(7, passwordModel.getId());

	    preparedStatement.executeUpdate();
	    status = true;

      } catch (SQLException se) {
        se.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        H2Connection.closePreparedStatement(preparedStatement);
        H2Connection.closeConnection(connection);
      }
      return status;
    }

    /**
     * Change database password.
     *
     * @param newPassword
     *            the new password
     * @return true, if successful
     */
    private static boolean changeDatabasePassword(String newPassword) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	boolean status = false;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = "ALTER USER " + DATABASE_USERNAME + " SET PASSWORD ?";

	    preparedStatement = connection.prepareStatement(sqlQuery);
	    preparedStatement.setString(1, newPassword);

	    preparedStatement.executeUpdate();
	    status = true;

      } catch (SQLException se) {
        se.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        H2Connection.closePreparedStatement(preparedStatement);
        H2Connection.closeConnection(connection);
      }
      return status;
    }

    /**
     * Select data.
     *
     * @param condition
     *            the condition
     * @param category
     *            the category
     * @return the array list
     */
    private static ArrayList<PasswordModel> selectData(String condition, CategoryModel category) {
	ArrayList<PasswordModel> passwordList = null;

	Connection connection = null;
	ResultSet resultSet = null;
	PasswordModel passwordModel = null;
	CategoryModel categoryModel = null;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = " SELECT M.ID, M.TITLE, M.USERNAME, M.PASSWORD, M.URL, M.COMMENT, "
		    + " C.ID AS CATID, C.CATEGORY_NAME " + " FROM MANAGEMENT AS M " + " JOIN CATEGORY AS C "
		    + " WHERE M.CATEGORYID = C.ID";
	    if (!Util.isNullOrEmpty(condition)) {
		sqlQuery += " AND (LOWER(M.TITLE) LIKE LOWER('%" + condition + "%')"
			+ " OR LOWER(M.USERNAME) LIKE LOWER('%" + condition + "%')"
			+ " OR LOWER(M.PASSWORD) LIKE LOWER('%" + condition + "%')" + " OR LOWER(M.URL) LIKE LOWER('%"
			+ condition + "%')" + " OR LOWER(M.COMMENT) LIKE LOWER('%" + condition + "%'))";
	    }

	    if (category != null) {
		sqlQuery += " AND M.CATEGORYID = " + category.getId();
	    }

	    resultSet = H2Connection.queryDatabase(connection, sqlQuery);

	    passwordList = new ArrayList<PasswordModel>();

	    int cnt = 0;
	    while (resultSet.next()) {
		passwordModel = new PasswordModel();
		categoryModel = new CategoryModel();
		cnt++;

		passwordModel.setId(resultSet.getInt("ID"));
		passwordModel.setTitle(resultSet.getString("TITLE"));
		passwordModel.setUserName(resultSet.getString("USERNAME"));
		passwordModel.setPassword(resultSet.getString("PASSWORD"));
		passwordModel.setUrl(resultSet.getString("URL"));
		passwordModel.setComment(resultSet.getString("COMMENT"));

		categoryModel.setId(resultSet.getInt("CATID"));
		categoryModel.setName(resultSet.getString("CATEGORY_NAME"));
		passwordModel.setCategory(categoryModel);

		passwordModel.setCnt(cnt);

		passwordList.add(passwordModel);
	    }

      } catch (SQLException se) {
        se.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        H2Connection.closeResultSet(resultSet);
        H2Connection.closeConnection(connection);
      }
      return passwordList;
    }

    /**
     * Delete data.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    private static boolean deleteData(int id) {
	boolean statusDelete = false;

	PreparedStatement preparedStatement = null;
	Connection connection = H2Connection.getConnection(MainGUI.getDatabaseModel());
	if (connection != null) {
	    try {
		String sql = "DELETE FROM MANAGEMENT WHERE ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
		    statusDelete = true;
		}
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "The record can't be deleted. Please try again: " + e.getMessage(),
			"Delete records...", JOptionPane.ERROR_MESSAGE);
	    } finally {
		H2Connection.closeConnection(connection);
		H2Connection.closePreparedStatement(preparedStatement);
	    }
	}
	return statusDelete;
    }

    /**
     * Insert category data.
     *
     * @param categoryName
     *            the category name
     * @return true, if successful
     */
    private static boolean insertCategoryData(String categoryName) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	boolean status = false;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = "INSERT INTO CATEGORY (CATEGORY_NAME) VALUES (?)";

	    preparedStatement = connection.prepareStatement(sqlQuery);
	    preparedStatement.setString(1, categoryName);

	    preparedStatement.executeUpdate();
	    status = true;

	} catch (SQLException se) {
	    se.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    H2Connection.closePreparedStatement(preparedStatement);
	    H2Connection.closeConnection(connection);
	}
	return status;
    }

    /**
     * Gets the categories data.
     *
     * @param id
     *            the id
     * @return the categories data
     */
    private static Vector<CategoryModel> getCategoriesData(int id) {
	Vector<CategoryModel> categoryList = null;

	Connection connection = null;
	ResultSet resultSet = null;
	CategoryModel categoryModel = null;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = "SELECT * FROM CATEGORY ";
	    if (id > 0) {
		sqlQuery += " WHERE ID = " + id;
	    }

	    resultSet = H2Connection.queryDatabase(connection, sqlQuery);

	    categoryList = new Vector<CategoryModel>();
	    categoryList.add(null);
	    while (resultSet.next()) {
		categoryModel = new CategoryModel();
		categoryModel.setId(resultSet.getInt("ID"));
		categoryModel.setName(resultSet.getString("CATEGORY_NAME"));
		categoryList.add(categoryModel);
	    }

	} catch (SQLException se) {
	    se.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    H2Connection.closeResultSet(resultSet);
	    H2Connection.closeConnection(connection);
	}
	return categoryList;
    }

    /**
     * Category can delete.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    private static boolean categoryCanDelete(int id) {
	boolean isAssigned = false;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	try {
	    connection = H2Connection.getConnection(MainGUI.getDatabaseModel());

	    String sqlQuery = "SELECT * FROM MANAGEMENT WHERE CATEGORYID = ? ";
	    preparedStatement = connection.prepareStatement(sqlQuery);
	    preparedStatement.setInt(1, id);

	    ResultSet rows = preparedStatement.executeQuery();
	    if (rows.next()) {
		isAssigned = true;
	    }

	} catch (SQLException se) {
	    se.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    H2Connection.closeConnection(connection);
	}
	return isAssigned;
    }

    /**
     * Delete category data.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    private static boolean deleteCategoryData(int id) {
	boolean statusDelete = false;

	PreparedStatement preparedStatement = null;
	Connection connection = H2Connection.getConnection(MainGUI.getDatabaseModel());
	if (connection != null) {
	    try {
		String sql = "DELETE FROM CATEGORY WHERE ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
		    statusDelete = true;
		}
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "The record can't be deleted. Please try again: " + e.getMessage(),
			"Delete records...", JOptionPane.ERROR_MESSAGE);
	    } finally {
		H2Connection.closeConnection(connection);
		H2Connection.closePreparedStatement(preparedStatement);
	    }
	}
	return statusDelete;
    }

    /**
     * Can delete category.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    public static boolean canDeleteCategory(int id) {
	return categoryCanDelete(id);
    }

    /**
     * Delete category.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    public static boolean deleteCategory(int id) {
	return deleteCategoryData(id);
    }

    /**
     * New database.
     */
    public static void newDatabase() {
	createDatabase();
    }

    /**
     * Insert new data.
     *
     * @param passwordModel
     *            the password model
     * @return true, if successful
     */
    public static boolean insertNewData(PasswordModel passwordModel) {
	return insertData(passwordModel);
    }

    /**
     * Update data.
     *
     * @param passwordModel
     *            the password model
     * @return true, if successful
     */
    public static boolean updateData(PasswordModel passwordModel) {
	return updateRowData(passwordModel);
    }

    /**
     * Gets the all password data.
     *
     * @param condition
     *            the condition
     * @param categoryModel
     *            the category model
     * @return the all password data
     */
    public static ArrayList<PasswordModel> getAllPasswordData(String condition, CategoryModel categoryModel) {
	return selectData(condition, categoryModel);
    }

    /**
     * Delete record.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    public static boolean deleteRecord(int id) {
	return deleteData(id);
    }

    /**
     * Change password db.
     *
     * @param newPassword
     *            the new password
     * @return true, if successful
     */
    public static boolean changePasswordDb(String newPassword) {
	return changeDatabasePassword(newPassword);
    }

    /**
     * Gets the categories.
     *
     * @param id
     *            the id
     * @return the categories
     */
    public static Vector<CategoryModel> getCategories(int id) {
	return getCategoriesData(id);
    }

    /**
     * Insert category.
     *
     * @param categoryName
     *            the category name
     * @return true, if successful
     */
    public static boolean insertCategory(String categoryName) {
	return insertCategoryData(categoryName);
    }
}
