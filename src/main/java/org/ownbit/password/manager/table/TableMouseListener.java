package org.ownbit.password.manager.table;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import org.ownbit.password.manager.gui.EntryGUI;
import org.ownbit.password.manager.model.PasswordModel;

/**
 * The listener interface for receiving tableMouse events. The class that is interested in
 * processing a tableMouse event implements this interface, and the object created with that class
 * is registered with a component using the component's <code>addTableMouseListener<code> method.
 * When the tableMouse event occurs, that object's appropriate method is invoked.
 *
 * @see TableMouseEvent
 */
public class TableMouseListener extends MouseAdapter {

  /** The table. */
  private JTable table;

  /**
   * Instantiates a new table mouse listener.
   *
   * @param table the table
   */
  public TableMouseListener(JTable table) {
    this.table = table;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
   */
  @Override
  public void mousePressed(MouseEvent event) {
    // selects the row at which point the mouse is clicked
    Point point = event.getPoint();
    int currentRow = table.rowAtPoint(point);
    if (currentRow != -1) {
      table.setRowSelectionInterval(currentRow, currentRow);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    super.mouseClicked(e);
    if (e.getClickCount() == 2) {
      JTable target = (JTable) e.getSource();
      int selectedRow = target.getSelectedRow();

      CustomTableModel tableModel = (CustomTableModel) table.getModel();
      PasswordModel selectedData = tableModel.getRowAt(selectedRow);

      EntryGUI entryGUI = new EntryGUI(selectedData);
      entryGUI.setVisible(true);
    }
  }
}
