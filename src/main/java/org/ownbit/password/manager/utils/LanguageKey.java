package org.ownbit.password.manager.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Interface LanguageKey.
 */
public interface LanguageKey {

    /** The Constant LOCALE. */
    public static final Locale LOCALE = Util.getLocale();
    
    /** The Constant BUNDLE. */
    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("Language", LOCALE);

    /** LANGUAGE TRANSLATIONS. */
    public static final String S_MAIN_TITLE = BUNDLE.getString("application.title");
    
    /** The Constant S_MAIN_L_SEARCH. */
    public static final String S_MAIN_L_SEARCH = BUNDLE.getString("label.search");
    
    /** The Constant S_MAIN_L_CATEGORY. */
    public static final String S_MAIN_L_CATEGORY = BUNDLE.getString("label.category");
    
    /** The Constant S_MAIN_B_SEARCH. */
    public static final String S_MAIN_B_SEARCH = BUNDLE.getString("button.search");
    
    /** The Constant S_MAIN_MSG_TABLE_EMPTY_B. */
    public static final String S_MAIN_MSG_TABLE_EMPTY_B = BUNDLE.getString("message.table.empty.body");
    
    /** The Constant S_MAIN_MSG_TABLE_EMPTY_H. */
    public static final String S_MAIN_MSG_TABLE_EMPTY_H = BUNDLE.getString("message.table.empty.header");
    
    /** The Constant S_MAIN_B_OPEN_DB. */
    public static final String S_MAIN_B_OPEN_DB = BUNDLE.getString("button.open.database");
    
    /** The Constant S_MAIN_CH_OPEN_DB. */
    public static final String S_MAIN_CH_OPEN_DB = BUNDLE.getString("chooser.open.database");
    
    /** The Constant S_MAIN_MSG_OPEN_DB_B. */
    public static final String S_MAIN_MSG_OPEN_DB_B = BUNDLE.getString("message.choser.open.database.body");
    
    /** The Constant S_MAIN_MSG_OPEN_DB_H. */
    public static final String S_MAIN_MSG_OPEN_DB_H = BUNDLE.getString("message.choser.open.database.header");

    /** The Constant S_MENU_FILE. */
    public static final String S_MENU_FILE = BUNDLE.getString("menu.file");
    
    /** The Constant S_MENU_FILE_NEW_DB. */
    public static final String S_MENU_FILE_NEW_DB = BUNDLE.getString("menu.file.new.database");
    
    /** The Constant S_MENU_FILE_MSG_CLOSE_DB_B. */
    public static final String S_MENU_FILE_MSG_CLOSE_DB_B = BUNDLE
	    .getString("menu.file.msg.close.opened.database.body");
    
    /** The Constant S_MENU_FILE_MSG_CLOSE_DB_H. */
    public static final String S_MENU_FILE_MSG_CLOSE_DB_H = BUNDLE
	    .getString("menu.file.msg.close.opened.database.header");
    
    /** The Constant S_MENU_FILE_CLOSE_DB. */
    public static final String S_MENU_FILE_CLOSE_DB = BUNDLE.getString("menu.file.close.database");
    
    /** The Constant S_MENU_FILE_OPEN_DB. */
    public static final String S_MENU_FILE_OPEN_DB = BUNDLE.getString("menu.file.open.database");
    
    /** The Constant S_MENU_FILE_EXIT. */
    public static final String S_MENU_FILE_EXIT = BUNDLE.getString("menu.file.exit");

    /** The Constant S_MENU_TOOLS. */
    public static final String S_MENU_TOOLS = BUNDLE.getString("menu.tools");
    
    /** The Constant S_MENU_TOOLS_GEN_PASS. */
    public static final String S_MENU_TOOLS_GEN_PASS = BUNDLE.getString("menu.tools.generate.password");
    
    /** The Constant S_MENU_TOOLS_CHANGE_DB_PASS. */
    public static final String S_MENU_TOOLS_CHANGE_DB_PASS = BUNDLE.getString("menu.tools.change.database.password");
    
