package org.ownbit.password.manager.utils;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * The Class FileTypeFilter.
 */
public class FileTypeFilter extends FileFilter {

  /** The extension. */
  private String extension;

  /** The description. */
  private String description;

  /**
   * Instantiates a new file type filter.
   *
   * @param extension the extension
   * @param description the description
   */
  public FileTypeFilter(String extension, String description) {
    this.extension = extension;
    this.description = description;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
   */
  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    }
    return file.getName().endsWith(extension);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileFilter#getDescription()
   */
  public String getDescription() {
    return description + String.format(" (*%s)", extension);
  }
}
