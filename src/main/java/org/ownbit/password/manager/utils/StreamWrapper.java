package org.ownbit.password.manager.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * The Class StreamWrapper.
 */
public class StreamWrapper {

  /**
   * Gets the stream gobbler.
   *
   * @param is the is
   * @param type the type
   * @return the stream gobbler
   */
  public StreamGobbler getStreamGobbler(InputStream is, String type) {
    return new StreamGobbler(is, type);
  }

  /**
   * The Class StreamGobbler.
   */
  public class StreamGobbler extends Thread {

    /** The input stream. */
    InputStream inputStream = null;

    /** The type. */
    String type = null;

    /** The message. */
    String message = null;

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
      return message;
    }

    /**
     * Instantiates a new stream gobbler.
     *
     * @param is the is
     * @param type the type
     */
    StreamGobbler(InputStream is, String type) {
      this.inputStream = is;
      this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
      try {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.inputStream));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
          buffer.append(line);
        }
        message = buffer.toString();
        this.inputStream.close();
      } catch (IOException ioe) {
        JOptionPane.showMessageDialog(null, ioe.getMessage(), "Runtime execution problem",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