    /** The Constant S_MENU_TOOLS_MSG_OPEN_DB_B. */
    public static final String S_MENU_TOOLS_MSG_OPEN_DB_B = BUNDLE.getString("menu.tools.msg.open.database.first.body");
    
    /** The Constant S_MENU_TOOLS_MSG_OPEN_DB_H. */
    public static final String S_MENU_TOOLS_MSG_OPEN_DB_H = BUNDLE
	    .getString("menu.tools.msg.open.database.first.header");
    
    /** The Constant S_MENU_TOOLS_EXP_EXCEL. */
    public static final String S_MENU_TOOLS_EXP_EXCEL = BUNDLE.getString("menu.tools.export.excel");
    
    /** The Constant S_MENU_TOOLS_EXP_EXCEL_DLG_TITLE. */
    public static final String S_MENU_TOOLS_EXP_EXCEL_DLG_TITLE = BUNDLE
	    .getString("menu.tools.export.excel.dialog.title");
    
    /** The Constant S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_B. */
    public static final String S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_B = BUNDLE
	    .getString("menu.tools.export.excel.msg.open.database.body");
    
    /** The Constant S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_H. */
    public static final String S_MENU_TOOLS_EXP_EXCEL_DLG_MSG_H = BUNDLE
	    .getString("menu.tools.export.excel.msg.open.database.header");
    
    /** The Constant S_MENU_TOOLS_SEND_EMAIL. */
    public static final String S_MENU_TOOLS_SEND_EMAIL = BUNDLE.getString("menu.tools.send.email");
    
    /** The Constant S_MENU_TOOLS_MSG_SEL_ROW_B. */
    public static final String S_MENU_TOOLS_MSG_SEL_ROW_B = BUNDLE.getString("menu.tools.msg.select.row.body");
    
    /** The Constant S_MENU_TOOLS_MSG_SEL_ROW_H. */
    public static final String S_MENU_TOOLS_MSG_SEL_ROW_H = BUNDLE.getString("menu.tools.msg.select.row.header");
    
    /** The Constant S_MENU_TOOLS_MSG_TABLE_EMTY_B. */
    public static final String S_MENU_TOOLS_MSG_TABLE_EMTY_B = BUNDLE.getString("menu.tools.msg.table.empty.body");
    
    /** The Constant S_MENU_TOOLS_MSG_TABLE_EMTY_H. */
    public static final String S_MENU_TOOLS_MSG_TABLE_EMTY_H = BUNDLE.getString("menu.tools.msg.table.empty.header");
    
    /** The Constant S_MENU_TOOLS_NEW_ENTRY. */
    public static final String S_MENU_TOOLS_NEW_ENTRY = BUNDLE.getString("menu.tools.new.entry");
    
    /** The Constant S_MENU_TOOLS_MSG_NEW_ENTRY_B. */
    public static final String S_MENU_TOOLS_MSG_NEW_ENTRY_B = BUNDLE
	    .getString("menu.tools.new.entry.msg.select.database.body");
    
    /** The Constant S_MENU_TOOLS_MSG_NEW_ENTRY_H. */
    public static final String S_MENU_TOOLS_MSG_NEW_ENTRY_H = BUNDLE
	    .getString("menu.tools.new.entry.msg.select.database.header");

    /** The Constant S_MENU_HELP. */
    public static final String S_MENU_HELP = BUNDLE.getString("menu.help");
    
    /** The Constant S_MENU_HELP_ABOUT. */
    public static final String S_MENU_HELP_ABOUT = BUNDLE.getString("menu.help.about");

    /** The Constant S_TABLE_COLUMN_ID. */
    public static final String S_TABLE_COLUMN_ID = BUNDLE.getString("table.column.header.name.id");
    
    /** The Constant S_TABLE_COLUMN_TITLE. */
    public static final String S_TABLE_COLUMN_TITLE = BUNDLE.getString("table.column.header.name.title");
    
    /** The Constant S_TABLE_COLUMN_USERNAME. */
    public static final String S_TABLE_COLUMN_USERNAME = BUNDLE.getString("table.column.header.name.username");
    
