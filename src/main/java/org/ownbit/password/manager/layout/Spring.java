package org.ownbit.password.manager.layout;

import java.io.Serializable;

/**
 * The Class Spring.
 */
public class Spring implements Serializable, Cloneable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The minimum. */
    private int minimum;

    /** The preferred. */
    private int preferred;

    /**
     * Instantiates a new spring.
     * 
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Spring(int min, int pref) {
	minimum = min;
	preferred = pref;
    }

    @Override
    public Object clone() {
	return new Spring(minimum, preferred);
    }

    /**
     * Gets the minimum.
     * 
     * @return the minimum
     */
    public int getMinimum() {
	return minimum;
    }

    /**
     * Sets the minimum.
     * 
     * @param minimum
     *            the new minimum
     */
    public void setMinimum(int minimum) {
	this.minimum = minimum;
    }

    /**
     * Gets the preferred.
     * 
     * @return the preferred
     */
    public int getPreferred() {
	return preferred;
    }

    /**
     * Sets the preferred.
     * 
     * @param preferred
     *            the new preferred
     */
    public void setPreferred(int preferred) {
	this.preferred = preferred;
    }
}
