package org.ownbit.password.manager.model;

/**
 * The Class DatabaseModel.
 */
public class DatabaseModel {
    
    /** The password database. */
    private String passwordDatabase;
    
    /** The database name. */
    private String databaseName;
    
    /** The database path. */
    private String databasePath;

    /**
     * Gets the password database.
     *
     * @return the password database
     */
    public String getPasswordDatabase() {
	return passwordDatabase;
    }

    /**
     * Sets the password database.
     *
     * @param passwordDatabase the new password database
     */
    public void setPasswordDatabase(String passwordDatabase) {
	this.passwordDatabase = passwordDatabase;
    }

    /**
     * Gets the database name.
     *
     * @return the database name
     */
    public String getDatabaseName() {
	return databaseName;
    }

    /**
     * Sets the database name.
     *
     * @param databaseName the new database name
     */
    public void setDatabaseName(String databaseName) {
	this.databaseName = databaseName;
    }

    /**
     * Gets the database path.
     *
     * @return the database path
     */
    public String getDatabasePath() {
	return databasePath;
    }

    /**
     * Sets the database path.
     *
     * @param databasePath the new database path
     */
    public void setDatabasePath(String databasePath) {
	this.databasePath = databasePath;
    }
}