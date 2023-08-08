package org.ownbit.password.manager.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class ChangePasswordGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel labelDatabaseSelect;
  private JTextField textDatabaseSelect;
  private JButton butBrowseDatabase;
  private JLabel labelPassword;
  private JTextField textPassword;
  private JButton butSave;

  public ChangePasswordGUI() {
    initUI();
  }

  private void initUI() {
    setTitle(S_GUI_CHANGE_PASS_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(340, 180));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_MENU_TOOLS_CHANGE)));
    pack();
    setLocationRelativeTo(null);

    labelPassword = Patterns.getCustomLabel(S_GUI_CHANGE_NEW_PASS);

    textPassword = Patterns.getCustomTextField();
    textPassword.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          butSave.doClick();
        }
      }
    });

    labelDatabaseSelect = Patterns.getCustomLabel(S_GUI_CHANGE_SELECT_DB);

    textDatabaseSelect = Patterns.getCustomTextField();
    textDatabaseSelect.setEnabled(false);
    textDatabaseSelect.setText(MainGUI.getDatabasePath());

    butBrowseDatabase = new JButton();
    butBrowseDatabase.setIcon(Util.createImageIconBut(Constants.IMG_SET_NAME_DATABASE, 32, 32));
    butBrowseDatabase.setBorderPainted(false);
    butBrowseDatabase.setFocusPainted(false);
    butBrowseDatabase.setContentAreaFilled(false);
    butBrowseDatabase.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Database", "db"));
        int resultChooser = fileChooser.showOpenDialog(ChangePasswordGUI.this);
        if (resultChooser == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          textDatabaseSelect.setText(selectedFile.getAbsolutePath());
        }
      }
    });

    butSave = new JButton(S_GUI_CHANGE_SAVE);
    butSave.setHorizontalAlignment(SwingConstants.LEFT);
    butSave.setFont(Util.getFont("label"));
    butSave.setForeground(Color.RED);
    butSave.setIcon(Util.createImageIconBut(Constants.IMG_MENU_TOOLS_SAVE, 32, 32));
    butSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (Util.isNullOrEmpty(textPassword.getText())) {
          JOptionPane.showMessageDialog(null, S_GUI_CHANGE_MSG_FILL_PASS_B,
              S_GUI_CHANGE_MSG_FILL_PASS_H, JOptionPane.INFORMATION_MESSAGE);
        } else {
          boolean statusUpdate = BaseService.changePasswordDb(textPassword.getText());
          if (statusUpdate) {
            MainGUI.closeDatabase();

            dispose();
          } else {
            JOptionPane.showMessageDialog(null, S_GUI_CHANGE_MSG_PASS_NOT_CH_B,
                S_GUI_CHANGE_MSG_PASS_NOT_CH_H, JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    add(labelDatabaseSelect, new Constraints(new Leading(12, 10, 10), new Leading(7, 12, 12)));
    add(textDatabaseSelect,
        new Constraints(new Leading(10, 310, 10, 10), new Leading(22, 26, 12, 12)));
    add(labelPassword, new Constraints(new Leading(12, 10, 10), new Leading(55, 12, 12)));
    add(textPassword, new Constraints(new Leading(10, 310, 10, 10), new Leading(70, 26, 12, 12)));
    add(butSave, new Constraints(new Leading(60, 10, 10), new Leading(103, 10, 10)));

    new CustomJRootPane(getRootPane(), this);
  }
}
