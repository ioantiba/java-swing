package org.ownbit.password.manager.custom;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 * The Class CustomJRootPane.
 */
public class CustomJRootPane extends JRootPane {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new custom J root pane.
   *
   * @param rootPane the root pane
   * @param jDialog the j dialog
   */
  public CustomJRootPane(JRootPane rootPane, final JDialog jDialog) {
    rootPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "dispose");
    rootPane.getActionMap().put("dispose", new AbstractAction() {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent event) {
        jDialog.dispose();
      }
    });
  }
}
