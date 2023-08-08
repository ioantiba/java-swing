package org.ownbit.password.manager.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * The Class CustomTableCellRenderer.
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The original. */
    private TableCellRenderer original;

    /**
     * Instantiates a new custom table cell renderer.
     *
     * @param original the original
     */
    public CustomTableCellRenderer(TableCellRenderer original) {
	super();
	this.original = original;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	    int row, int column) {

	Component component = original.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	component.setFont(new Font("Times New Romana", Font.BOLD, 14));

	this.setHorizontalAlignment(SwingConstants.CENTER);

	UIManager.put("Table.alternateRowColor", Color.GREEN);
	table.setRowHeight(25);
	table.getColumnModel().getColumn(0).setPreferredWidth(10);
	table.getTableHeader().setPreferredSize(new Dimension((int) table.getTableHeader().getSize().getWidth(), 27));

	return component;
    }
}