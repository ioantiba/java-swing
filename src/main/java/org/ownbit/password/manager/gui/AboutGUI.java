package org.ownbit.password.manager.gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.ownbit.password.manager.custom.CustomJRootPane;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class AboutGUI extends JDialog implements LanguageKey {

  private static final long serialVersionUID = 1L;
  private JLabel imageLabel;
  private JLabel labelSoftwareApplication;
  private JLabel labelDeveloper;
  private JLabel labelEmail;
  private JLabel labelWeb;

  public AboutGUI() {
    initUI();
  }

  private void initUI() {

    setTitle(S_GUI_ABOUT_TITLE);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(new Dimension(450, 220));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(false);
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setLayout(new GroupLayout());
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage(getClass().getResource(Constants.IMG_BUT_SOFTWARE_UPDATE)));
    pack();
    setLocationRelativeTo(null);
    initilizeComponent();

    new CustomJRootPane(getRootPane(), this);
  }

  private void initilizeComponent() {
    imageLabel = new JLabel();
    imageLabel.setIcon(Util.createImageIconBut(Constants.IMG_BUT_SOFTWARE_NETWORK, 200, 165));

    labelSoftwareApplication = Patterns.getCustomLabel(S_GUI_SOFTWARE_TITLE);
    labelSoftwareApplication.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));

    labelDeveloper = Patterns.getCustomLabel(S_GUI_DEVELOPER);
    labelDeveloper.setFont(new Font("Serif", Font.BOLD, 15));

    labelEmail = Patterns.getCustomLabel(S_GUI_DEVELOPER_EMAIL);
    labelEmail.setFont(new Font("Serif", Font.BOLD, 15));

    labelWeb = Patterns.getCustomLabel(S_GUI_DEVELOPER_WEB);
    labelWeb.setFont(new Font("Serif", Font.BOLD, 15));

    add(imageLabel, new Constraints(new Leading(5, 10, 10), new Leading(15, 12, 12)));
    add(labelSoftwareApplication,
        new Constraints(new Leading(200, 10, 10), new Leading(20, 12, 12)));
    add(labelDeveloper, new Constraints(new Leading(210, 10, 10), new Leading(73, 12, 12)));
    add(labelEmail, new Constraints(new Leading(210, 10, 10), new Leading(96, 12, 12)));
    add(labelWeb, new Constraints(new Leading(210, 10, 10), new Leading(119, 12, 12)));
  }
}
