package org.ownbit.password.manager.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

/**
 * The Class GroupLayout.
 */
public class GroupLayout implements LayoutManager2, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The constraints. */
    private HashMap<Component, Constraints> constraints;

    /**
     * Instantiates a new group layout.
     */
    public GroupLayout() {
	constraints = new HashMap<Component, Constraints>();
    }

    /**
     * Gets the constraints.
     * 
     * @param comp
     *            the comp
     * @return the constraints
     */
    public Constraints getConstraints(Component comp) {
	return constraints.get(comp);
    }

    /**
     * Sets the constraints.
     * 
     * @param comp
     *            the comp
     * @param constraint
     *            the constraint
     */
    public void setConstraints(Component comp, Constraints constraint) {
	constraints.put(comp, constraint);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.LayoutManager2#addLayoutComponent(java.awt.Component,
     * java.lang.Object)
     */
    public void addLayoutComponent(Component comp, Object con) {
	assert con != null && con instanceof Constraints;
	Constraints constraints = (Constraints) con;
	checkPreferredSize(comp, constraints);
	this.constraints.put(comp, constraints);
    }

    /**
     * Check preferred size.
     * 
     * @param comp
     *            the comp
     * @param constraints
     *            the constraints
     */
    private void checkPreferredSize(Component comp, Constraints constraints) {
	Dimension prefs = comp.getPreferredSize();
	Alignment axis = constraints.getHorizontal();
	if (axis instanceof Leading) {
	    Leading leading = (Leading) axis;
	    int size = leading.getSize();
	    if (size == prefs.width)
		leading.setSize(Alignment.PREFERRED);
	} else if (axis instanceof Trailing) {
	    Trailing trailing = (Trailing) axis;
	    int size = trailing.getSize();
	    if (size == prefs.width)
		trailing.setSize(Alignment.PREFERRED);
	} else if (axis instanceof Bilateral) {
	    Bilateral bilateral = (Bilateral) axis;
	    int pref = bilateral.getSpring().getPreferred();
	    if (pref == prefs.width)
		bilateral.getSpring().setPreferred(Alignment.PREFERRED);
	}
	axis = constraints.getVertical();
	if (axis instanceof Leading) {
	    Leading leading = (Leading) axis;
	    int size = leading.getSize();
	    if (size == prefs.height)
		leading.setSize(Alignment.PREFERRED);
	} else if (axis instanceof Trailing) {
	    Trailing trailing = (Trailing) axis;
	    int size = trailing.getSize();
	    if (size == prefs.height)
		trailing.setSize(Alignment.PREFERRED);
	} else if (axis instanceof Bilateral) {
	    Bilateral bilateral = (Bilateral) axis;
	    int pref = bilateral.getSpring().getPreferred();
	    if (pref == prefs.height)
		bilateral.getSpring().setPreferred(Alignment.PREFERRED);
	}
    }

    /*
     * @see java.awt.LayoutManager2#getLayoutAlignmentX(java.awt.Container)
     */
    public float getLayoutAlignmentX(Container target) {
	return 0;
    }

    /*
     * @see java.awt.LayoutManager2#getLayoutAlignmentY(java.awt.Container)
     */
    public float getLayoutAlignmentY(Container target) {
	return 0;
    }

    /*
     * @see java.awt.LayoutManager2#invalidateLayout(java.awt.Container)
     */
    public void invalidateLayout(Container target) {
    }

    /*
     * @see java.awt.LayoutManager2#maximumLayoutSize(java.awt.Container)
     */
    public Dimension maximumLayoutSize(Container target) {
	return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /*
     * @see java.awt.LayoutManager#addLayoutComponent(java.lang.String,
     * java.awt.Component)
     */
    public void addLayoutComponent(String name, Component comp) {
    }

    /*
     * @see java.awt.LayoutManager#layoutContainer(java.awt.Container)
     */
    public void layoutContainer(Container parent) {
	int width = parent.getWidth();
	int height = parent.getHeight();
	Dimension min = minimumLayoutSize(parent);
	if (width < min.width)
	    width = min.width;
	if (height < min.height)
	    height = min.height;
	int count = parent.getComponentCount();
	Insets insets = parent.getInsets();
	for (int i = 0; i < count; i++) {
	    Component comp = parent.getComponent(i);
	    if (comp == null)
		continue;
	    Constraints cons = constraints.get(comp);
	    if (cons == null)
		cons = createConstraintsFor(parent, comp);
	    Alignment horizontal = cons.getHorizontal();
	    Alignment vertical = cons.getVertical();
	    Rectangle bounds = comp.getBounds();
	    Dimension prefs = comp.getPreferredSize();
	    int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
	    if (horizontal instanceof Leading) {
		Leading leading = (Leading) horizontal;
		x = insets.left + leading.getLeading();
		int size = leading.getSize();
		w = size == Alignment.PREFERRED ? prefs.width : size;
	    } else if (horizontal instanceof Bilateral) {
		Bilateral bilateral = (Bilateral) horizontal;
		x = insets.left + bilateral.getLeading();
		w = width - x - bilateral.getTrailing() - insets.right;
	    } else if (horizontal instanceof Trailing) {
		Trailing trailing = (Trailing) horizontal;
		int size = trailing.getSize();
		w = size == Alignment.PREFERRED ? prefs.width : size;
		x = width - trailing.getTrailing() - w - insets.right;
	    }
	    if (vertical instanceof Leading) {
		Leading leading = (Leading) vertical;
		y = insets.top + leading.getLeading();
		int size = leading.getSize();
		h = size == Alignment.PREFERRED ? prefs.height : size;
	    } else if (vertical instanceof Bilateral) {
		Bilateral bilateral = (Bilateral) vertical;
		y = insets.top + bilateral.getLeading();
		h = height - y - bilateral.getTrailing() - insets.bottom;
	    } else if (vertical instanceof Trailing) {
		Trailing trailing = (Trailing) vertical;
		int size = trailing.getSize();
		h = size == Alignment.PREFERRED ? prefs.height : size;
		y = height - trailing.getTrailing() - h - insets.bottom;
	    }
	    comp.setBounds(x, y, w, h);
	}
    }

    /**
     * Creates the constraints for.
     * 
     * @param parent
     *            the parent
     * @param comp
     *            the comp
     * @return the constraints
     */
    private Constraints createConstraintsFor(Container parent, Component comp) {
	Constraints cons;
	LayoutStyle style = LayoutStyle.getInstance();
	int gap = style.getContainerGap((JComponent) comp, SwingConstants.EAST, parent);
	Rectangle bounds = comp.getBounds();
	Spring spring = new Spring(gap, gap);
	Leading horizontal = new Leading(bounds.x, bounds.width, spring);
	gap = style.getContainerGap((JComponent) comp, SwingConstants.SOUTH, parent);
	spring = new Spring(gap, gap);
	Leading vertical = new Leading(bounds.y, bounds.height, spring);
	cons = new Constraints(horizontal, vertical);
	constraints.put(comp, cons);
	return cons;
    }

    /*
     * @see java.awt.LayoutManager#minimumLayoutSize(java.awt.Container)
     */
    public Dimension minimumLayoutSize(Container parent) {
	int width = 0;
	int height = 0;
	int count = parent.getComponentCount();
	Insets insets = parent.getInsets();
	for (int i = 0; i < count; i++) {
	    Component comp = parent.getComponent(i);
	    if (comp == null)
		continue;
	    Dimension prefs = comp.getPreferredSize();
	    Constraints cons = constraints.get(comp);
	    if (cons == null)
		cons = createConstraintsFor(parent, comp);
	    Alignment horizontal = cons.getHorizontal();
	    Alignment vertical = cons.getVertical();
	    if (horizontal instanceof Bilateral) {
		Bilateral bialteral = (Bilateral) horizontal;
		if (bialteral.getLeading() + bialteral.getTrailing() + bialteral.getSpring().getMinimum() + insets.left
			+ insets.right > width)
		    width = bialteral.getLeading() + bialteral.getTrailing() + bialteral.getSpring().getMinimum()
			    + insets.left + insets.right;
	    } else if (horizontal instanceof Leading) {
		Leading leading = (Leading) horizontal;
		int size = leading.getSize() == Alignment.PREFERRED ? prefs.width : leading.getSize();
		if (leading.getLeading() + size + leading.getSpring().getMinimum() + insets.left + insets.right > width)
		    width = leading.getLeading() + size + leading.getSpring().getMinimum() + insets.left + insets.right;
	    } else if (horizontal instanceof Trailing) {
		Trailing trailing = (Trailing) horizontal;
		int size = trailing.getSize() == Alignment.PREFERRED ? prefs.width : trailing.getSize();
		if (trailing.getTrailing() + size + trailing.getSpring().getMinimum() + insets.left
			+ insets.right > width)
		    width = trailing.getTrailing() + size + trailing.getSpring().getMinimum() + insets.left
			    + insets.right;
	    }
	    if (vertical instanceof Bilateral) {
		Bilateral bilateral = (Bilateral) vertical;
		if (bilateral.getLeading() + bilateral.getTrailing() + bilateral.getSpring().getMinimum() + insets.top
			+ insets.bottom > height)
		    height = bilateral.getLeading() + bilateral.getTrailing() + bilateral.getSpring().getMinimum()
			    + insets.top + insets.bottom;
	    } else if (vertical instanceof Leading) {
		Leading leading = (Leading) vertical;
		int size = leading.getSize() == Alignment.PREFERRED ? prefs.height : leading.getSize();
		if (leading.getLeading() + size + leading.getSpring().getMinimum() + insets.top
			+ insets.bottom > height)
		    height = leading.getLeading() + size + leading.getSpring().getMinimum() + insets.top
			    + insets.bottom;
	    } else if (vertical instanceof Trailing) {
		Trailing trailing = (Trailing) vertical;
		int size = trailing.getSize() == Alignment.PREFERRED ? prefs.height : trailing.getSize();
		if (trailing.getTrailing() + size + trailing.getSpring().getMinimum() + insets.top
			+ insets.bottom > height)
		    height = trailing.getTrailing() + size + trailing.getSpring().getMinimum() + insets.top
			    + insets.bottom;
	    }
	}
	return new Dimension(width, height);
    }

    /*
     * @see java.awt.LayoutManager#preferredLayoutSize(java.awt.Container)
     */
    public Dimension preferredLayoutSize(Container parent) {
	int width = 0;
	int height = 0;
	int count = parent.getComponentCount();
	Insets insets = parent.getInsets();
	for (int i = 0; i < count; i++) {
	    Component comp = parent.getComponent(i);
	    if (comp == null)
		continue;
	    Dimension prefs = comp.getPreferredSize();
	    Constraints cons = constraints.get(comp);
	    if (cons == null)
		cons = createConstraintsFor(parent, comp);
	    Alignment horizontal = cons.getHorizontal();
	    Alignment vertical = cons.getVertical();
	    if (horizontal instanceof Bilateral) {
		Bilateral bilateral = (Bilateral) horizontal;
		int pref = bilateral.getSpring().getPreferred();
		pref = pref == Alignment.PREFERRED ? prefs.width : pref;
		if (bilateral.getLeading() + bilateral.getTrailing() + pref + insets.left + insets.right > width)
		    width = bilateral.getLeading() + bilateral.getTrailing() + pref + insets.left + insets.right;
	    } else if (horizontal instanceof Leading) {
		Leading leading = (Leading) horizontal;
		int size = leading.getSize() == Alignment.PREFERRED ? prefs.width : leading.getSize();
		if (leading.getLeading() + size + leading.getSpring().getPreferred() + insets.left
			+ insets.right > width)
		    width = leading.getLeading() + size + leading.getSpring().getPreferred() + insets.left
			    + insets.right;
	    } else if (horizontal instanceof Trailing) {
		Trailing trailing = (Trailing) horizontal;
		int size = trailing.getSize() == Alignment.PREFERRED ? prefs.width : trailing.getSize();
		if (trailing.getTrailing() + size + trailing.getSpring().getPreferred() + insets.left
			+ insets.right > width)
		    width = trailing.getTrailing() + size + trailing.getSpring().getPreferred() + insets.left
			    + insets.right;
	    }
	    if (vertical instanceof Bilateral) {
		Bilateral bilateral = (Bilateral) vertical;
		int pref = bilateral.getSpring().getPreferred();
		pref = pref == Alignment.PREFERRED ? prefs.height : pref;
		if (bilateral.getLeading() + bilateral.getTrailing() + pref + insets.top + insets.bottom > height)
		    height = bilateral.getLeading() + bilateral.getTrailing() + pref + insets.top + insets.bottom;
	    } else if (vertical instanceof Leading) {
		Leading leading = (Leading) vertical;
		int size = leading.getSize() == Alignment.PREFERRED ? prefs.height : leading.getSize();
		if (leading.getLeading() + size + leading.getSpring().getPreferred() + insets.top
			+ insets.bottom > height)
		    height = leading.getLeading() + size + leading.getSpring().getPreferred() + insets.top
			    + insets.bottom;
	    } else if (vertical instanceof Trailing) {
		Trailing trailing = (Trailing) vertical;
		int size = trailing.getSize() == Alignment.PREFERRED ? prefs.height : trailing.getSize();
		if (trailing.getTrailing() + size + trailing.getSpring().getPreferred() + insets.top
			+ insets.bottom > height)
		    height = trailing.getTrailing() + size + trailing.getSpring().getPreferred() + insets.top
			    + insets.bottom;
	    }
	}
	return new Dimension(width, height);
    }

    /*
     * @see java.awt.LayoutManager#removeLayoutComponent(java.awt.Component)
     */
    public void removeLayoutComponent(Component comp) {
	constraints.remove(comp);
    }
}
