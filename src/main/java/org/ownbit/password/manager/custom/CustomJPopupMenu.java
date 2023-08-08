package org.ownbit.password.manager.custom;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import org.ownbit.password.manager.gui.EmailGUI;
import org.ownbit.password.manager.gui.MainGUI;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.table.CustomTableModel;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

/**
 * The Class CustomJPopupMenu.
 */
public class CustomJPopupMenu extends JPopupMenu implements LanguageKey {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The table. */
  private JTable table;

  /**
   * Instantiates a new custom J popup menu.
   */
  public CustomJPopupMenu() {
    super();
    initializeComponent();
  }

  /**
   * Initialize component.
   */
  private void initializeComponent() {

    JMenuItem deleteItem = new JMenuItem(S_MENU_POPUP_BUT_DELETE);
    deleteItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_POPUP_DELETE,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    deleteItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        table = MainGUI.getJTable();
        CustomTableModel tableModel = (CustomTableModel) table.getModel();

        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {

          PasswordModel selectedData = tableModel.getRowAt(selectedRow);
          int dialogResult = JOptionPane.showConfirmDialog(null, S_MENU_POPUP_MSG_CONFIRM_DELETE_B,
              S_MENU_POPUP_MSG_CONFIRM_DELETE_H, JOptionPane.YES_NO_OPTION);
          if (dialogResult == JOptionPane.YES_OPTION) {

            boolean statusDelete = BaseService.deleteRecord(selectedData.getId());
            if (statusDelete) {
              JOptionPane.showMessageDialog(null, S_MENU_POPUP_MSG_DELETED_SUCCESS_B,
                  S_MENU_POPUP_MSG_DELETED_SUCCESS_H, JOptionPane.INFORMATION_MESSAGE);

              ArrayList<PasswordModel> dataList = BaseService.getAllPasswordData(null, null);
              MainGUI.loadTable(dataList);
            } else {
              JOptionPane.showMessageDialog(null, S_MENU_POPUP_MSG_DELETE_ERROR_B,
                  S_MENU_POPUP_MSG_DELETE_ERROR_H, JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          JOptionPane.showMessageDialog(null, S_MENU_POPUP_MSG_SELECT_ROW_B,
              S_MENU_POPUP_MSG_SELECT_ROW_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    JMenuItem redirectItem = new JMenuItem(S_MENU_POPUP_BUT_ACCESS_URL);
    redirectItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_POPUP_REDIRECT_ADDRESS,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    redirectItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        table = MainGUI.getJTable();
        CustomTableModel tableModel = (CustomTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
          PasswordModel selectedData = tableModel.getRowAt(selectedRow);
          String webPage = selectedData.getUrl();

          try {
            Desktop.getDesktop().browse(URI.create(webPage));
          } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe, ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    JMenuItem copyUsernameItem = new JMenuItem(S_MENU_POPUP_BUT_COPY_USERNAME);
    copyUsernameItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_POPUP_COPY,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    copyUsernameItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        table = MainGUI.getJTable();
        CustomTableModel tableModel = (CustomTableModel) table.getModel();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
          PasswordModel selectedData = tableModel.getRowAt(selectedRow);

          StringSelection stringSelection = new StringSelection(selectedData.getUserName());
          clipboard.setContents(stringSelection, null);
        }
      }
    });

    JMenuItem copyPasswordItem = new JMenuItem(S_MENU_POPUP_BUT_COPY_PASSWORD);
    copyPasswordItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_POPUP_COPY,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    copyPasswordItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        table = MainGUI.getJTable();
        CustomTableModel tableModel = (CustomTableModel) table.getModel();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
          PasswordModel selectedData = tableModel.getRowAt(selectedRow);

          StringSelection stringSelection = new StringSelection(selectedData.getPassword());
          clipboard.setContents(stringSelection, null);
        }
      }
    });

    JMenuItem copyCellItem = new JMenuItem(S_MENU_POPUP_BUT_COPY_CELL);
    copyCellItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_POPUP_CELL,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    copyCellItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        table = MainGUI.getJTable();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();
        Object selectedCellValue = table.getValueAt(selectedRow, selectedColumn);

        if (selectedCellValue != null) {
          StringSelection stringSelection = new StringSelection(selectedCellValue.toString());
          clipboard.setContents(stringSelection, null);
        }
      }
    });

    JMenuItem sendEmailItem = new JMenuItem(S_MENU_POPUP_BUT_SEND_EMAIL);
    sendEmailItem.setIcon(Util.createImageIconBut(Constants.IMG_BUT_SEND_EMAIL,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    sendEmailItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        table = MainGUI.getJTable();
        CustomTableModel tableModel = (CustomTableModel) table.getModel();

        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
          PasswordModel selectedData = tableModel.getRowAt(selectedRow);

          EmailGUI emailGUI = new EmailGUI(selectedData);
          emailGUI.setVisible(true);
        }
      }
    });

    add(redirectItem);
    addSeparator();
    add(copyUsernameItem);
    add(copyPasswordItem);
    addSeparator();
    add(copyCellItem);
    addSeparator();
    add(deleteItem);
    addSeparator();
    add(sendEmailItem);
  }
}
