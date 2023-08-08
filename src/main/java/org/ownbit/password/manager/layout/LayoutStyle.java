package org.ownbit.password.manager.layout;

import java.awt.Container;
import java.lang.reflect.Method;

import javax.swing.JComponent;

/**
 * The Class LayoutStyle.
 */
public abstract class LayoutStyle {

    /**
     * The Class DefaultLayoutStyle.
     */
    private static class DefaultLayoutStyle extends LayoutStyle {

	/*
	 * @see net.java.jdf.layouts.LayoutStyle#getContainerGap(javax.swing.
	 * JComponent , int, java.awt.Container)
	 */
	@Override
	public int getContainerGap(JComponent component, int position, Container parent) {
	    return 12;
	}

	/*
	 * @see net.java.jdf.layouts.LayoutStyle#getPreferredGap(javax.swing.
	 * JComponent , javax.swing.JComponent,
	 * net.java.jdf.layouts.LayoutStyle.ComponentPlacement, int,
	 * java.awt.Container)
	 */
	@Override
	public int getPreferredGap(JComponent component1, JComponent component2, ComponentPlacement type, int position,
		Container parent) {
	    switch (type) {
	    case RELATED:
		return 6;
	    case UNRELATED:
		return 12;
	    case INDENT:
		return 12;
	    }
	    return 12;
	}
    }

    /**
     * The Class Java6LayoutStyle.
     */
    private static class Java6LayoutStyle extends LayoutStyle {

	/** The java6 layout style class. */
	private static Class<?> java6LayoutStyleClass;

	/** The java6 component placement class. */
	private static Class<?> java6ComponentPlacementClass;

	/** The style. */
	private Object style;

	/** The get container gap. */
	private static Method getContainerGap;

	/** The get preferred gap. */
	private static Method getPreferredGap;

	/** The value of. */
	private static Method valueOf;

	/**
	 * Instantiates a new java6 layout style.
	 */
	public Java6LayoutStyle() {
	    if (java6LayoutStyleClass == null) {
		try {
		    java6LayoutStyleClass = Class.forName("javax.swing.LayoutStyle");
		    java6ComponentPlacementClass = Class.forName("javax.swing.LayoutStyle$ComponentPlacement");
		    getContainerGap = java6LayoutStyleClass.getMethod("getContainerGap", JComponent.class, int.class,
			    Container.class);
		    getPreferredGap = java6LayoutStyleClass.getMethod("getPreferredGap", JComponent.class,
			    JComponent.class, java6ComponentPlacementClass, int.class, Container.class);
		    valueOf = java6ComponentPlacementClass.getMethod("valueOf", String.class);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	    try {
		Method method = java6LayoutStyleClass.getMethod("getInstance");
		style = method.invoke(null);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	/*
	 * @see net.java.jdf.layouts.LayoutStyle#getContainerGap(javax.swing.
	 * JComponent , int, java.awt.Container)
	 */
	@Override
	public int getContainerGap(JComponent component, int position, Container parent) {
	    try {
		return ((Integer) getContainerGap.invoke(style, component, position, parent));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return 12;
	}

	/*
	 * @see net.java.jdf.layouts.LayoutStyle#getPreferredGap(javax.swing.
	 * JComponent , javax.swing.JComponent,
	 * net.java.jdf.layouts.LayoutStyle.ComponentPlacement, int,
	 * java.awt.Container)
	 */
	@Override
	public int getPreferredGap(JComponent component1, JComponent component2, ComponentPlacement type, int position,
		Container parent) {
	    try {
		Object enumType = valueOf.invoke(null, type.name());
		return ((Integer) getPreferredGap.invoke(style, component1, component2, enumType, position, parent));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return 12;
	}
    }

    /** The singleton5. */
    private static LayoutStyle singleton5 = new DefaultLayoutStyle();

    /** The singleton6. */
    private static LayoutStyle singleton6;

    /**
     * Gets the single instance of LayoutStyle.
     * 
     * @return single instance of LayoutStyle
     */
    public static LayoutStyle getInstance() {
	String version = System.getProperty("java.version");
	if (version.startsWith("1.6")) {
	    if (singleton6 == null)
		singleton6 = new Java6LayoutStyle();
	    return singleton6;
	} else
	    return singleton5;
    }

    /**
     * The Enum ComponentPlacement.
     */
    public enum ComponentPlacement {

	/** The RELATED. */
	RELATED,
	/** The UNRELATED. */
	UNRELATED,
	/** The INDENT. */
	INDENT;
    }

    /**
     * Gets the container gap.
     * 
     * @param component
     *            the component
     * @param position
     *            the position
     * @param parent
     *            the parent
     * @return the container gap
     */
    public abstract int getContainerGap(JComponent component, int position, Container parent);

    /**
     * Gets the preferred gap.
     * 
     * @param component1
     *            the component1
     * @param component2
     *            the component2
     * @param type
     *            the type
     * @param position
     *            the position
     * @param parent
     *            the parent
     * @return the preferred gap
     */
    public abstract int getPreferredGap(JComponent component1, JComponent component2, ComponentPlacement type,
	    int position, Container parent);
}