    /** The Constant S_TABLE_COLUMN_PASSWORD. */
    public static final String S_TABLE_COLUMN_PASSWORD = BUNDLE.getString("table.column.header.name.password");
    
    /** The Constant S_TABLE_COLUMN_URL. */
    public static final String S_TABLE_COLUMN_URL = BUNDLE.getString("table.column.header.name.url");
    
    /** The Constant S_TABLE_COLUMN_COMMENT. */
    public static final String S_TABLE_COLUMN_COMMENT = BUNDLE.getString("table.column.header.name.comment");

    /** The Constant S_GUI_ABOUT_TITLE. */
    public static final String S_GUI_ABOUT_TITLE = BUNDLE.getString("about.gui.title");
    
    /** The Constant S_GUI_SOFTWARE_TITLE. */
    public static final String S_GUI_SOFTWARE_TITLE = BUNDLE.getString("about.gui.software.title");
    
    /** The Constant S_GUI_DEVELOPER. */
    public static final String S_GUI_DEVELOPER = "<html>" + BUNDLE.getString("about.gui.developer")
	    + " <font color='red'>swe. Ioan Tiba</font></html>";
    
    /** The Constant S_GUI_DEVELOPER_EMAIL. */
    public static final String S_GUI_DEVELOPER_EMAIL = "<html>" + BUNDLE.getString("about.gui.developer.email")
	    + "  <font color='red'>ioantiba@gmail.com</font></html>";
    
    /** The Constant S_GUI_DEVELOPER_WEB. */
    public static final String S_GUI_DEVELOPER_WEB = "<html>" + BUNDLE.getString("about.gui.developer.web")
	    + "  <font color='red'>www.ownbit.org</font></html>";

    /** The Constant S_GUI_CATEG_TITLE. */
    public static final String S_GUI_CATEG_TITLE = BUNDLE.getString("category.gui.title");
    
    /** The Constant S_GUI_CATEG_NAME. */
    public static final String S_GUI_CATEG_NAME = BUNDLE.getString("category.gui.name");
    
    /** The Constant S_GUI_CATEG_SAVE. */
    public static final String S_GUI_CATEG_SAVE = BUNDLE.getString("category.gui.save");
    
    /** The Constant S_GUI_CATEG_MSG_EMPTY_NAME_B. */
    public static final String S_GUI_CATEG_MSG_EMPTY_NAME_B = BUNDLE.getString("category.gui.msg.empty.name.body");
    
    /** The Constant S_GUI_CATEG_MSG_EMPTY_NAME_H. */
    public static final String S_GUI_CATEG_MSG_EMPTY_NAME_H = BUNDLE.getString("category.gui.msg.empty.name.header");

    /** The Constant S_GUI_CATEG_MSG_COMPLETE_PASS_B. */
    public static final String S_GUI_CATEG_MSG_COMPLETE_PASS_B = BUNDLE
	    .getString("category.gui.msg.complete.pass.body");
    
    /** The Constant S_GUI_CATEG_MSG_COMPLETE_PASS_H. */
    public static final String S_GUI_CATEG_MSG_COMPLETE_PASS_H = BUNDLE
	    .getString("category.gui.msg.complete.pass.header");

    /** The Constant S_GUI_CHANGE_PASS_TITLE. */
    public static final String S_GUI_CHANGE_PASS_TITLE = BUNDLE.getString("change.pass.gui.title");
    
    /** The Constant S_GUI_CHANGE_NEW_PASS. */
    public static final String S_GUI_CHANGE_NEW_PASS = BUNDLE.getString("change.pass.gui.pass");
    
    /** The Constant S_GUI_CHANGE_SELECT_DB. */
    public static final String S_GUI_CHANGE_SELECT_DB = BUNDLE.getString("change.pass.gui.select.db");
    
    /** The Constant S_GUI_CHANGE_SAVE. */
    public static final String S_GUI_CHANGE_SAVE = BUNDLE.getString("change.pass.gui.save");
    
