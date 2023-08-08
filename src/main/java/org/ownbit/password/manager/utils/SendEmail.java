package org.ownbit.password.manager.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import org.ownbit.password.manager.model.EmailModel;

/**
 * The Class SendEmail.
 */
public class SendEmail extends Constants implements LanguageKey {

  /**
   * Prepare email.
   *
   * @param model the model
   * @return true, if successful
   */
  private static boolean prepareEmail(EmailModel model) {
    String to = model.getTo();
    String subject = model.getSubject();
    String message = model.getMessage();
    String from = model.getFrom();
    boolean status = false;

    try {
      sendEmail(to, subject, message, from);
      status = true;
      JOptionPane.showMessageDialog(null, S_SEND_EMAIL_SUCCESS);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, S_SEND_EMAIL_MSG_ERROR_B + ex.getMessage(),
          S_SEND_EMAIL_MSG_ERROR_H, JOptionPane.ERROR_MESSAGE);
    }
    return status;
  }

  /**
   * Send email.
   *
   * @param to the to
   * @param subject the subject
   * @param message the message
   * @param from the from
   * @throws Exception the exception
   */
  private static void sendEmail(String to, String subject, String message, String from)
      throws Exception {

    Properties properties = new Properties();
    properties.put("mail.smtp.auth", SMTP_AUTH);
    properties.put("mail.smtp.starttls.enable", SMTP_STARTTLS);
    properties.put("mail.smtp.host", SMTP_HOST);
    properties.put("mail.smtp.port", SMTP_PORT);

    final String userName = CipherUtils.decrypt(SMTP_USERNAME);
    final String password = CipherUtils.decrypt(SMTP_PASSWORD);

    // creates a new session with an authenticator)
    Authenticator auth = new Authenticator() {
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
      }
    };
    Session session = Session.getInstance(properties, auth);

    try {
      // Create a default MimeMessage object.
      Message msg = new MimeMessage(session);

      // Set From: header field of the header.
      msg.setFrom(new InternetAddress(from, "Ionut"));

      // Set To: header field of the header.
      InternetAddress[] toAddresses = {new InternetAddress(to)};
      msg.setRecipients(Message.RecipientType.TO, toAddresses);

      // Set Subject: header field
      msg.setSubject(subject);

      msg.setSentDate(new Date());

      // creates message part
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(message, "text/html");

      // creates multi-part
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // sets the multi-part as e-mail's content
      msg.setContent(multipart);

      // sends the e-mail
      Transport.send(msg);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Send email data.
   *
   * @param model the model
   * @return true, if successful
   */
  public static boolean sendEmailData(EmailModel model) {
    return prepareEmail(model);
  }
}
