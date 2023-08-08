package org.ownbit.password.manager.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.ownbit.password.manager.model.PasswordModel;
import org.ownbit.password.manager.table.CustomTableModel;
import org.ownbit.password.manager.utils.LanguageKey;

/**
 * The Class Excel.
 */
public class Excel implements LanguageKey {

    /**
     * Creates the excel.
     *
     * @param dataList the data lists
     * @param outputFile the output file
     */
    private static void createExcel(ArrayList<PasswordModel> dataList, File outputFile) {

	try {
	    CustomTableModel customTableModel = new CustomTableModel(dataList);
	    HSSFWorkbook fWorkbook = new HSSFWorkbook();
	    HSSFSheet fSheet = fWorkbook.createSheet(S_SISTEM_EXCEL_EXPORT_TITLE);
	    HSSFFont sheetTitleFont = fWorkbook.createFont();
	    sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

	    HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

	    HSSFRow fRow = null;
	    HSSFCell cell = null;
	    for (int i = 0; i < customTableModel.getRowCount(); i++) {
		fRow = fSheet.createRow(i);
		for (int j = 0; j < customTableModel.getColumnCount(); j++) {
		    cell = fRow.createCell(j);
		    cell.setCellValue(String.valueOf(customTableModel.getValueAt(i, j)));
		    cell.setCellStyle(cellStyle);
		}
	    }

	    FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
	    fWorkbook.write(fileOutputStream);
	    fileOutputStream.close();
	    fWorkbook.close();
	} catch (FileNotFoundException ex) {
	    ex.getStackTrace();
	} catch (IOException ex) {
	    ex.getStackTrace();
	}
    }

    /**
     * Generate excel file.
     *
     * @param dataList the data list
     * @param outputFile the output file
     */
    public static void generateExcelFile(ArrayList<PasswordModel> dataList, File outputFile) {
	createExcel(dataList, outputFile);
    }
}