    /** The Constant S_GUI_CHANGE_MSG_FILL_PASS_B. */
    public static final String S_GUI_CHANGE_MSG_FILL_PASS_B = BUNDLE
	    .getString("change.pass.gui.msg.fill.password.body");
    
    /** The Constant S_GUI_CHANGE_MSG_FILL_PASS_H. */
    public static final String S_GUI_CHANGE_MSG_FILL_PASS_H = BUNDLE
	    .getString("change.pass.gui.msg.fill.password.header");
    
    /** The Constant S_GUI_CHANGE_MSG_PASS_NOT_CH_B. */
    public static final String S_GUI_CHANGE_MSG_PASS_NOT_CH_B = BUNDLE
	    .getString("change.pass.gui.msg.pass.not.change.body");
    
    /** The Constant S_GUI_CHANGE_MSG_PASS_NOT_CH_H. */
    public static final String S_GUI_CHANGE_MSG_PASS_NOT_CH_H = BUNDLE
	    .getString("change.pass.gui.msg.pass.not.change.header");

    /** The Constant S_GUI_SEND_EMAIL_TITLE. */
    public static final String S_GUI_SEND_EMAIL_TITLE = BUNDLE.getString("send.email.gui.title");
    
    /** The Constant S_GUI_SEND_EMAIL_FROM. */
    public static final String S_GUI_SEND_EMAIL_FROM = BUNDLE.getString("send.email.gui.from");
    
    /** The Constant S_GUI_SEND_EMAIL_TO. */
    public static final String S_GUI_SEND_EMAIL_TO = BUNDLE.getString("send.email.gui.to");
    
    /** The Constant S_GUI_SEND_EMAIL_CC. */
    public static final String S_GUI_SEND_EMAIL_CC = BUNDLE.getString("send.email.gui.cc");
    
    /** The Constant S_GUI_SEND_EMAIL_SUBJECT. */
    public static final String S_GUI_SEND_EMAIL_SUBJECT = BUNDLE.getString("send.email.gui.subject");
    
    /** The Constant S_GUI_SEND_EMAIL_MESSAGE. */
    public static final String S_GUI_SEND_EMAIL_MESSAGE = BUNDLE.getString("send.email.gui.message");
    
    /** The Constant S_GUI_SEND_EMAIL_BUT_SEND. */
    public static final String S_GUI_SEND_EMAIL_BUT_SEND = BUNDLE.getString("send.email.gui.but.send.email");

    /** The Constant S_GUI_NEW_ENTRY_TITLE. */
    public static final String S_GUI_NEW_ENTRY_TITLE = BUNDLE.getString("entry.gui.title");
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_TITLE. */
    public static final String S_GUI_NEW_ENTRY_LABEL_TITLE = "<html><font color='red'>*</font>"
	    + BUNDLE.getString("entry.gui.label.title") + "</html>";
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_USERNAME. */
    public static final String S_GUI_NEW_ENTRY_LABEL_USERNAME = "<html><font color='red'>*</font>"
	    + BUNDLE.getString("entry.gui.label.username") + "</html>";
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_PASSWORD. */
    public static final String S_GUI_NEW_ENTRY_LABEL_PASSWORD = "<html><font color='red'>*</font>"
	    + BUNDLE.getString("entry.gui.label.password") + "</html>";
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_URL. */
    public static final String S_GUI_NEW_ENTRY_LABEL_URL = "<html><font color='red'>*</font>"
	    + BUNDLE.getString("entry.gui.label.url") + "</html>";
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_CATEGORY. */
    public static final String S_GUI_NEW_ENTRY_LABEL_CATEGORY = "<html><font color='red'>*</font>"
	    + BUNDLE.getString("entry.gui.label.category") + "</html>";
    
