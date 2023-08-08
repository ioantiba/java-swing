package org.ownbit.password.manager.utils;

import java.util.Properties;

/**
 * The Interface Constants.
 */
public class Constants {

    /** The Constant CONFIG. */
    public static final Properties CONFIG = Util.getConfigProperties();

    /** GENERAL SETTINGS. */
    public static final String APPLICATION_LANGUAGE = CONFIG.getProperty("application.language");

    /** EMAIL SETTINGS. */
    public static final String SMTP_AUTH = CONFIG.getProperty("mail.smtp.auth");
    
    /** The Constant SMTP_STARTTLS. */
    public static final String SMTP_STARTTLS = CONFIG.getProperty("mail.smtp.starttls.enable");
    
    /** The Constant SMTP_HOST. */
    public static final String SMTP_HOST = CONFIG.getProperty("mail.smtp.host");
    
    /** The Constant SMTP_PORT. */
    public static final String SMTP_PORT = CONFIG.getProperty("mail.smtp.port");
    
    /** The Constant SMTP_USERNAME. */
    public static final String SMTP_USERNAME = CONFIG.getProperty("mail.user");
    
    /** The Constant SMTP_PASSWORD. */
    public static final String SMTP_PASSWORD = CONFIG.getProperty("mail.password");

    /** DATABASE CONFIGURATION. */
    public static final String DATABASE_DRIVER = "org.h2.Driver";
    
    /** The Constant DATABASE_USERNAME. */
    public static final String DATABASE_USERNAME = "ADMINISTRATOR";
    
    /** The Constant DATABASE_ENCRYPT. */
    public static final String DATABASE_ENCRYPT = "Xb8n@WRX47Z$CULVF%Rm6Xy";
    
    /** The Constant DATABASE_EXT. */
    public static final String DATABASE_EXT = ".mv.db";
    
    /** The Constant IMG_DEFAULT_WIDTH. */
    public static final int IMG_DEFAULT_WIDTH = 24;
    
    /** The Constant IMG_DEFAULT_HEIGHT. */
    public static final int IMG_DEFAULT_HEIGHT = 24;

    /** IMAGES PATH. */
    public static final String IMG_GENERAL_DOCUMENTS = "/images/documents.png";
    
    /** The Constant IMG_BUT_SEARCH. */
    public static final String IMG_BUT_SEARCH = "/images/search2.png";
    
    /** The Constant IMG_TRAY_ICON. */
    public static final String IMG_TRAY_ICON = "/images/key_password.png";
    
    /** The Constant IMG_SELECT_DATABASE. */
    public static final String IMG_SELECT_DATABASE = "/images/browse.png";
    
    /** The Constant IMG_BUT_VALIDATE_PASS. */
    public static final String IMG_BUT_VALIDATE_PASS = "/images/validate_pass.png";
    
    /** The Constant IMG_BUT_CREATE_DATABASE. */
    public static final String IMG_BUT_CREATE_DATABASE = "/images/new_database.png";
    
    /** The Constant IMG_SET_NAME_DATABASE. */
    public static final String IMG_SET_NAME_DATABASE = "/images/browse.png";
    
    /** The Constant IMG_BUT_PLUS. */
    public static final String IMG_BUT_PLUS = "/images/plus.png";
    
    /** The Constant IMG_BUT_GENERATE_PASS. */
    public static final String IMG_BUT_GENERATE_PASS = "/images/generate_keys.png";
    
    /** The Constant IMG_BUT_DATABASE_CLOSE. */
    public static final String IMG_BUT_DATABASE_CLOSE = "/images/database_close.png";
    
    /** The Constant IMG_BUT_POPUP_DELETE. */
    public static final String IMG_BUT_POPUP_DELETE = "/images/delete.png";
    
    /** The Constant IMG_BUT_POPUP_REDIRECT_ADDRESS. */
    public static final String IMG_BUT_POPUP_REDIRECT_ADDRESS = "/images/redirect.png";
    
    /** The Constant IMG_BUT_POPUP_COPY. */
    public static final String IMG_BUT_POPUP_COPY = "/images/copy.png";
    
    /** The Constant IMG_BUT_POPUP_CELL. */
    public static final String IMG_BUT_POPUP_CELL = "/images/cell.png";
    
    /** The Constant IMG_BUT_SOFTWARE_UPDATE. */
    public static final String IMG_BUT_SOFTWARE_UPDATE = "/images/software_update.png";
    
    /** The Constant IMG_BUT_SOFTWARE_NETWORK. */
    public static final String IMG_BUT_SOFTWARE_NETWORK = "/images/network.png";
    
    /** The Constant IMG_BUT_CATEGORY_SAVE. */
    public static final String IMG_BUT_CATEGORY_SAVE = "/images/save.png";
    
