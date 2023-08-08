package org.ownbit.password.manager.layout;

/**
 * The Class Leading.
 */
public class Leading extends Alignment {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The leading. */
    private int leading;

    /** The size. */
    private int size;

    /**
     * Instantiates a new leading.
     * 
     * @param leading
     *            the leading
     * @param size
     *            the size
     * @param spring
     *            the spring
     */
    public Leading(int leading, int size, Spring spring) {
	super(spring);
	this.leading = leading;
	this.size = size;
    }

    /**
     * Instantiates a new leading.
     * 
     * @param leading
     *            the leading
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Leading(int leading, int min, int pref) {
	this(leading, PREFERRED, min, pref);
    }

    /**
     * Instantiates a new leading.
     * 
     * @param leading
     *            the leading
     * @param size
     *            the size
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Leading(int leading, int size, int min, int pref) {
	super(min, pref);
	this.leading = leading;
	this.size = size;
    }

    /**
     * Gets the leading.
     * 
     * @return the leading
     */
    public int getLeading() {
	return leading;
    }

    /**
     * Gets the size.
     * 
     * @return the size
     */
    public int getSize() {
	return size;
    }

    /**
     * Sets the size.
     * 
     * @param size
     *            the new size
     */
    public void setSize(int size) {
	this.size = size;
    }

    /**
     * Sets the leading.
     * 
     * @param leading
     *            the new leading
     */
    public void setLeading(int leading) {
	this.leading = leading;
    }

    @Override
    public Object clone() {
	return new Leading(leading, size, (Spring) getSpring().clone());
    }
}