    /** The Constant S_GUI_NEW_ENTRY_LABEL_COMMENT. */
    public static final String S_GUI_NEW_ENTRY_LABEL_COMMENT = BUNDLE.getString("entry.gui.label.comment");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_B = BUNDLE
	    .getString("entry.gui.msg.category.can.not.delete.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_CATEG_NO_DEL_H = BUNDLE
	    .getString("entry.gui.msg.category.can.not.delete.header");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_B = BUNDLE
	    .getString("entry.gui.msg.category.selected.invalid.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_CATEG_SEL_INV_H = BUNDLE
	    .getString("entry.gui.msg.category.selected.invalid.header");
    
    /** The Constant S_GUI_NEW_ENTRY_BUT_SAVE. */
    public static final String S_GUI_NEW_ENTRY_BUT_SAVE = BUNDLE.getString("entry.gui.but.save");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_REQ_FIELD_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_REQ_FIELD_B = BUNDLE.getString("entry.gui.msg.complete.field.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_REQ_FIELD_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_REQ_FIELD_H = BUNDLE
	    .getString("entry.gui.msg.complete.field.header");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_B = BUNDLE.getString("entry.gui.msg.save.succes.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_SUCCESS_H = BUNDLE
	    .getString("entry.gui.msg.save.succes.header");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_B = BUNDLE
	    .getString("entry.gui.msg.update.problem.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_UPDATE_PROBLEM_H = BUNDLE
	    .getString("entry.gui.msg.update.problem.header");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_DATA_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_DATA_B = BUNDLE.getString("entry.gui.msg.save.data.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_DATA_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_DATA_H = BUNDLE.getString("entry.gui.msg.save.data.header");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_B. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_B = BUNDLE.getString("entry.gui.msg.save.problem.body");
    
    /** The Constant S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_H. */
    public static final String S_GUI_NEW_ENTRY_MSG_SAVE_PROBLEM_H = BUNDLE
	    .getString("entry.gui.msg.save.problem.header");
    
    /** The Constant S_GUI_NEW_ENTRY_CLEAR_FIELD. */
    public static final String S_GUI_NEW_ENTRY_CLEAR_FIELD = BUNDLE.getString("entry.gui.clear.field");

    /** The Constant S_GUI_GEN_PASS_TITLE. */
    public static final String S_GUI_GEN_PASS_TITLE = BUNDLE.getString("gen.pass.gui.title");
    
    /** The Constant S_GUI_GEN_PASS_LABEL_CHR_SET. */
    public static final String S_GUI_GEN_PASS_LABEL_CHR_SET = BUNDLE.getString("gen.pass.gui.label.character.set");
    
    /** The Constant S_GUI_GEN_PASS_LENGTH_PASS. */
    public static final String S_GUI_GEN_PASS_LENGTH_PASS = BUNDLE.getString("gen.pass.gui.label.length.pass");
    
    /** The Constant S_GUI_GEN_PASS_BOX_UPPERCASE. */
    public static final String S_GUI_GEN_PASS_BOX_UPPERCASE = BUNDLE.getString("gen.pass.gui.box.upper.case");
    
    /** The Constant S_GUI_GEN_PASS_BOX_LOWERCASE. */
    public static final String S_GUI_GEN_PASS_BOX_LOWERCASE = BUNDLE.getString("gen.pass.gui.box.lower.case");
    
    /** The Constant S_GUI_GEN_PASS_BOX_DIGITS. */
    public static final String S_GUI_GEN_PASS_BOX_DIGITS = BUNDLE.getString("gen.pass.gui.box.digit");
    
    /** The Constant S_GUI_GEN_PASS_BOX_MINUS. */
    public static final String S_GUI_GEN_PASS_BOX_MINUS = BUNDLE.getString("gen.pass.gui.box.minus");
    
    /** The Constant S_GUI_GEN_PASS_BOX_UNDERLINE. */
    public static final String S_GUI_GEN_PASS_BOX_UNDERLINE = BUNDLE.getString("gen.pass.gui.box.underline");
    
    /** The Constant S_GUI_GEN_PASS_BOX_BRACKETS. */
    public static final String S_GUI_GEN_PASS_BOX_BRACKETS = BUNDLE.getString("gen.pass.gui.box.brackets");
    
    /** The Constant S_GUI_GEN_PASS_BOX_SPECIAL. */
    public static final String S_GUI_GEN_PASS_BOX_SPECIAL = BUNDLE.getString("gen.pass.gui.box.special");
    
    /** The Constant S_GUI_GEN_PASS_LABEL_GEN_PASS. */
    public static final String S_GUI_GEN_PASS_LABEL_GEN_PASS = BUNDLE.getString("gen.pass.gui.label.generated.pass");
    
    /** The Constant S_GUI_GEN_PASS_BUT_GEN_PASS. */
    public static final String S_GUI_GEN_PASS_BUT_GEN_PASS = BUNDLE.getString("gen.pass.gui.but.generate.pass");
    
    /** The Constant S_GUI_GEN_PASS_MSG_LENGTH_PASS_B. */
    public static final String S_GUI_GEN_PASS_MSG_LENGTH_PASS_B = BUNDLE.getString("gen.pass.gui.msg.length.pass.body");
    
    /** The Constant S_GUI_GEN_PASS_MSG_LENGTH_PASS_H. */
    public static final String S_GUI_GEN_PASS_MSG_LENGTH_PASS_H = BUNDLE
	    .getString("gen.pass.gui.msg.length.pass.header");
    
    /** The Constant S_GUI_GEN_PASS_MSG_MIN_CRIT_B. */
    public static final String S_GUI_GEN_PASS_MSG_MIN_CRIT_B = BUNDLE.getString("gen.pass.gui.msg.minim.crit.body");
    
    /** The Constant S_GUI_GEN_PASS_MSG_MIN_CRIT_H. */
    public static final String S_GUI_GEN_PASS_MSG_MIN_CRIT_H = BUNDLE.getString("gen.pass.gui.msg.minim.crit.header");
    
    /** The Constant S_GUI_GEN_PASS_MSG_CANT_GEN_B. */
    public static final String S_GUI_GEN_PASS_MSG_CANT_GEN_B = BUNDLE.getString("gen.pass.gui.msg.cant.generate.body");
    
    /** The Constant S_GUI_GEN_PASS_MSG_CANT_GEN_H. */
    public static final String S_GUI_GEN_PASS_MSG_CANT_GEN_H = BUNDLE
	    .getString("gen.pass.gui.msg.cant.generate.header");

    /** The Constant S_GUI_NEW_DB_TITLE. */
    public static final String S_GUI_NEW_DB_TITLE = BUNDLE.getString("new.database.gui.title");
    
    /** The Constant S_GUI_NEW_DB_PATH. */
    public static final String S_GUI_NEW_DB_PATH = BUNDLE.getString("new.database.gui.db.path");
    
    /** The Constant S_GUI_NEW_DB_PASS. */
    public static final String S_GUI_NEW_DB_PASS = BUNDLE.getString("new.database.gui.db.pass");
    
    /** The Constant S_GUI_NEW_BUT_BROWSE. */
    public static final String S_GUI_NEW_BUT_BROWSE = BUNDLE.getString("new.database.gui.but.browse");
    
    /** The Constant S_GUI_NEW_BUT_CREATE. */
    public static final String S_GUI_NEW_BUT_CREATE = BUNDLE.getString("new.database.gui.but.create");
    
    /** The Constant S_GUI_NEW_MSG_DB_CREATED_B. */
    public static final String S_GUI_NEW_MSG_DB_CREATED_B = BUNDLE.getString("new.database.gui.msg.db.created.body");
    
    /** The Constant S_GUI_NEW_MSG_DB_CREATED_H. */
    public static final String S_GUI_NEW_MSG_DB_CREATED_H = BUNDLE.getString("new.database.gui.msg.db.created.header");
    
    /** The Constant S_GUI_NEW_MSG_DB_NOT_CREATED_B. */
    public static final String S_GUI_NEW_MSG_DB_NOT_CREATED_B = BUNDLE
	    .getString("new.database.gui.msg.db.not.created.body");
    
    /** The Constant S_GUI_NEW_MSG_DB_NOT_CREATED_H. */
    public static final String S_GUI_NEW_MSG_DB_NOT_CREATED_H = BUNDLE
	    .getString("new.database.gui.msg.db.not.created.header");
    
    /** The Constant S_GUI_NEW_MSG_COMPLETE_REQ_B. */
    public static final String S_GUI_NEW_MSG_COMPLETE_REQ_B = BUNDLE
	    .getString("new.database.gui.msg.complete.req.body");
    
    /** The Constant S_GUI_NEW_MSG_COMPLETE_REQ_H. */
    public static final String S_GUI_NEW_MSG_COMPLETE_REQ_H = BUNDLE
	    .getString("new.database.gui.msg.complete.req.header");

    /** The Constant S_GUI_PASS_TITLE. */
    public static final String S_GUI_PASS_TITLE = BUNDLE.getString("password.gui.title");
    
    /** The Constant S_GUI_PASS_LABEL_PASS. */
    public static final String S_GUI_PASS_LABEL_PASS = BUNDLE.getString("password.gui.label.pass");
    
    /** The Constant S_GUI_PASS_BUT_VALIDATE. */
    public static final String S_GUI_PASS_BUT_VALIDATE = BUNDLE.getString("password.gui.but.validate");
    
    /** The Constant S_GUI_PASS_LABEL_CONECTED_TO. */
    public static final String S_GUI_PASS_LABEL_CONECTED_TO = BUNDLE.getString("password.gui.label.conected.to");
    
    /** The Constant S_GUI_PASS_MSG_PASS_NO_MATCH_B. */
    public static final String S_GUI_PASS_MSG_PASS_NO_MATCH_B = BUNDLE.getString("password.gui.msg.pass.no.match.body");
    
    /** The Constant S_GUI_PASS_MSG_PASS_NO_MATCH_H. */
    public static final String S_GUI_PASS_MSG_PASS_NO_MATCH_H = BUNDLE
	    .getString("password.gui.msg.pass.no.match.header");
    
    /** The Constant S_GUI_PASS_MSG_COMPLETE_FIELD_B. */
    public static final String S_GUI_PASS_MSG_COMPLETE_FIELD_B = BUNDLE
	    .getString("password.gui.msg.complete.field.body");
    
    /** The Constant S_GUI_PASS_MSG_COMPLETE_FIELD_H. */
    public static final String S_GUI_PASS_MSG_COMPLETE_FIELD_H = BUNDLE
	    .getString("password.gui.msg.complete.field.header");

    /** The Constant S_MENU_POPUP_BUT_DELETE. */
    public static final String S_MENU_POPUP_BUT_DELETE = BUNDLE.getString("menu.popup.but.delete");
    
    /** The Constant S_MENU_POPUP_MSG_CONFIRM_DELETE_B. */
    public static final String S_MENU_POPUP_MSG_CONFIRM_DELETE_B = BUNDLE
	    .getString("menu.popup.msg.confirm.delete.body");
    
    /** The Constant S_MENU_POPUP_MSG_CONFIRM_DELETE_H. */
    public static final String S_MENU_POPUP_MSG_CONFIRM_DELETE_H = BUNDLE
	    .getString("menu.popup.msg.confirm.delete.header");
    
    /** The Constant S_MENU_POPUP_MSG_DELETED_SUCCESS_B. */
    public static final String S_MENU_POPUP_MSG_DELETED_SUCCESS_B = BUNDLE
	    .getString("menu.popup.msg.deleted.success.body");
    
    /** The Constant S_MENU_POPUP_MSG_DELETED_SUCCESS_H. */
    public static final String S_MENU_POPUP_MSG_DELETED_SUCCESS_H = BUNDLE
	    .getString("menu.popup.msg.deleted.success.header");
    
    /** The Constant S_MENU_POPUP_MSG_DELETE_ERROR_B. */
    public static final String S_MENU_POPUP_MSG_DELETE_ERROR_B = BUNDLE.getString("menu.popup.msg.delete.error.body");
    
    /** The Constant S_MENU_POPUP_MSG_DELETE_ERROR_H. */
    public static final String S_MENU_POPUP_MSG_DELETE_ERROR_H = BUNDLE.getString("menu.popup.msg.delete.error.header");
    
    /** The Constant S_MENU_POPUP_MSG_SELECT_ROW_B. */
    public static final String S_MENU_POPUP_MSG_SELECT_ROW_B = BUNDLE.getString("menu.popup.msg.select.row.body");
    
    /** The Constant S_MENU_POPUP_MSG_SELECT_ROW_H. */
    public static final String S_MENU_POPUP_MSG_SELECT_ROW_H = BUNDLE.getString("menu.popup.msg.select.row.header");
    
    /** The Constant S_MENU_POPUP_BUT_ACCESS_URL. */
    public static final String S_MENU_POPUP_BUT_ACCESS_URL = BUNDLE.getString("menu.popup.but.access.url");
    
    /** The Constant S_MENU_POPUP_BUT_COPY_USERNAME. */
    public static final String S_MENU_POPUP_BUT_COPY_USERNAME = BUNDLE.getString("menu.popup.but.copy.username");
    
    /** The Constant S_MENU_POPUP_BUT_COPY_PASSWORD. */
    public static final String S_MENU_POPUP_BUT_COPY_PASSWORD = BUNDLE.getString("menu.popup.but.copy.password");
    
    /** The Constant S_MENU_POPUP_BUT_COPY_CELL. */
    public static final String S_MENU_POPUP_BUT_COPY_CELL = BUNDLE.getString("menu.popup.but.copy.cell");
    
    /** The Constant S_MENU_POPUP_BUT_SEND_EMAIL. */
    public static final String S_MENU_POPUP_BUT_SEND_EMAIL = BUNDLE.getString("menu.popup.but.send.email");
    
    /** The Constant S_SISTEM_TRAY_EXIT. */
    public static final String S_SISTEM_TRAY_EXIT = BUNDLE.getString("sistem.tray.exit");
    
    /** The Constant S_SISTEM_TRAY_MOVED. */
    public static final String S_SISTEM_TRAY_MOVED = BUNDLE.getString("sistem.tray.moved");
    
    /** The Constant S_SISTEM_TRAY_RESTORE_H. */
    public static final String S_SISTEM_TRAY_RESTORE_H = BUNDLE.getString("sistem.tray.restore.header");
    
    /** The Constant S_SISTEM_TRAY_RESTORE_B. */
    public static final String S_SISTEM_TRAY_RESTORE_B = BUNDLE.getString("sistem.tray.restore.body");

    /** The Constant S_SISTEM_RUNTIME_CHECK_JAVA. */
    public static final String S_SISTEM_RUNTIME_CHECK_JAVA = BUNDLE.getString("runtime.check.java");
    
    /** The Constant S_SISTEM_RUNTIME_INSTALL_JAVA_B. */
    public static final String S_SISTEM_RUNTIME_INSTALL_JAVA_B = BUNDLE.getString("runtime.check.java.install.body");
    
    /** The Constant S_SISTEM_RUNTIME_INSTALL_JAVA_H. */
    public static final String S_SISTEM_RUNTIME_INSTALL_JAVA_H = BUNDLE.getString("runtime.check.java.install.header");

    /** The Constant S_SISTEM_EXCEL_EXPORT_TITLE. */
    public static final String S_SISTEM_EXCEL_EXPORT_TITLE = BUNDLE.getString("excel.export.sheet.title");

    /** The Constant S_SEND_EMAIL_SUCCESS. */
    public static final String S_SEND_EMAIL_SUCCESS = BUNDLE.getString("send.email.success");
    
    /** The Constant S_SEND_EMAIL_MSG_ERROR_B. */
    public static final String S_SEND_EMAIL_MSG_ERROR_B = BUNDLE.getString("send.email.msg.error.body");
    
    /** The Constant S_SEND_EMAIL_MSG_ERROR_H. */
    public static final String S_SEND_EMAIL_MSG_ERROR_H = BUNDLE.getString("send.email.msg.error.header");

}