    /** The Constant IMG_BUT_CATEGORY_DELETE. */
    public static final String IMG_BUT_CATEGORY_DELETE = "/images/delete.png";
    
    /** The Constant IMG_FRAME_SEND_EMAIL. */
    public static final String IMG_FRAME_SEND_EMAIL = "/images/send_email.png";
    
    /** The Constant IMG_BUT_EXPORT_EXCEL. */
    public static final String IMG_BUT_EXPORT_EXCEL = "/images/excel.png";
    
    /** The Constant IMG_BUT_EXPORT_PDF. */
    public static final String IMG_BUT_EXPORT_PDF = "/images/pdf.png";
    
    /** The Constant IMG_BUT_CHART. */
    public static final String IMG_BUT_CHART = "/images/chart.png";
    
    /** The Constant IMG_BUT_SEND_EMAIL. */
    public static final String IMG_BUT_SEND_EMAIL = "/images/send_email.png";

    /** The Constant IMG_LABEL_FROM_EMAIL. */
    public static final String IMG_LABEL_FROM_EMAIL = "/images/from.png";
    
    /** The Constant IMG_LABEL_TO_EMAIL. */
    public static final String IMG_LABEL_TO_EMAIL = "/images/to.png";
    
    /** The Constant IMG_LABEL_CC_EMAIL. */
    public static final String IMG_LABEL_CC_EMAIL = "/images/cc.png";
    
    /** The Constant IMG_LABEL_SUBJECT_EMAIL. */
    public static final String IMG_LABEL_SUBJECT_EMAIL = "/images/subject.png";
    
    /** The Constant IMG_LABEL_MESSAGE_EMAIL. */
    public static final String IMG_LABEL_MESSAGE_EMAIL = "/images/message.png";
    // public static final String IMG_BUT_SEND_EMAIL = "/images/mail-send.png";

    /** The Constant IMG_FRAME_MAIN. */
    /* FRAME IMAGES */
    public static final String IMG_FRAME_MAIN = "/images/key_password.png";
    
    /** The Constant IMG_FRAME_NEW_ENTRY. */
    public static final String IMG_FRAME_NEW_ENTRY = "/images/key_password.png";

    /** The Constant IMG_MENU_FILE. */
    /* FILE MENU */
    public static final String IMG_MENU_FILE = "/images/files.png";
    
    /** The Constant IMG_MENU_FILE_NEW_DATABASE. */
    public static final String IMG_MENU_FILE_NEW_DATABASE = "/images/database_add.png";
    
    /** The Constant IMG_MENU_FILE_FOLDER_OPEN. */
    public static final String IMG_MENU_FILE_FOLDER_OPEN = "/images/folder_open.png";
    
    /** The Constant IMG_MENU_FILE_EXIT. */
    public static final String IMG_MENU_FILE_EXIT = "/images/exit.png";

    /** The Constant IMG_MENU_TOOLS. */
    /* TOOLS MENU */
    public static final String IMG_MENU_TOOLS = "/images/tools.png";
    
    /** The Constant IMG_MENU_TOOLS_GENERATE_PASSWORD. */
    public static final String IMG_MENU_TOOLS_GENERATE_PASSWORD = "/images/key_password.png";
    
    /** The Constant IMG_MENU_TOOLS_OPTIONS. */
    public static final String IMG_MENU_TOOLS_OPTIONS = "/images/setting.png";
    
    /** The Constant IMG_MENU_TOOLS_NEW_ENTRY. */
    public static final String IMG_MENU_TOOLS_NEW_ENTRY = "/images/add.png";
    
    /** The Constant IMG_MENU_TOOLS_SAVE. */
    public static final String IMG_MENU_TOOLS_SAVE = "/images/save.png";
    
    /** The Constant IMG_MENU_TOOLS_CHANGE. */
    public static final String IMG_MENU_TOOLS_CHANGE = "/images/change.png";
    
    /** The Constant IMG_MENU_TOOLS_CLEAR. */
    public static final String IMG_MENU_TOOLS_CLEAR = "/images/clear.png";

    /** The Constant IMG_MENU_VIEW. */
    /* VIEW MENU */
    public static final String IMG_MENU_VIEW = "/images/view.png";
    
    /** The Constant IMG_MENU_VIEW_LANGUAGE. */
    public static final String IMG_MENU_VIEW_LANGUAGE = "/images/language.png";

    /** The Constant IMG_MENU_HELP. */
    /* HELP MENU */
    public static final String IMG_MENU_HELP = "/images/help.png";
    
    /** The Constant IMG_MENU_HELP_INFO. */
    public static final String IMG_MENU_HELP_INFO = "/images/info.png";
    
    /** The Constant IMG_MENU_HELP_MANUAL. */
    public static final String IMG_MENU_HELP_MANUAL = "/images/manual.png";
}
