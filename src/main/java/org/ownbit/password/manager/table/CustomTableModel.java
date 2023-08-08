package org.ownbit.password.manager.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.utils.LanguageKey;

/**
 * The Class CustomTableModel.
 */
public class CustomTableModel extends AbstractTableModel implements LanguageKey {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The password list. */
    private final List<PasswordModel> passwordList;
    
    /** The Constant HIDDEN_INDEX. */
    private static final int HIDDEN_INDEX = 0;
    
    /** The Constant TITLE_INDEX. */
    public static final int TITLE_INDEX = 1;
    
    /** The Constant USERNAME_INDEX. */
    public static final int USERNAME_INDEX = 2;
    
    /** The Constant PASSWORD_INDEX. */
    public static final int PASSWORD_INDEX = 3;
    
    /** The Constant URL_INDEX. */
    public static final int URL_INDEX = 4;
    
    /** The Constant COMMENT_INDEX. */
    public static final int COMMENT_INDEX = 5;

    /** The column names. */
    private final String[] columnNames = new String[] { S_TABLE_COLUMN_ID, S_TABLE_COLUMN_TITLE,
	    S_TABLE_COLUMN_USERNAME, S_TABLE_COLUMN_PASSWORD, S_TABLE_COLUMN_URL, S_TABLE_COLUMN_COMMENT };
    
    /** The column class. */
    private final Class<?>[] columnClass = new Class[] { Integer.class, String.class, String.class, String.class,
	    String.class, String.class };

    /**
     * Instantiates a new custom table model.
     *
     * @param passwordList the password list
     */
    public CustomTableModel(List<PasswordModel> passwordList) {
	this.passwordList = passwordList;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int column) {
	return columnNames[column];
    }

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	return columnClass[columnIndex];
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
	return columnNames.length;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
	return passwordList.size();
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	PasswordModel row = passwordList.get(rowIndex);
	switch (columnIndex) {
	case HIDDEN_INDEX:
	    return row.getCnt();
	case TITLE_INDEX:
	    return row.getTitle();
	case USERNAME_INDEX:
	    return row.getUserName();
	case PASSWORD_INDEX:
	    return row.getPassword();
	case URL_INDEX:
	    return row.getUrl();
	case COMMENT_INDEX:
	    return row.getComment();
	default:
	    return new String();
	}
    }

    /**
     * Gets the row at.
     *
     * @param rowIndex the row index
     * @return the row at
     */
    public PasswordModel getRowAt(int rowIndex) {
	PasswordModel row = passwordList.get(rowIndex);
	return row;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
     */
    @Override
    public boolean isCellEditable(int row, int column) {
	/*
	 * if (column == HIDDEN_INDEX) { return false; } else { return true; }
	 */
	return false;
    }
}