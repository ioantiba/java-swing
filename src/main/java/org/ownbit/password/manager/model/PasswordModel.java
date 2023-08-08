package org.ownbit.password.manager.model;

/**
 * The Class PasswordModel.
 */
public class PasswordModel {

    /** The id. */
    private int id;
    
    /** The title. */
    private String title;
    
    /** The user name. */
    private String userName;
    
    /** The password. */
    private String password;
    
    /** The url. */
    private String url;
    
    /** The category. */
    private CategoryModel category;
    
    /** The comment. */
    private String comment;
    
    /** The cnt. */
    private int cnt;

    /**
     * Instantiates a new password model.
     */
    public PasswordModel() {
    }

    /**
     * Instantiates a new password model.
     *
     * @param id the id
     * @param title the title
     * @param userName the user name
     * @param password the password
     * @param url the url
     * @param comment the comment
     */
    public PasswordModel(int id, String title, String userName, String password, String url, String comment) {
	this.id = id;
	this.title = title;
	this.userName = userName;
	this.password = password;
	this.url = url;
	this.comment = comment;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
	return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
	return url;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(String url) {
	this.url = url;
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
	return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(String comment) {
	this.comment = comment;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public CategoryModel getCategory() {
	return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(CategoryModel category) {
	this.category = category;
    }

    /**
     * Gets the cnt.
     *
     * @return the cnt
     */
    public int getCnt() {
	return cnt;
    }

    /**
     * Sets the cnt.
     *
     * @param cnt the new cnt
     */
    public void setCnt(int cnt) {
	this.cnt = cnt;
    }
}
