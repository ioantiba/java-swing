package org.ownbit.password.manager.layout;

/**
 * The Class Bilateral.
 */
public class Bilateral extends Alignment {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The leading. */
    private int leading;

    /** The trailing. */
    private int trailing;

    /**
     * Instantiates a new bilateral.
     * 
     * @param leading
     *            the leading
     * @param trailing
     *            the trailing
     * @param spring
     *            the spring
     */
    public Bilateral(int leading, int trailing, Spring spring) {
	super(spring);
	this.leading = leading;
	this.trailing = trailing;
    }

    /**
     * Instantiates a new bilateral.
     * 
     * @param leading
     *            the leading
     * @param trailing
     *            the trailing
     * @param min
     *            the min
     */
    public Bilateral(int leading, int trailing, int min) {
	this(leading, trailing, min, PREFERRED);
    }

    /**
     * Instantiates a new bilateral.
     * 
     * @param leading
     *            the leading
     * @param trailing
     *            the trailing
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Bilateral(int leading, int trailing, int min, int pref) {
	super(min, pref);
	this.leading = leading;
	this.trailing = trailing;
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
     * Gets the trailing.
     * 
     * @return the trailing
     */
    public int getTrailing() {
	return trailing;
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
	return new Bilateral(leading, trailing, (Spring) getSpring().clone());
    }

}
