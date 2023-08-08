package org.ownbit.password.manager.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.model.CategoryModel;
import org.ownbit.password.manager.model.DatabaseModel;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.service.H2Connection;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class EntryGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private int id;
  private JLabel imageLabel;
  private JLabel labelTitle;
  private JTextField textTitle;
  private JLabel labelUsername;
  private JTextField textUsername;
  private JLabel labelPassword;
  private static JTextArea textPassword;
  private JLabel labelURL;
  private JTextField textURL;
  private JLabel labelComment;
  private JTextArea textComment;
  private JButton butSave;
  private JButton butClear;
  private JButton butGeneratePass;
  private JLabel labelCategory;
  private static DefaultComboBoxModel<CategoryModel> model;
  private static JComboBox<CategoryModel> comboCategory;
  private JButton butAddCategory;
  private JButton butDelCategory;

  public EntryGUI() {
    initUI();
  }

  public EntryGUI(PasswordModel passwordModel) {
    initUI();

    this.id = passwordModel.getId();
    this.textTitle.setText(passwordModel.getTitle());
    this.textUsername.setText(passwordModel.getUserName());
    EntryGUI.textPassword.setText(passwordModel.getPassword());
    this.textURL.setText(passwordModel.getUrl());
    this.textComment.setText(passwordModel.getComment());

    EntryGUI.comboCategory.setSelectedIndex(model.getIndexOf(passwordModel.getCategory()));
  }

  private void initUI() {

    setTitle(S_GUI_NEW_ENTRY_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(450, 430));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_FRAME_NEW_ENTRY)));
    pack();
    setLocationRelativeTo(null);
    initilizeComponent();
    new CustomJRootPane(getRootPane(), this);
  }

  private void initilizeComponent() {
    imageLabel = new JLabel();
    imageLabel.setIcon(Util.createImageIconBut(Constants.IMG_GENERAL_DOCUMENTS, 64, 64));

    labelTitle = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_TITLE);
    textTitle = Patterns.getCustomTextField();

    labelUsername = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_USERNAME);
    textUsername = Patterns.getCustomTextField();

    labelPassword = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_PASSWORD);
    textPassword = Patterns.getCustomTextArea();

    labelURL = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_URL);
    textURL = Patterns.getCustomTextField();

    labelComment = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_COMMENT);
    textComment = Patterns.getCustomTextArea();

    labelCategory = Patterns.getCustomLabel(S_GUI_NEW_ENTRY_LABEL_CATEGORY);

    model = new DefaultComboBoxModel<CategoryModel>(BaseService.getCategories(0));
    comboCategory = new JComboBox<CategoryModel>();
    comboCategory.setBackground(Util.getColor("textField"));
    comboCategory.setFont(Util.getFont("textField"));
    comboCategory.setModel(model);

    butAddCategory = new JButton();
    butAddCategory.setIcon(Util.createImageIconBut(Constants.IMG_BUT_PLUS, 25, 25));
    butAddCategory.setBorderPainted(false);
    butAddCategory.setFocusPainted(false);
    butAddCategory.setContentAreaFilled(false);
    butAddCategory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        CategoryGUI categoryGUI = new CategoryGUI();
        categoryGUI.setVisible(true);
      }
    });

    butDelCategory = new JButton();
    butDelCategory.setIcon(Util.createImageIconBut(Constants.IMG_BUT_CATEGORY_DELETE, 25, 25));
    butDelCategory.setBorderPainted(false);
    butDelCategory.setFocusPainted(false);
    butDelCategory.setContentAreaFilled(false);
    butDelCategory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (comboCategory.getSelectedIndex() != -1) {
          DatabaseModel databaseModel = MainGUI.getDatabaseModel();
          Connection connection = H2Connection.getConnection(databaseModel);
          if (connection != null) {

            CategoryModel catModel = (CategoryModel) comboCategory.getSelectedItem();
            if (BaseService.canDeleteCategory(catModel.getId())) {
              JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_B,
                  S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_H, JOptionPane.WARNING_MESSAGE);
            } else {
              BaseService.deleteCategory(catModel.getId());
              loadCategoryModel();
            }
          }
        } else {
          JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_B,
              S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_H, JOptionPane.WARNING_MESSAGE);
        }

      }
    });

    butSave = new JButton(S_GUI_NEW_ENTRY_BUT_SAVE);
    butSave.setHorizontalAlignment(SwingConstants.LEFT);
    butSave.setFont(Util.getFont("label"));
    butSave.setForeground(Color.RED);
    butSave.setIcon(Util.createImageIconBut(Constants.IMG_BUT_SEARCH, 32, 32));
    butSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        if (Util.isNullOrEmpty(textTitle.getText()) || Util.isNullOrEmpty(textUsername.getText())
            || Util.isNullOrEmpty(textPassword.getText()) || Util.isNullOrEmpty(textURL.getText())
            || (comboCategory == null || comboCategory.getSelectedIndex() == -1)) {

          JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_REQ_FIELD_B,
              S_GUI_NEW_ENTRY_MSG_REQ_FIELD_H, JOptionPane.WARNING_MESSAGE);
        } else {

          PasswordModel passwordModel = new PasswordModel();
          passwordModel.setId(id);
          passwordModel.setTitle(textTitle.getText());
          passwordModel.setUserName(textUsername.getText());
          passwordModel.setPassword(textPassword.getText());
          passwordModel.setUrl(textURL.getText());
          passwordModel.setComment(textComment.getText());

          CategoryModel catModel = (CategoryModel) comboCategory.getSelectedItem();
          passwordModel.setCategory(catModel);

          if (id > 0) {
            boolean statusUpdate = BaseService.updateData(passwordModel);
            if (statusUpdate) {
              JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_B,
                  S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_H, JOptionPane.INFORMATION_MESSAGE);

              ArrayList<PasswordModel> dataList = BaseService.getAllPasswordData(null, null);
              MainGUI.loadTable(dataList);
              MainGUI.loadCategoryModel();
              dispose();
            } else {
              JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_B,
                  S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_H, JOptionPane.ERROR_MESSAGE);
            }

          } else {
            boolean statusInsert = BaseService.insertNewData(passwordModel);
            if (statusInsert) {
              JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_SAVE_DATA_B,
                  S_GUI_NEW_ENTRY_MSG_SAVE_DATA_H, JOptionPane.INFORMATION_MESSAGE);

              ArrayList<PasswordModel> dataList = BaseService.getAllPasswordData(null, null);
              MainGUI.loadTable(dataList);
              dispose();
            } else {
              JOptionPane.showMessageDialog(null, S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_B,
                  S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_H, JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });

    butClear = new JButton(S_GUI_NEW_ENTRY_CLEAR_FIELD);
    butClear.setHorizontalAlignment(SwingConstants.LEFT);
    butClear.setFont(Util.getFont("label"));
    butClear.setForeground(Color.RED);
    butClear.setIcon(Util.createImageIconBut(Constants.IMG_MENU_TOOLS_CLEAR, 32, 32));
    butClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        id = 0;
        textTitle.setText("");
        textUsername.setText("");
        textPassword.setText("");
        textURL.setText("");
        textComment.setText("");
        comboCategory.setSelectedIndex(-1);
      }
    });

    butGeneratePass = new JButton();
    butGeneratePass
        .setIcon(Util.createImageIconBut(Constants.IMG_MENU_TOOLS_GENERATE_PASSWORD, 48, 48));
    butGeneratePass.setBorderPainted(false);
    butGeneratePass.setFocusPainted(false);
    butGeneratePass.setContentAreaFilled(false);
    butGeneratePass.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        GeneratePasswordGUI generatePassword = new GeneratePasswordGUI();
        generatePassword.setVisible(true);
      }
    });

    add(imageLabel, new Constraints(new Leading(360, 10, 10), new Leading(45, 12, 12)));
    add(labelTitle, new Constraints(new Leading(12, 10, 10), new Leading(7, 12, 12)));
    add(textTitle, new Constraints(new Leading(10, 425, 10, 10), new Leading(22, 26, 12, 12)));
    add(labelUsername, new Constraints(new Leading(12, 10, 10), new Leading(51, 12, 12)));
    add(textUsername, new Constraints(new Leading(10, 340, 10, 10), new Leading(66, 26, 12, 12)));
    add(labelPassword, new Constraints(new Leading(12, 10, 10), new Leading(97, 12, 12)));
    add(new JScrollPane(textPassword),
        new Constraints(new Leading(10, 380, 10, 10), new Leading(112, 50, 12, 12)));
    add(butGeneratePass, new Constraints(new Leading(375, 10, 10), new Leading(107, 10, 10)));
    add(labelURL, new Constraints(new Leading(12, 10, 10), new Leading(168, 12, 12)));
    add(textURL, new Constraints(new Leading(10, 425, 10, 10), new Leading(183, 26, 12, 12)));
    add(labelCategory, new Constraints(new Leading(12, 10, 10), new Leading(215, 12, 12)));
    add(comboCategory, new Constraints(new Leading(10, 300, 10, 10), new Leading(232, 26, 12, 12)));
    add(butDelCategory, new Constraints(new Leading(340, 10, 10), new Leading(228, 10, 10)));
    add(butAddCategory, new Constraints(new Leading(305, 10, 10), new Leading(228, 10, 10)));
    add(labelComment, new Constraints(new Leading(12, 10, 10), new Leading(264, 12, 12)));
    add(new JScrollPane(textComment),
        new Constraints(new Leading(10, 425, 10, 10), new Leading(279, 70, 12, 12)));
    add(butSave, new Constraints(new Leading(50, 10, 10), new Leading(355, 10, 10)));
    add(butClear, new Constraints(new Leading(200, 10, 10), new Leading(355, 10, 10)));
  }

  public static void setTextPassword(String password) {
    if (textPassword != null) {
      textPassword.setText(password);
    }
  }

  public static void loadCategoryModel() {
    model = new DefaultComboBoxModel<CategoryModel>(BaseService.getCategories(0));
    comboCategory.setModel(model);
  }
}
