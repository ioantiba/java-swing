package org.ownbit.password.manager.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.ownbit.password.manager.utils.StreamWrapper.StreamGobbler;

/**
 * The Class Util.
 */
public class Util extends Constants implements LanguageKey {

  /** The Constant CONFIG_PROPERTIES. */
  private static final String CONFIG_PROPERTIES = "config.properties";

  private static Properties properties = null;

  /**
   * Checks if is null or empty.
   *
   * @param s the s
   * @return the boolean
   */
  public static Boolean isNullOrEmpty(String s) {
    return (s == null || s.trim().length() < 1) ? true : false;
  }

  /**
   * Checks if is java installed.
   *
   * @return true, if is java installed
   */
  public static boolean isJavaInstalled() {
    boolean status = false;

    String[] commands = {"java", "-version"};

    StreamWrapper streamWrapper = new StreamWrapper();
    StreamGobbler error;
    StreamGobbler output;

    try {

      final Process proc = Runtime.getRuntime().exec(commands);

      error = streamWrapper.getStreamGobbler(proc.getErrorStream(), "ERROR");
      output = streamWrapper.getStreamGobbler(proc.getInputStream(), "OUTPUT");

      int exitVal = 0;
      error.start();
      output.start();

      exitVal = proc.waitFor();
      if (exitVal == 0) {
        status = true;
      } else {
        JOptionPane.showMessageDialog(null, error.getMessage(), S_SISTEM_RUNTIME_CHECK_JAVA,
            JOptionPane.ERROR_MESSAGE);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), S_SISTEM_RUNTIME_CHECK_JAVA,
          JOptionPane.ERROR_MESSAGE);
    }

    return status;
  }

  /**
   * Install look and feel.
   *
   * @throws UnsupportedLookAndFeelException the unsupported look and feel exception
   */
  public static void installLnF() throws UnsupportedLookAndFeelException {
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Metal".equals(info.getName())) { // Metal, Nimbus,
          // CDE/Motif, Windows,
          // Windows Classic
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception e) {
      UIManager.setLookAndFeel(new MetalLookAndFeel());
    }
  }

  /**
   * Returns an ImageIcon, or null if the path was invalid.
   *
   * @param path the path
   * @return the image icon
   */
  public static ImageIcon createImageIcon(String path) {
    int width = 40;
    int height = 40;
    ImageIcon icond = new ImageIcon(new ImageIcon(Util.class.getResource(path)).getImage()
        .getScaledInstance(width, height, Image.SCALE_SMOOTH));

    return icond;
  }

  /**
   * Returns an ImageIcon, or null if the path was invalid.
   *
   * @param path the path
   * @param width the width
   * @param height the height
   * @return the image icon
   */
  public static ImageIcon createImageIconBut(String path, int width, int height) {
    ImageIcon icond = new ImageIcon(new ImageIcon(Util.class.getResource(path)).getImage()
        .getScaledInstance(width, height, Image.SCALE_SMOOTH));
    return icond;
  }

  /**
   * Gets the color.
   *
   * @param comp the comp
   * @return the color
   */
  public static Color getColor(String comp) {
    Color color = null;
    switch (comp) {
      case "label":
        color = Color.BLACK;
        break;
      case "textField":
        color = new Color(245, 244, 186);
        break;
    }
    return color;
  }

  /**
   * Gets the font.
   *
   * @param comp the comp
   * @return the font
   */
  public static Font getFont(String comp) {
    Font font = null;
    switch (comp) {
      case "labelBold":
        font = new Font("Arial", Font.BOLD, 13);
        break;
      case "label":
        font = new Font("Arial", Font.PLAIN, 13);
        break;
      case "textField":
        font = new Font("Arial", Font.BOLD, 14);
        break;
      case "border":
        font = new Font("Serif", Font.ITALIC, 15);
        break;
    }
    return font;
  }

  /**
   * Gets the name without extension.
   *
   * @param file the file
   * @return the name without extension
   */
  public static String getNameWithoutExtension(String file) {
    if (isNullOrEmpty(file)) {
      String fileName = new File(file).getName();
      int dotIndex = fileName.lastIndexOf('.');
      return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
    return null;
  }

  /**
   * Gets the file extension.
   *
   * @param fullName the full name
   * @return the file extension
   */
  public static String getFileExtension(String fullName) {
    if (isNullOrEmpty(fullName)) {
      String fileName = new File(fullName).getName();
      int dotIndex = fileName.lastIndexOf('.');
      return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
    return null;
  }

  /**
   * A utility method that reads config properties file.
   *
   * @return the properties
   */
  public static Properties loadProperties() {
    if (properties == null) {
      properties = new Properties();
      try {
        InputStream inputStream =
            Util.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
        if (inputStream != null) {
          properties.load(inputStream);
          inputStream.close();
        } else {
          throw new FileNotFoundException(
              "property file '" + CONFIG_PROPERTIES + "' not found in the classpath");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties;
  }

  /**
   * Gets the locale.
   *
   * @return the locale
   */
  public static Locale getLocale() {

    String language = "";
    String region = "";

    switch (APPLICATION_LANGUAGE) {
      case "en":
        language = "en";
        region = "EN";
        break;
      default:
        language = "ro";
        region = "RO";
        break;
    }
    Locale newLocale = new Locale.Builder().setLanguage(language).setRegion(region).build();
    return newLocale;
  }

  public static Properties getConfigProperties() {
    return loadProperties();
  }
  // http://grepcode.com/file/repo1.maven.org/maven2/com.google.guava/guava/15.0/com/google/common/io/Files.java
}
