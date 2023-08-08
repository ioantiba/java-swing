package org.ownbit.password.manager.custom;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;

/**
 * The Class CustomSystemTray.
 */
public class CustomSystemTray extends JFrame implements LanguageKey {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The popupmenu. */
  private PopupMenu popupmenu;

  /** The menu item. */
  private MenuItem menuItem;

  /** The icon tray. */
  private TrayIcon iconTray;

  /** The system tray. */
  private SystemTray systemTray = null;

  /**
   * Instantiates a new custom system tray.
   */
  public CustomSystemTray() {
    initSystemTray();
  }

  /**
   * Inits the system tray.
   */
  private void initSystemTray() {
    if (SystemTray.isSupported()) {
      popupmenu = new PopupMenu();

      menuItem = new MenuItem(S_SISTEM_TRAY_EXIT);
      menuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent exx) {
          System.exit(0);
        }
      });
      popupmenu.add(menuItem);

      systemTray = SystemTray.getSystemTray();

      // URL url = CustomSystemTray.class.getClassLoader().getResource(Constants.IMG_TRAY_ICON);
      Image img = Toolkit.getDefaultToolkit().getImage(Constants.IMG_TRAY_ICON);
      iconTray = new TrayIcon(img, S_SISTEM_TRAY_MOVED, popupmenu);
      iconTray.setImageAutoSize(true);

      iconTray.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (e.getButton() == MouseEvent.BUTTON1) {
            setVisible(true);
            setExtendedState(JFrame.NORMAL);
          }
        }
      });

      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }

        public void windowIconified(WindowEvent ex) {
          setVisible(false);
          try {
            systemTray.add(iconTray);
          } catch (AWTException e) {
            e.printStackTrace();
          }
          iconTray.displayMessage(S_SISTEM_TRAY_RESTORE_H, S_SISTEM_TRAY_RESTORE_B,
              TrayIcon.MessageType.INFO);
        }

        public void windowDeiconified(WindowEvent ex) {
          SystemTray.getSystemTray().remove(iconTray);
        }
      });
    }
  }
}
