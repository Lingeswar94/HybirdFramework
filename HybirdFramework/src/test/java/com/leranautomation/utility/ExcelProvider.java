package com.leranautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {
	XSSFWorkbook workbook;

	public ExcelProvider() {

		File src = new File("./TestData/LoginData.xlsx");
		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileInputStream);

		} catch (Exception e) {
			System.out.println("unable to read excel file" + e.getMessage());
		}
	}

	public String getStringdata(String sheetname, int row, int column) {
		return workbook.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}

	public double getnumericaldata(String sheetname, int row, int column) {
		return workbook.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

	public void getStringdata(int sheetindex, int row, int column) {
		workbook.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
}
