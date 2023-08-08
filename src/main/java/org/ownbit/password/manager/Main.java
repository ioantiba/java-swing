package org.ownbit.password.manager;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import org.ownbit.password.manager.gui.MainGUI;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class Main implements LanguageKey {

  public static void main(String[] args) throws Exception {

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          if (!Util.isJavaInstalled()) {
            JOptionPane.showMessageDialog(null, S_SISTEM_RUNTIME_INSTALL_JAVA_B,
                S_SISTEM_RUNTIME_INSTALL_JAVA_H, JOptionPane.ERROR_MESSAGE);
          } else {
            new MainGUI().setVisible(true);
          }
        } catch (UnsupportedLookAndFeelException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
