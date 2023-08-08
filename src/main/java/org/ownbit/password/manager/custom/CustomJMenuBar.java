package org.ownbit.password.manager.custom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import org.ownbit.password.manager.export.Excel;
import org.ownbit.password.manager.gui.AboutGUI;
import org.ownbit.password.manager.gui.ChangePasswordGUI;
import org.ownbit.password.manager.gui.EmailGUI;
import org.ownbit.password.manager.gui.EntryGUI;
import org.ownbit.password.manager.gui.GeneratePasswordGUI;
import org.ownbit.password.manager.gui.MainGUI;
import org.ownbit.password.manager.gui.NewDatabaseGUI;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.table.CustomTableModel;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.FileTypeFilter;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

/**
 * The Class CustomJMenuBar.
 */
public class CustomJMenuBar extends JMenuBar implements LanguageKey {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The table. */
  private JTable table;

  /**
   * Instantiates a new custom J menu bar.
   */
  public CustomJMenuBar() {
    super();

    add(Box.createRigidArea(new Dimension(5, 35)));

    JMenu menuFile = new JMenu(S_MENU_FILE);
    menuFile.setMnemonic(KeyEvent.VK_F);
    menuFile.setIcon(Util.createImageIconBut(Constants.IMG_MENU_FILE, Constants.IMG_DEFAULT_WIDTH,
        Constants.IMG_DEFAULT_HEIGHT));

    JMenu menuTools = new JMenu(S_MENU_TOOLS);
    menuTools.setMnemonic(KeyEvent.VK_T);
    menuTools.setIcon(Util.createImageIconBut(Constants.IMG_MENU_TOOLS, Constants.IMG_DEFAULT_WIDTH,
        Constants.IMG_DEFAULT_HEIGHT));

    JMenu menuHelp = new JMenu(S_MENU_HELP);
    menuHelp.setMnemonic(KeyEvent.VK_H);
    menuHelp.setIcon(Util.createImageIconBut(Constants.IMG_MENU_HELP, Constants.IMG_DEFAULT_WIDTH,
        Constants.IMG_DEFAULT_HEIGHT));

    JMenuItem newDatabaseItem = new JMenuItem(S_MENU_FILE_NEW_DB,
        Util.createImageIconBut(Constants.IMG_MENU_FILE_NEW_DATABASE, Constants.IMG_DEFAULT_WIDTH,
            Constants.IMG_DEFAULT_HEIGHT));
    newDatabaseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.ALT_DOWN_MASK));
    newDatabaseItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        if (MainGUI.getDatabaseModel() != null) {
          JOptionPane.showMessageDialog(null, S_MENU_FILE_MSG_CLOSE_DB_B,
              S_MENU_FILE_MSG_CLOSE_DB_H, JOptionPane.WARNING_MESSAGE);
        } else {
          NewDatabaseGUI newDatabaseGUI = new NewDatabaseGUI();
          newDatabaseGUI.setVisible(true);
        }
      }
    });

    JMenuItem closeDatabase = new JMenuItem(S_MENU_FILE_CLOSE_DB,
        Util.createImageIconBut(Constants.IMG_BUT_DATABASE_CLOSE, Constants.IMG_DEFAULT_WIDTH,
            Constants.IMG_DEFAULT_HEIGHT));
    closeDatabase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.ALT_DOWN_MASK));
    closeDatabase.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        MainGUI.closeDatabase();
      }
    });

    JMenuItem openFileItem = new JMenuItem(S_MENU_FILE_OPEN_DB,
        Util.createImageIconBut(Constants.IMG_MENU_FILE_FOLDER_OPEN, Constants.IMG_DEFAULT_WIDTH,
            Constants.IMG_DEFAULT_HEIGHT));
    openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.ALT_DOWN_MASK));
    openFileItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        MainGUI.callBrowseButton();
      }
    });

    JMenuItem exitItem =
        new JMenuItem(S_MENU_FILE_EXIT, Util.createImageIconBut(Constants.IMG_MENU_FILE_EXIT,
            Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_DOWN_MASK));
    exitItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    JMenuItem generatePassItem = new JMenuItem(S_MENU_TOOLS_GEN_PASS,
        Util.createImageIconBut(Constants.IMG_MENU_TOOLS_GENERATE_PASSWORD,
            Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    generatePassItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_DOWN_MASK));
    generatePassItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        GeneratePasswordGUI genPassword = new GeneratePasswordGUI();
        genPassword.setVisible(true);
      }
    });

    JMenuItem changePassItem = new JMenuItem(S_MENU_TOOLS_CHANGE_DB_PASS,
        Util.createImageIconBut(Constants.IMG_MENU_TOOLS_CHANGE, Constants.IMG_DEFAULT_WIDTH,
            Constants.IMG_DEFAULT_HEIGHT));
    changePassItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_DOWN_MASK));
    changePassItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {

        if (MainGUI.getDatabaseModel() == null) {
          JOptionPane.showMessageDialog(null, S_MENU_TOOLS_MSG_OPEN_DB_B,
              S_MENU_TOOLS_MSG_OPEN_DB_H, JOptionPane.INFORMATION_MESSAGE);
        } else {
          ChangePasswordGUI changePasswordGUI = new ChangePasswordGUI();
          changePasswordGUI.setVisible(true);
        }
      }

    });

    JMenuItem exportExcelItem = new JMenuItem(S_MENU_TOOLS_EXP_EXCEL, Util.createImageIconBut(
        Constants.IMG_BUT_EXPORT_EXCEL, Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    exportExcelItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.ALT_DOWN_MASK));
    exportExcelItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {

        if (MainGUI.getPasswordList() != null) {

          FileFilter xlsFilter = new FileTypeFilter(".xls", "Microsoft Excel Documents");

          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle(S_MENU_TOOLS_EXP_EXCEL_DLG_TITLE);
          fileChooser.addChoosableFileFilter(xlsFilter);

          int userSelection = fileChooser.showSaveDialog(null);
          if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getPath();
            if (!filePath.toLowerCase().endsWith(".xls")) {
              fileToSave = new File(filePath + ".xls");
            }

            ArrayList<PasswordModel> list = MainGUI.getPasswordList();
            Excel.generateExcelFile(list, fileToSave);
          }

        } else {
          JOptionPane.showMessageDialog(null, S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_B,
              S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_H, JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });

    JMenuItem sendEmailItem =
        new JMenuItem(S_MENU_TOOLS_SEND_EMAIL, Util.createImageIconBut(Constants.IMG_BUT_SEND_EMAIL,
            Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    sendEmailItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.ALT_DOWN_MASK));
    sendEmailItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        if (MainGUI.getPasswordList() != null) {
          table = MainGUI.getJTable();
          CustomTableModel tableModel = (CustomTableModel) table.getModel();

          int selectedRow = table.getSelectedRow();
          if (selectedRow != -1) {
            PasswordModel selectedData = tableModel.getRowAt(selectedRow);
            EmailGUI emailGUI = new EmailGUI(selectedData);
            emailGUI.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(null, S_MENU_TOOLS_MSG_SEL_ROW_B,
                S_MENU_TOOLS_MSG_SEL_ROW_H, JOptionPane.WARNING_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(null, S_MENU_TOOLS_MSG_TABLE_EMTY_B,
              S_MENU_TOOLS_MSG_TABLE_EMTY_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    JMenuItem newEntryItem = new JMenuItem(S_MENU_TOOLS_NEW_ENTRY,
        Util.createImageIconBut(Constants.IMG_MENU_TOOLS_NEW_ENTRY, Constants.IMG_DEFAULT_WIDTH,
            Constants.IMG_DEFAULT_HEIGHT));
    newEntryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_DOWN_MASK));
    newEntryItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        if (!Util.isNullOrEmpty(MainGUI.getDatabaseName().getText())) {
          EntryGUI entryGui = new EntryGUI();
          entryGui.setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, S_MENU_TOOLS_MSG_NEW_ENTRY_B,
              S_MENU_TOOLS_MSG_NEW_ENTRY_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    JMenuItem helpAboutItem =
        new JMenuItem(S_MENU_HELP_ABOUT, Util.createImageIconBut(Constants.IMG_MENU_HELP_INFO,
            Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    helpAboutItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        AboutGUI aboutGUI = new AboutGUI();
        aboutGUI.setVisible(true);
      }
    });

    menuFile.add(newDatabaseItem);
    menuFile.addSeparator();
    menuFile.add(closeDatabase);
    menuFile.addSeparator();
    menuFile.add(openFileItem);
    menuFile.addSeparator();
    menuFile.add(exitItem);

    menuTools.add(newEntryItem);
    menuTools.addSeparator();
    menuTools.add(generatePassItem);
    menuTools.addSeparator();
    menuTools.add(changePassItem);
    menuTools.addSeparator();
    menuTools.add(exportExcelItem);
    menuTools.addSeparator();
    menuTools.add(sendEmailItem);

    menuHelp.add(helpAboutItem);

    add(menuFile);
    add(menuTools);
    add(menuHelp);

    add(Box.createHorizontalGlue());
    add(MainGUI.getDatabaseName(), BorderLayout.EAST);
    add(Box.createRigidArea(new Dimension(35, 35)));
  }
}
