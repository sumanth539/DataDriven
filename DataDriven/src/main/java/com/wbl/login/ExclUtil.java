package com.wbl.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExclUtil extends Inistilization {

	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static int rowNumber;
	public static int columnNumber;
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}
	public static int getRowNumber() {
		return rowNumber;
	}
	public static void setColumnNumber(int pColumnNumber) {
		columnNumber = pColumnNumber;
	}
	public static int getColumnNumber() {
		return columnNumber;
	}
	public static void setExcelFileSheet(String sheetName) throws IOException {
		File src = new File("C:\\Users\\kanpuri\\testData.xls");
		FileInputStream fil = new FileInputStream(src);
		excelWBook = new XSSFWorkbook(fil);
		excelWSheet = excelWBook.getSheet("sheet1");
	}
	public static String getCellData() {
		try {
			cell = excelWSheet.getRow(1).getCell(0);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}
	public static XSSFRow getRowData(int RowNum) {
		try {
			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}

}
