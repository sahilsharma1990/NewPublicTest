package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	private static final Object[][] Object = null;
	private static String TestData_FilePath = "D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\MyStoreTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getSheetData(String sheetName) throws EncryptedDocumentException, InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestData_FilePath);
			System.out.println("File Created");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
			System.out.println(" Workbook created");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		System.out.println("Sheet accessed");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getFirstRowNum());
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}

		return data;
	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException {
		/*Object[][] data1 = new Object[3][6];
		data1 = getSheetData("Address");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(data1[i][j] + "	");
			}
			System.out.println("");
		}*/

	}
}
