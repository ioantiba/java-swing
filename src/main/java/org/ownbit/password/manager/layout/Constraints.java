package org.ownbit.password.manager.layout;

import java.io.Serializable;

/**
 * The Class Constraints.
 */
public class Constraints implements Serializable, Cloneable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The horizontal. */
    private Alignment horizontal;

    /** The vertical. */
    private Alignment vertical;

    /**
     * Instantiates a new constraints.
     * 
     * @param h
     *            the h
     * @param v
     *            the v
     */
    public Constraints(Alignment h, Alignment v) {
	this.horizontal = h;
	this.vertical = v;
    }

    /**
     * Gets the horizontal.
     * 
     * @return the horizontal
     */
    public Alignment getHorizontal() {
	return horizontal;
    }

    @Override
    public Object clone() {
	return new Constraints((Alignment) (horizontal == null ? null : horizontal.clone()),
		(Alignment) (vertical == null ? null : vertical.clone()));
    }

    /**
     * Gets the vertical.
     * 
     * @return the vertical
     */
    public Alignment getVertical() {
	return vertical;
    }

    /**
     * Sets the horizontal.
     * 
     * @param horizontal
     *            the new horizontal
     */
    public void setHorizontal(Alignment horizontal) {
	this.horizontal = horizontal;
    }

    /**
     * Sets the vertical.
     * 
     * @param vertical
     *            the new vertical
     */
    public void setVertical(Alignment vertical) {
	this.vertical = vertical;
    }
}
