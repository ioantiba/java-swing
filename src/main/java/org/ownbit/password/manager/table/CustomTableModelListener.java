package org.ownbit.password.manager.table;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * The listener interface for receiving customTableModel events.
 * The class that is interested in processing a customTableModel
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCustomTableModelListener<code> method. When
 * the customTableModel event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CustomTableModelEvent
 */
public class CustomTableModelListener implements TableModelListener {

    /** The table. */
    private JTable table;

    /**
     * Instantiates a new custom table model listener.
     *
     * @param table the table
     */
    public CustomTableModelListener(JTable table) {
	this.table = table;
    }

    /* (non-Javadoc)
     * @see javax.swing.event.TableModelListener#tableChanged(javax.swing.event.TableModelEvent)
     */
    public void tableChanged(TableModelEvent evt) {
	if (evt.getType() == TableModelEvent.UPDATE) {
	    int column = evt.getColumn();
	    int row = evt.getFirstRow();
	    table.setColumnSelectionInterval(column + 1, column + 1);
	    table.setRowSelectionInterval(row, row);
	}
    }
}