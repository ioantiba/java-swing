package org.ownbit.password.manager.model;

/**
 * The Class CategoryModel.
 */
public class CategoryModel {

    /** The id. */
    private int id;
    
    /** The name. */
    private String name;

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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
	this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return this.name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	int hashCode = (String.valueOf(this.id).hashCode()) + this.name.hashCode();
	result = PRIME * result + hashCode;
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	return (obj != null && obj instanceof CategoryModel && ((CategoryModel) obj).getId() == this.getId())
		&& ((CategoryModel) obj).getName().equalsIgnoreCase(this.getName());
    }
}
