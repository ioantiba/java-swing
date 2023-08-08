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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.model.DatabaseModel;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.service.H2Connection;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class PasswordGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel labelPassword;
  private JPasswordField textPassword;
  private JButton butValidate;
  private int cntTry = 1;

  public PasswordGUI() {
    initUI();
    cntTry = 1;
  }

  private void initUI() {
    setTitle(S_GUI_PASS_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(300, 130));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_FRAME_NEW_ENTRY)));
    pack();
    setLocationRelativeTo(null);

    labelPassword = Patterns.getCustomLabel(S_GUI_PASS_LABEL_PASS);

    textPassword = new JPasswordField();
    textPassword.setBackground(Util.getColor("textField"));
    textPassword.setFont(Util.getFont("textField"));
    textPassword.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          butValidate.doClick();
        }
      }
    });

    butValidate = new JButton(S_GUI_PASS_BUT_VALIDATE);
    butValidate.setHorizontalAlignment(SwingConstants.LEFT);
    butValidate.setFont(Util.getFont("label"));
    butValidate.setForeground(Color.RED);
    butValidate.setIcon(Util.createImageIconBut(Constants.IMG_BUT_VALIDATE_PASS, 32, 32));
    butValidate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (cntTry > 3) {
          System.exit(1);
        }

        if (textPassword.getPassword() != null && textPassword.getPassword().length > 0) {

          File databaseFile = new File(MainGUI.getDatabasePath());
          DatabaseModel databaseModel = new DatabaseModel();
          databaseModel.setDatabaseName(databaseFile.getName());
          databaseModel.setPasswordDatabase(new String(textPassword.getPassword()));
          databaseModel.setDatabasePath(databaseFile.getAbsolutePath());

          cntTry++;

          Connection connection = H2Connection.getConnection(databaseModel);
          boolean connectionClosed = false;
          if (connection != null) {
            try {
              connectionClosed = connection.isClosed();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }

          if (connection != null && !connectionClosed) {
            cntTry = 1;
            MainGUI.setDatabaseModel(databaseModel);
            MainGUI.setDatabaseName(S_GUI_PASS_LABEL_CONECTED_TO + "  " + databaseFile.getName());
            ArrayList<PasswordModel> dataList = BaseService.getAllPasswordData(null, null);
            MainGUI.loadTable(dataList);
            MainGUI.loadCategoryModel();
            dispose();
          } else {
            JOptionPane.showMessageDialog(null, S_GUI_PASS_MSG_PASS_NO_MATCH_B,
                S_GUI_PASS_MSG_PASS_NO_MATCH_H, JOptionPane.ERROR_MESSAGE);
          }

        } else {
          JOptionPane.showMessageDialog(null, S_GUI_PASS_MSG_COMPLETE_FIELD_B,
              S_GUI_PASS_MSG_COMPLETE_FIELD_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    add(labelPassword, new Constraints(new Leading(12, 10, 10), new Leading(7, 12, 12)));
    add(textPassword, new Constraints(new Leading(10, 275, 10, 10), new Leading(22, 26, 12, 12)));
    add(butValidate, new Constraints(new Leading(70, 10, 10), new Leading(53, 10, 10)));

    textPassword.requestFocusInWindow();
    new CustomJRootPane(getRootPane(), this);
  }
}
