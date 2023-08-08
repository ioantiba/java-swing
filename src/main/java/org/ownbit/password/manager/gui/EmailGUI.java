package org.ownbit.password.manager.gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.model.EmailModel;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.SendEmail;
import org.ownbit.password.manager.utils.Util;

public class EmailGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private PasswordModel passwordModel;
  private JLabel labelFrom;
  private JTextField textFrom;
  private JLabel labelTo;
  private JTextField textTo;
  private JLabel labelCC;
  private JTextField textCC;
  private JLabel labelSubject;
  private static JTextArea textSubject;
  private JLabel labelMessage;
  private static JTextArea textMessage;
  private EmailModel emailModel;
  private JButton butSend;
  private JLabel imgFrom;
  private JLabel imgTo;
  private JLabel imgCc;
  private JLabel imgSubject;
  private JLabel imgMessage;

  public EmailGUI(PasswordModel passwordModel) {
    this.passwordModel = passwordModel;
    initUI();
  }

  private void initUI() {

    setTitle(S_GUI_SEND_EMAIL_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(450, 430));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_FRAME_SEND_EMAIL)));
    pack();
    setLocationRelativeTo(null);
    new CustomJRootPane(getRootPane(), this);

    initializeComponent();
    initDefaultData();
  }

  private void initializeComponent() {

    labelFrom = Patterns.getCustomLabel(S_GUI_SEND_EMAIL_FROM);
    textFrom = Patterns.getCustomTextField();

    labelTo = Patterns.getCustomLabel(S_GUI_SEND_EMAIL_TO);
    textTo = Patterns.getCustomTextField();

    labelCC = Patterns.getCustomLabel(S_GUI_SEND_EMAIL_CC);
    textCC = Patterns.getCustomTextField();

    labelSubject = Patterns.getCustomLabel(S_GUI_SEND_EMAIL_SUBJECT);
    textSubject = Patterns.getCustomTextArea();

    labelMessage = Patterns.getCustomLabel(S_GUI_SEND_EMAIL_MESSAGE);

    textMessage = Patterns.getCustomTextArea();

    butSend = new JButton(S_GUI_SEND_EMAIL_BUT_SEND);
    butSend.setIcon(Util.createImageIconBut(Constants.IMG_BUT_SEND_EMAIL, 25, 25));
    butSend.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        emailModel = new EmailModel();
        emailModel.setFrom(textFrom.getText());
        emailModel.setTo(textTo.getText());
        emailModel.setMessage(textMessage.getText());
        emailModel.setSubject(textSubject.getText());

        boolean sentEmail = SendEmail.sendEmailData(emailModel);
        if (sentEmail) {
          dispose();
        }
      }
    });

    imgFrom =
        Patterns.getCustomImgLabel(Util.createImageIconBut(Constants.IMG_LABEL_FROM_EMAIL, 25, 25));
    imgTo =
        Patterns.getCustomImgLabel(Util.createImageIconBut(Constants.IMG_LABEL_TO_EMAIL, 25, 25));
    imgCc =
        Patterns.getCustomImgLabel(Util.createImageIconBut(Constants.IMG_LABEL_CC_EMAIL, 25, 25));
    imgSubject = Patterns
        .getCustomImgLabel(Util.createImageIconBut(Constants.IMG_LABEL_SUBJECT_EMAIL, 25, 25));
    imgMessage = Patterns
        .getCustomImgLabel(Util.createImageIconBut(Constants.IMG_LABEL_MESSAGE_EMAIL, 25, 25));

    add(labelFrom, new Constraints(new Leading(37, 10, 10), new Leading(10, 12, 12)));
    add(imgFrom, new Constraints(new Leading(5, 10, 10), new Leading(23, 12, 12)));
    add(textFrom, new Constraints(new Leading(35, 400, 10, 10), new Leading(25, 26, 12, 12)));
    add(labelTo, new Constraints(new Leading(37, 10, 10), new Leading(55, 12, 12)));
    add(imgTo, new Constraints(new Leading(5, 10, 10), new Leading(67, 12, 12)));
    add(textTo, new Constraints(new Leading(35, 400, 10, 10), new Leading(70, 26, 12, 12)));
    add(labelCC, new Constraints(new Leading(37, 10, 10), new Leading(100, 12, 12)));
    add(imgCc, new Constraints(new Leading(5, 10, 10), new Leading(112, 12, 12)));
    add(textCC, new Constraints(new Leading(35, 400, 10, 10), new Leading(115, 26, 12, 12)));
    add(labelSubject, new Constraints(new Leading(37, 10, 10), new Leading(145, 12, 12)));
    add(imgSubject, new Constraints(new Leading(5, 10, 10), new Leading(165, 12, 12)));
    add(new JScrollPane(textSubject),
        new Constraints(new Leading(35, 400, 10, 10), new Leading(161, 50, 12, 12)));
    add(labelMessage, new Constraints(new Leading(37, 10, 10), new Leading(220, 12, 12)));
    add(imgMessage, new Constraints(new Leading(5, 10, 10), new Leading(250, 12, 12)));
    add(new JScrollPane(textMessage),
        new Constraints(new Leading(35, 400, 10, 10), new Leading(236, 105, 12, 12)));
    add(butSend, new Constraints(new Leading(100, 10, 10), new Leading(350, 10, 10)));
  }

  private void initDefaultData() {
    textSubject.setText("Login details for: " + passwordModel.getUrl());

    /*
     * String messageContent = "<table width=\"auto\" border=\"1\">" + "<tr>" +
     * "<th scope=\"col\">Title</th>" + "<th scope=\"col\">Username</th>" +
     * "<th scope=\"col\">Password</th>" + "<th scope=\"col\">URL</th>" +
     * "<th scope=\"col\">Comment</th>" + "</tr>" + "<tr>" + "<td>" + passwordModel.getTitle() +
     * "</td>" + "<td>" + passwordModel.getUserName() + "</td>" + "<td>" +
     * passwordModel.getPassword() + "</td>" + "<td>" + passwordModel.getUrl() + "</td>" + "<td>" +
     * passwordModel.getComment() + "</td>" + "</tr>" + "</table>";
     */
    String messageContent = "Title: " + passwordModel.getTitle() + " \n";
    messageContent += "Username: " + passwordModel.getUserName() + " \n";
    messageContent += "Password: " + passwordModel.getPassword() + " \n";
    messageContent += "URL: " + passwordModel.getUrl() + " \n";
    messageContent += "Comment: " + passwordModel.getComment() + " \n";

    textFrom.setText("ionut@test.com");
    textTo.setText("ioantiba@gmail.com");
    textMessage.setText(messageContent);
  }
}
