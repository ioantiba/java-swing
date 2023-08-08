package org.ownbit.password.manager.gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class GeneratePasswordGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel labelTitle;
  private JLabel labelLength;
  private JTextField textLength;
  private JButton butPlus;
  private JCheckBox boxUpperCase;
  private JCheckBox boxLowerCase;
  private JCheckBox boxDigits;
  private JCheckBox boxMinus;
  private JCheckBox boxUnderLine;
  private JCheckBox boxBrackets;
  private JCheckBox boxSpecial;
  private JButton butGeneratePass;
  private JLabel labelPassword;
  private JTextArea textPassword;
  private ArrayList<String> charactersList;

  public GeneratePasswordGUI() {
    initUI();
  }

  private void initUI() {
    setTitle(S_GUI_GEN_PASS_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(350, 310));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_MENU_TOOLS_GENERATE_PASSWORD)));
    pack();
    setLocationRelativeTo(null);

    initializeComponent();
    new CustomJRootPane(getRootPane(), this);
  }

  private void initializeComponent() {

    labelTitle = Patterns.getCustomLabelBold(S_GUI_GEN_PASS_LABEL_CHR_SET);
    labelLength = Patterns.getCustomLabel(S_GUI_GEN_PASS_LENGTH_PASS);

    textLength = Patterns.getCustomTextField();
    textLength.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
          getToolkit().beep();
          e.consume();
        }
      }
    });

    butPlus = new JButton();
    butPlus.setIcon(Util.createImageIconBut(Constants.IMG_BUT_PLUS, 25, 25));
    butPlus.setBorderPainted(false);
    butPlus.setFocusPainted(false);
    butPlus.setContentAreaFilled(false);
    butPlus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (Util.isNullOrEmpty(textLength.getText())) {
          textLength.setText("1");
        } else {
          int length = Integer.valueOf(textLength.getText());
          textLength.setText(String.valueOf(++length));
        }
      }
    });

    boxUpperCase = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_UPPERCASE);
    boxLowerCase = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_LOWERCASE);
    boxDigits = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_DIGITS);
    boxMinus = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_MINUS);
    boxUnderLine = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_UNDERLINE);
    boxBrackets = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_BRACKETS);
    boxSpecial = Patterns.getCustomCheckBox(S_GUI_GEN_PASS_BOX_SPECIAL);

    labelPassword = Patterns.getCustomLabel(S_GUI_GEN_PASS_LABEL_GEN_PASS);

    textPassword = Patterns.getCustomTextArea();

    butGeneratePass = new JButton(S_GUI_GEN_PASS_BUT_GEN_PASS);
    butGeneratePass.setIcon(Util.createImageIconBut(Constants.IMG_BUT_GENERATE_PASS, 27, 27));
    butGeneratePass.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        generatePassword();
      }
    });

    add(labelTitle, new Constraints(new Leading(10, 10, 10), new Leading(7, 12, 12)));
    add(labelLength, new Constraints(new Leading(15, 10, 10), new Leading(40, 12, 12)));
    add(textLength, new Constraints(new Leading(210, 30, 10, 10), new Leading(37, 26, 12, 12)));
    add(butPlus, new Constraints(new Leading(230, 10, 10), new Leading(32, 10, 10)));
    add(boxUpperCase, new Constraints(new Leading(15, 10, 10), new Leading(75, 10, 10)));
    add(boxDigits, new Constraints(new Leading(190, 10, 10), new Leading(75, 10, 10)));
    add(boxLowerCase, new Constraints(new Leading(15, 10, 10), new Leading(97, 10, 10)));
    add(boxMinus, new Constraints(new Leading(190, 10, 10), new Leading(97, 10, 10)));
    add(boxUnderLine, new Constraints(new Leading(15, 10, 10), new Leading(119, 10, 10)));
    add(boxBrackets, new Constraints(new Leading(190, 10, 10), new Leading(119, 10, 10)));
    add(boxSpecial, new Constraints(new Leading(15, 10, 10), new Leading(141, 10, 10)));
    add(labelPassword, new Constraints(new Leading(17, 10, 10), new Leading(172, 12, 12)));
    add(new JScrollPane(textPassword),
        new Constraints(new Leading(15, 320, 10, 10), new Leading(187, 50, 12, 12)));
    add(butGeneratePass, new Constraints(new Leading(50, 10, 10), new Leading(240, 10, 10)));
  }

  private void generatePassword() {
    if (Util.isNullOrEmpty(textLength.getText())) {
      JOptionPane.showMessageDialog(null, S_GUI_GEN_PASS_MSG_LENGTH_PASS_B,
          S_GUI_GEN_PASS_MSG_LENGTH_PASS_H, JOptionPane.ERROR_MESSAGE);
    } else if (!boxUpperCase.isSelected() && !boxDigits.isSelected() && !boxLowerCase.isSelected()
        && !boxMinus.isSelected() && !boxUnderLine.isSelected() && !boxBrackets.isSelected()
        && !boxSpecial.isSelected()) {
      JOptionPane.showMessageDialog(null, S_GUI_GEN_PASS_MSG_MIN_CRIT_B,
          S_GUI_GEN_PASS_MSG_MIN_CRIT_H, JOptionPane.ERROR_MESSAGE);
    } else {
      createLisOfCharacters();
      if (charactersList.size() > 0) {
        int passwordSize = Integer.valueOf(textLength.getText());

        StringBuffer password = new StringBuffer();
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < passwordSize; i++) {
          password.append(charactersList.get(rand.nextInt(charactersList.size())));
        }
        textPassword.setText(password.toString());
        EntryGUI.setTextPassword(textPassword.getText());
      } else {
        JOptionPane.showMessageDialog(null, S_GUI_GEN_PASS_MSG_CANT_GEN_B,
            S_GUI_GEN_PASS_MSG_CANT_GEN_H, JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void createLisOfCharacters() {
    charactersList = new ArrayList<String>();
    if (boxUpperCase.isSelected()) {
      for (char letter = 'A'; letter <= 'Z'; letter++) {
        charactersList.add(String.valueOf(letter));
      }
    }
    if (boxLowerCase.isSelected()) {
      for (char letter = 'a'; letter <= 'z'; letter++) {
        charactersList.add(String.valueOf(letter));
      }
    }
    if (boxDigits.isSelected()) {
      for (char number = '0'; number <= '9'; number++) {
        charactersList.add(String.valueOf(number));
      }
    }
    if (boxMinus.isSelected()) {
      charactersList.add("-");
    }
    if (boxUnderLine.isSelected()) {
      charactersList.add("_");
    }
    if (boxBrackets.isSelected()) {
      char[] brackets = "[]{}()<>".toCharArray();
      for (char br : brackets) {
        charactersList.add(String.valueOf(br));
      }
    }
    if (boxSpecial.isSelected()) {
      char[] specials = "!@#$%&*?:';,.=+|".toCharArray();
      for (char spec : specials) {
        charactersList.add(String.valueOf(spec));
      }
    }
  }
}
