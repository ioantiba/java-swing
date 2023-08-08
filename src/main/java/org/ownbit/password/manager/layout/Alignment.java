package org.ownbit.password.manager.layout;

import java.io.Serializable;

/**
 * The Class Alignment.
 */
public abstract class Alignment implements Serializable, Cloneable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant PREFERRED. */
    public static final int PREFERRED = -1;

    /** The spring. */
    private Spring spring;

    /**
     * Instantiates a new alignment.
     * 
     * @param spring
     *            the spring
     */
    public Alignment(Spring spring) {
	this.spring = spring;
    }

    /**
     * Instantiates a new alignment.
     * 
     * @param min
     *            the min
     * @param pref
     *            the pref
     */
    public Alignment(int min, int pref) {
	this.spring = new Spring(min, pref);
    }

    /**
     * Gets the spring.
     * 
     * @return the spring
     */
    public Spring getSpring() {
	return spring;
    }

    /**
     * Sets the spring.
     * 
     * @param spring
     *            the new spring
     */
    public void setSpring(Spring spring) {
	this.spring = spring;
    }

    @Override
    public abstract Object clone();
}
