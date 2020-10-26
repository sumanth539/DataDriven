package com.wbl.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class page extends Inistilization {
	public static WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void ReadData() throws IOException, Exception {
		File src = new File("C:\\Users\\kanpuri\\testData.xls");
		FileInputStream fil = new FileInputStream(src);
		workbook = new XSSFWorkbook(fil);
		sheet = workbook.getSheet("Sheet1");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			cell = sheet.getRow(i).getCell(0);
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys(cell.getStringCellValue());
			driver.findElement(By.xpath("//button[@class='btn btn-primary mb-5 float-right mr-5 mt-2']")).click();
			FileOutputStream f = new FileOutputStream(src);
			String message = "Pass";
			sheet.getRow(i).createCell(2).setCellValue(message);
			workbook.write(f);
			f.close();

		}
	}

}
