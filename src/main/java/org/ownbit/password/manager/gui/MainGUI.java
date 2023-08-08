package org.ownbit.password.manager.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellRenderer;

import org.ownbit.password.manager.custom.CustomJMenuBar;
import org.ownbit.password.manager.custom.CustomJPopupMenu;
import org.ownbit.password.manager.custom.CustomSystemTray;
import org.ownbit.password.manager.custom.Patterns;
import org.ownbit.password.manager.layout.Constraints;
import org.ownbit.password.manager.layout.GroupLayout;
import org.ownbit.password.manager.layout.Leading;
import org.ownbit.password.manager.model.CategoryModel;
import org.ownbit.password.manager.model.DatabaseModel;
import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.service.BaseService;
import org.ownbit.password.manager.table.CustomTableCellRenderer;
import org.ownbit.password.manager.table.CustomTableModel;
import org.ownbit.password.manager.table.TableMouseListener;
import org.ownbit.password.manager.utils.Constants;
import org.ownbit.password.manager.utils.LanguageKey;
import org.ownbit.password.manager.utils.Util;

public class MainGUI extends CustomSystemTray implements LanguageKey {
  private static final long serialVersionUID = 1L;
  private JLabel labelsearcH;
  private JTextField textSearch;
  private JButton butSearch;
  private JScrollPane scrollerTable = null;
  private static JButton butBrowse;
  private static String databasePath;
  private static JLabel databaseName;
  private static ArrayList<PasswordModel> dataList = new ArrayList<PasswordModel>();
  private static CustomTableModel tableModel;
  private static JTable table;
  private static DatabaseModel databaseModel;
  private JLabel labelCategory;
  private static DefaultComboBoxModel<CategoryModel> model;
  private static JComboBox<CategoryModel> comboCategory;

  public MainGUI() throws UnsupportedLookAndFeelException {
    initUI();
  }

