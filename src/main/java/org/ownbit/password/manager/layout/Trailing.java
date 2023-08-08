package org.ownbit.password.manager.layout;

/**
 * The Class Trailing.
 */
public class Trailing extends Alignment {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The trailing. */
    private int trailing;

    /** The size. */
    private int size;

    /**
     * Instantiates a new trailing.
     * 
     * @param trailing
     *            the trailing
     * @param size
     *            the size
     * @param spring
     *            the spring
     */
    public Trailing(int trailing, int size, Spring spring) {
	super(spring);
	this.trailing = trailing;
	this.size = size;
    }

    /**
     * Instantiates a new trailing.
     * 
     * @param trailing
     *            the trailing
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Trailing(int trailing, int min, int pref) {
	this(trailing, PREFERRED, min, pref);
    }

    /**
     * Instantiates a new trailing.
     * 
     * @param trailing
     *            the trailing
     * @param size
     *            the size
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Trailing(int trailing, int size, int min, int pref) {
	super(min, pref);
	this.trailing = trailing;
	this.size = size;
    }

    /**
     * Gets the trailing.
     * 
     * @return the trailing
     */
    public int getTrailing() {
	return trailing;
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
     * Sets the trailing.
     * 
     * @param trailing
     *            the new trailing
     */
    public void setTrailing(int trailing) {
	this.trailing = trailing;
    }

    @Override
    public Object clone() {
	return new Trailing(trailing, size, (Spring) getSpring().clone());
    }
}
