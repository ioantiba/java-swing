package org.ownbit.password.manager.gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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

public class CategoryGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel labelName;
  private JTextField textName;
  private JButton butSave;

  public CategoryGUI() {
    initUI();
  }

  private void initUI() {
    setTitle(S_GUI_CATEG_TITLE);
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

    labelName = Patterns.getCustomLabel(S_GUI_CATEG_NAME);

    textName = Patterns.getCustomTextField();
    textName.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          butSave.doClick();
        }
      }
    });

    butSave = new JButton(S_GUI_CATEG_SAVE);
    butSave.setFont(Util.getFont("label"));
    butSave.setIcon(Util.createImageIconBut(Constants.IMG_BUT_CATEGORY_SAVE, 32, 32));
    butSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (!Util.isNullOrEmpty(textName.getText())) {

          DatabaseModel databaseModel = MainGUI.getDatabaseModel();
          Connection connection = H2Connection.getConnection(databaseModel);

          if (connection != null) {
            BaseService.insertCategory(textName.getText());
            EntryGUI.loadCategoryModel();
            MainGUI.loadCategoryModel();
            dispose();
          } else {
            JOptionPane.showMessageDialog(null, S_GUI_CATEG_MSG_EMPTY_NAME_B,
                S_GUI_CATEG_MSG_EMPTY_NAME_H, JOptionPane.WARNING_MESSAGE);
          }

        } else {
          JOptionPane.showMessageDialog(null, S_GUI_CATEG_MSG_COMPLETE_PASS_B,
              S_GUI_CATEG_MSG_COMPLETE_PASS_H, JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    add(labelName, new Constraints(new Leading(12, 10, 10), new Leading(7, 12, 12)));
    add(textName, new Constraints(new Leading(10, 275, 10, 10), new Leading(22, 26, 12, 12)));
    add(butSave, new Constraints(new Leading(70, 10, 10), new Leading(53, 10, 10)));

    textName.requestFocusInWindow();
    new CustomJRootPane(getRootPane(), this);
  }
}