  private void initUI() throws UnsupportedLookAndFeelException {

    Util.installLnF();
    setTitle(S_MAIN_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(750, 570));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setResizable(true);
    setLayout(new GroupLayout());
    setIconImage(
        Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_FRAME_MAIN)));
    setResizable(false);
    pack();
    setLocationRelativeTo(null);
    initilizeComponent();
    setJMenuBar(new CustomJMenuBar());
  }

  /*
   * private File getJarFile() throws FileNotFoundException { String path =
   * MainGUI.class.getResource(MainGUI.class.getSimpleName() + ".class").getFile();
   * if(path.startsWith("/")) { throw new FileNotFoundException("This is not a jar file: \n" +
   * path); } path = ClassLoader.getSystemClassLoader().getResource(path).getFile(); path =
   * path.substring(0, path.lastIndexOf('!'));
   * 
   * return new File(path.substring(path.lastIndexOf("file") + 6, path.length())); }
   */

  private void initilizeComponent() {

    /*
     * JarFile jar; try { jar = new JarFile(getJarFile().getAbsolutePath()); JarEntry jarEntry =
     * jar.getJarEntry("config.properties"); Properties props = new Properties(); props.load(
     * jar.getInputStream(jarEntry) ); JOptionPane.showMessageDialog(null, props, "Path Jar0",
     * JOptionPane.WARNING_MESSAGE); JOptionPane.showMessageDialog(null,
     * props.get("application.language"), "Path Jar1", JOptionPane.WARNING_MESSAGE); jar.close();
     * 
     * props.put("test", "test");
     * 
     * FileOutputStream fstream = new FileOutputStream(getJarFile()); JarOutputStream stream = new
     * JarOutputStream(fstream, props); stream.flush(); stream.close();
     * 
     * JarOutputStream jarOut=new JarOutputStream(new
     * FileOutputStream(getJarFile().getAbsolutePath() + "tst")); jarOut.putNextEntry(new
     * ZipEntry(name)); props.put("test", "test"); props.store( jarOut, null ); jarOut.closeEntry();
     * 
     * out.putNextEntry(new ZipEntry("test")); out.closeEntry(); out.close();
     * 
     * } catch (Exception e3) { e3.printStackTrace(); }
     */
    /*
     * PropertiesConfiguration config; try { config = new
     * PropertiesConfiguration("config.properties"); JOptionPane.showMessageDialog(null, config,
     * "TEst", JOptionPane.WARNING_MESSAGE); JOptionPane.showMessageDialog(null,
     * config.getBasePath(), "Path", JOptionPane.WARNING_MESSAGE);
     * //config.setProperty("Google_Address", "Mountain View, CA, US"); //config.save(); } catch
     * (ConfigurationException e1) { e1.printStackTrace(); }
     */

    labelsearcH = Patterns.getCustomLabel(S_MAIN_L_SEARCH);

    textSearch = Patterns.getCustomTextField();
    textSearch.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          butSearch.doClick();
        }
      }
    });

    labelCategory = Patterns.getCustomLabel(S_MAIN_L_CATEGORY);

    model = new DefaultComboBoxModel<CategoryModel>();
    comboCategory = new JComboBox<CategoryModel>();
    comboCategory.setBackground(Util.getColor("textField"));
    comboCategory.setFont(Util.getFont("textField"));
    comboCategory.setModel(model);
    comboCategory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butSearch.doClick();
      }
    });

    databaseName = new JLabel();

    butSearch = new JButton(S_MAIN_B_SEARCH);
    butSearch.setHorizontalAlignment(SwingConstants.LEFT);
    butSearch.setIcon(Util.createImageIconBut(Constants.IMG_BUT_SEARCH, Constants.IMG_DEFAULT_WIDTH,
        Constants.IMG_DEFAULT_HEIGHT));
    butSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (databaseModel != null) {

          CategoryModel categoryModel = (CategoryModel) comboCategory.getSelectedItem();
          ArrayList<PasswordModel> dataList =
              BaseService.getAllPasswordData(textSearch.getText(), categoryModel);
          loadTable(dataList);
        } else {
          JOptionPane.showMessageDialog(null, S_MAIN_MSG_TABLE_EMPTY_B, S_MAIN_MSG_TABLE_EMPTY_H,
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    butBrowse = new JButton(S_MAIN_B_OPEN_DB);
    butBrowse.setHorizontalAlignment(SwingConstants.LEFT);
    butBrowse.setIcon(Util.createImageIconBut(Constants.IMG_SELECT_DATABASE,
        Constants.IMG_DEFAULT_WIDTH, Constants.IMG_DEFAULT_HEIGHT));
    butBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser fileChooser = new JFileChooser();
        // fileChooser.setCurrentDirectory(new
        // File(System.getProperty("user.home")));
        fileChooser.setCurrentDirectory(new File(getExecutionPath()));
        int resultChooser = fileChooser.showDialog(MainGUI.this, S_MAIN_CH_OPEN_DB);
        if (resultChooser == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          databasePath = selectedFile.getAbsolutePath();

          if (!Util.isNullOrEmpty(databasePath)) {
            PasswordGUI passwordGUI = new PasswordGUI();
            passwordGUI.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(null, S_MAIN_MSG_OPEN_DB_B, S_MAIN_MSG_OPEN_DB_H,
                JOptionPane.WARNING_MESSAGE);
          }
        }
      }
    });

    createJTableData();

    add(labelsearcH, new Constraints(new Leading(10, 10, 10), new Leading(12, 12, 12)));
    add(textSearch, new Constraints(new Leading(10, 260, 10, 10), new Leading(30, 26, 12, 12)));
    add(butSearch, new Constraints(new Leading(480, 10, 10), new Leading(25, 10, 10)));
    add(butBrowse, new Constraints(new Leading(600, 10, 10), new Leading(25, 10, 10)));
    add(scrollerTable, new Constraints(new Leading(10, 715, 10, 10), new Leading(80, 410, 10, 10)));
    add(labelCategory, new Constraints(new Leading(282, 10, 10), new Leading(12, 12, 12)));
    add(comboCategory, new Constraints(new Leading(280, 180, 10, 10), new Leading(30, 26, 12, 12)));
  }

  private static void loadDataTable(ArrayList<PasswordModel> dataList) {
    MainGUI.dataList = dataList;
    table.setModel(new CustomTableModel(MainGUI.dataList));
  }

  public static void loadTable(ArrayList<PasswordModel> dataList) {
    loadDataTable(dataList);
  }

  private void createJTableData() {

    tableModel = new CustomTableModel(dataList);
    table = new JTable(tableModel);

    table.setComponentPopupMenu(new CustomJPopupMenu());
    table.addMouseListener(new TableMouseListener(table));
    table.setFillsViewportHeight(true);
    table.setFocusable(false);
    table.setAutoCreateRowSorter(true); // enable sorting and filtering of
    // rows

    TableCellRenderer original = table.getTableHeader().getDefaultRenderer();
    table.getTableHeader().setDefaultRenderer(new CustomTableCellRenderer(original));

    scrollerTable = new JScrollPane();
    scrollerTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollerTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollerTable.setViewportView(table); // load main table to scrollpane
  }

  private String getExecutionPath() {
    String absolutePath =
        MainGUI.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));
    absolutePath = absolutePath.replaceAll("%20", " "); // Surely need to do
    // this here
    return absolutePath;
  }

  public static void callBrowseButton() {
    butBrowse.doClick();
  }

  public static DatabaseModel getDatabaseModel() {
    return databaseModel;
  }

  public static void setDatabaseModel(DatabaseModel databaseModel) {
    MainGUI.databaseModel = databaseModel;
  }

  public static JLabel getDatabaseName() {
    return databaseName;
  }

  public static void setDatabaseName(String databaseName) {
    MainGUI.databaseName.setText(databaseName);
  }

  public static String getDatabasePath() {
    return databasePath;
  }

  public static void setDatabasePath(String databasePath) {
    MainGUI.databasePath = databasePath;
  }

  public static void closeDatabase() {
    databaseModel = null;
    databaseName.setText("");
    loadTable(new ArrayList<PasswordModel>());
  }

  public static JTable getJTable() {
    return table;
  }

  public static void loadCategoryModel() {
    model = new DefaultComboBoxModel<CategoryModel>(BaseService.getCategories(0));
    comboCategory.setModel(model);
  }

  public static ArrayList<PasswordModel> getPasswordList() {
    return dataList;
  }
}
