package org.ownbit.password.manager.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.model.DatabaseModel;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.service.H2Connection;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class NewDatabaseGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel labelDatabaseName;
  private JTextField textDatabaseName;
  private JLabel labelDatabasePassword;
  private JPasswordField textDatabasePassword;
  private JButton butCreate;
  private JButton butBrowse;

  public NewDatabaseGUI() {
    initUI();
  }

  private void initUI() {
    setTitle(S_GUI_NEW_DB_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(347, 180));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_MENU_FILE_NEW_DATABASE)));
    pack();
    setLocationRelativeTo(null);

    initializeComponent();
    new CustomJRootPane(getRootPane(), this);
  }

  private void initializeComponent() {
    labelDatabaseName = Patterns.getCustomLabel(S_GUI_NEW_DB_PATH);
    textDatabaseName = Patterns.getCustomTextField();
    textDatabaseName.setEditable(false);

    labelDatabasePassword = Patterns.getCustomLabel(S_GUI_NEW_DB_PASS);
    textDatabasePassword = new JPasswordField();
    textDatabasePassword.setBackground(Util.getColor("textField"));
    textDatabasePassword.setFont(Util.getFont("textField"));

    butBrowse = new JButton(S_GUI_NEW_BUT_BROWSE);
    butBrowse.setHorizontalAlignment(SwingConstants.LEFT);
    butBrowse.setFont(Util.getFont("label"));
    butBrowse.setForeground(Color.RED);
    butBrowse.setIcon(Util.createImageIconBut(Constants.IMG_SET_NAME_DATABASE, 32, 32));
    butBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Database", "db"));
        int resultChooser = fileChooser.showSaveDialog(NewDatabaseGUI.this);
        if (resultChooser == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          textDatabaseName.setText(selectedFile.getAbsolutePath());
        }
      }
    });

    butCreate = new JButton(S_GUI_NEW_BUT_CREATE);
    butCreate.setHorizontalAlignment(SwingConstants.LEFT);
    butCreate.setFont(Util.getFont("label"));
    butCreate.setForeground(Color.RED);
    butCreate.setIcon(Util.createImageIconBut(Constants.IMG_BUT_CREATE_DATABASE, 32, 32));
    butCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (!Util.isNullOrEmpty(textDatabaseName.getText())
            || (textDatabasePassword.getPassword() != null
                && textDatabasePassword.getPassword().length > 0)) {

          File newDatabase = new File(textDatabaseName.getText() + Constants.DATABASE_EXT);
          DatabaseModel databaseModel = new DatabaseModel();
          databaseModel.setPasswordDatabase(new String(textDatabasePassword.getPassword()));
          databaseModel.setDatabaseName(newDatabase.getName());
          databaseModel.setDatabasePath(newDatabase.getAbsolutePath());

          Connection connection = H2Connection.getConnection(databaseModel);
          if (connection != null) {
            MainGUI.setDatabaseModel(databaseModel);

            BaseService.newDatabase();
            JOptionPane.showMessageDialog(null, S_GUI_NEW_MSG_DB_CREATED_B,
                S_GUI_NEW_MSG_DB_CREATED_H, JOptionPane.INFORMATION_MESSAGE);
            dispose();
          } else {
            JOptionPane.showMessageDialog(null, S_GUI_NEW_MSG_DB_NOT_CREATED_B,
                S_GUI_NEW_MSG_DB_NOT_CREATED_H, JOptionPane.WARNING_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(null, S_GUI_NEW_MSG_COMPLETE_REQ_B,
              S_GUI_NEW_MSG_COMPLETE_REQ_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    add(labelDatabaseName, new Constraints(new Leading(12, 10, 10), new Leading(7, 12, 12)));
    add(textDatabaseName,
        new Constraints(new Leading(10, 320, 10, 10), new Leading(22, 26, 12, 12)));
    add(labelDatabasePassword, new Constraints(new Leading(12, 10, 10), new Leading(49, 12, 12)));
    add(textDatabasePassword,
        new Constraints(new Leading(10, 320, 10, 10), new Leading(64, 26, 12, 12)));
    add(butBrowse, new Constraints(new Leading(10, 10, 10), new Leading(98, 10, 10)));
    add(butCreate, new Constraints(new Leading(190, 10, 10), new Leading(98, 10, 10)));
  }
}
