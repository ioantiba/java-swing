package org.ownbit.password.manager.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.ownbit.password.manager.model.DatabaseModel;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.Util;

/**
 * The Class H2Connection.
 */
public class H2Connection extends Constants {

    /** The connection. */
    private static Connection connection = null;
    
    /** The password database. */
    private static String passwordDatabase;
    
    /** The database path. */
    private static String databasePath;
    
    /** The database name. */
    private static String databaseName;

    /**
     * Creates the connection.
     *
     * @return the connection
     */
    private static synchronized Connection createConnection() {

	if (!Util.isNullOrEmpty(databaseName)) {
	    try {
		/* Load the sqlite-JDBC driver */
		Class.forName(DATABASE_DRIVER);

		String databaseNameWithoutExt = databasePath.split("\\.")[0];
		String databaseURL = "jdbc:h2://" + databaseNameWithoutExt
			+ ";TRACE_LEVEL_FILE=0;TRACE_LEVEL_SYSTEM_OUT=0;CIPHER=AES;";
		String password = DATABASE_ENCRYPT + " " + passwordDatabase;

		/* Create a database connection */
		connection = DriverManager.getConnection(databaseURL, DATABASE_USERNAME, password);
	    } catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
	    }
	} else {
	    JOptionPane.showMessageDialog(null, "The name of database is empty...", "Database Required...",
		    JOptionPane.ERROR_MESSAGE);
	}

	return connection;
    }

    /**
     * Gets the connection.
     *
     * @param databaseModel the database model
     * @return the connection
     */
    public static synchronized Connection getConnection(DatabaseModel databaseModel) {
	passwordDatabase = databaseModel.getPasswordDatabase();
	databasePath = databaseModel.getDatabasePath();
	databaseName = databaseModel.getDatabaseName();

	createConnection();

	return connection;
    }

    /**
     * Gets the h 2 connection.
     *
     * @return the h 2 connection
     */
    public static synchronized Connection getH2Connection() {
	if (connection == null) {
	    createConnection();
	    return connection;
	} else {
	    return connection;
	}
    }

    /**
     * Close result set.
     *
     * @param rs the rs
     */
    public static void closeResultSet(ResultSet rs) {
	if (rs != null) {
	    try {
		rs.close();
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e, "Error closing ResultSet", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    /**
     * Close prepared statement.
     *
     * @param ps the ps
     */
    public static void closePreparedStatement(PreparedStatement ps) {
	if (ps != null) {
	    try {
		ps.close();
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e, "Error closing PreperedStatement", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    /**
     * Close statement.
     *
     * @param stm the stm
     */
    public static void closeStatement(Statement stm) {
	if (stm != null) {
	    try {
		stm.close();
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e, "Error closing Statement", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    /**
     * Close connection.
     *
     * @param connection the connection
     */
    public static void closeConnection(Connection connection) {
	if (connection != null) {
	    try {
		connection.commit(); /*
				      * commit and close the connection only if
				      * it's not used for a transaction
				      */
		connection.close();
	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e, "Error closing Connection", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    /**
     * Query database.
     *
     * @param conn the conn
     * @param sql the sql
     * @return the result set
     * @throws SQLException the SQL exception
     */
    public static ResultSet queryDatabase(Connection conn, String sql) throws SQLException {
	return conn.createStatement().executeQuery(sql);
    }
}
