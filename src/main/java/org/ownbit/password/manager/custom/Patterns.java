package org.ownbit.password.manager.custom;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.ownbit.password.manager.utils.Util;

/**
 * The Class Patterns.
 */
public class Patterns {

  /**
   * Custom label bold.
   *
   * @param title the title
   * @return the j label
   */
  private static JLabel customLabelBold(String title) {
    JLabel newJLabel = new JLabel();
    newJLabel.setText(title);
    newJLabel.setFont(Util.getFont("labelBold"));
    return newJLabel;
  }

  /**
   * Custom label.
   *
   * @param title the title
   * @return the j label
   */
  private static JLabel customLabel(String title) {
    JLabel newJLabel = new JLabel();
    newJLabel.setText(title);
    newJLabel.setFont(Util.getFont("label"));
    return newJLabel;
  }

  /**
   * Custom img label.
   *
   * @param icon the icon
   * @return the j label
   */
  private static JLabel customImgLabel(Icon icon) {
    JLabel newImgLabel = new JLabel();
    newImgLabel.setIcon(icon);
    return newImgLabel;
  }

  /**
   * Custom text field.
   *
   * @return the j text field
   */
  private static JTextField customTextField() {
    JTextField newTextField = new JTextField();
    newTextField.setBackground(Util.getColor("textField"));
    newTextField.setFont(Util.getFont("textField"));
    return newTextField;
  }

  /**
   * Custom check box.
   *
   * @param title the title
   * @return the j check box
   */
  private static JCheckBox customCheckBox(String title) {
    JCheckBox newCheckBox = new JCheckBox();
    newCheckBox.setText(title);
    newCheckBox.setFont(Util.getFont("label"));
    return newCheckBox;
  }

  /**
   * Custom text area.
   *
   * @return the j text area
   */
  private static JTextArea customTextArea() {
    JTextArea newTextArea = new JTextArea();
    newTextArea.setLineWrap(true);
    newTextArea.setWrapStyleWord(true);
    newTextArea.setBackground(Util.getColor("textField"));
    newTextArea.setFont(Util.getFont("textField"));
    return newTextArea;
  }

  /**
   * Gets the custom label bold.
   *
   * @param title the title
   * @return the custom label bold
   */
  public static JLabel getCustomLabelBold(String title) {
    return customLabelBold(title);
  }

  /**
   * Gets the custom label.
   *
   * @param title the title
   * @return the custom label
   */
  public static JLabel getCustomLabel(String title) {
    return customLabel(title);
  }

  /**
   * Gets the custom text field.
   *
   * @return the custom text field
   */
  public static JTextField getCustomTextField() {
    return customTextField();
  }

  /**
   * Gets the custom check box.
   *
   * @param title the title
   * @return the custom check box
   */
  public static JCheckBox getCustomCheckBox(String title) {
    return customCheckBox(title);
  }

  /**
   * Gets the custom text area.
   *
   * @return the custom text area
   */
  public static JTextArea getCustomTextArea() {
    return customTextArea();
  }

  /**
   * Gets the custom img label.
   *
   * @param icon the icon
   * @return the custom img label
   */
  public static JLabel getCustomImgLabel(Icon icon) {
    return customImgLabel(icon);
  }
}
