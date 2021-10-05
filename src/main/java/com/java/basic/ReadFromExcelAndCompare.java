package com.java.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromExcelAndCompare {
	static WebDriver driver;
	static Workbook book;
	static Sheet sheet;

	public static void main(String[] args) {
		String sheetname = "ebay";

		FileInputStream file = null;
		String filepath = "C:/Users/s5sharma/Desktop/MyStoreTestData.xlsx";
		try {
			file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetname);

		String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		System.out.println(" List Created");

		/*
		 * for (int i = 0; i < sheet.getLastRowNum(); i++) {
		 * 
		 * for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
		 * 
		 * data[i][j] = sheet.getRow(i).getCell(j).toString(); } }
		 * 
		 * for (int i = 0; i < data.length; i++) {
		 * 
		 * for (int j = 0; j < data[0].length; j++) {
		 * 
		 * System.out.print(data[i][j] + "	"); } System.out.println(); }
		 */
		System.out.println(" Row Count :" +sheet.getLastRowNum());
		System.out.println(" Column Count :" +sheet.getRow(0).getLastCellNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			ArrayList<String> list = new ArrayList<String>();
			//al.add(list);
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				list.add((sheet.getRow(i).getCell(j).toString()));
			}
			al.add((ArrayList<String>) list);
		}
		System.out.println(al.size());
		for (List l1 : al) {
			System.out.println(l1);
		}
		
		System.out.println(" Data is retrived");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://community.ebay.com/");
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='has-children']/a"));
		
		for(WebElement l1:l)
			System.out.println(l1.getText());
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getText()==al.get(i).toString()) {
				System.out.println(" Matched as " +l.get(i).getText() +al.get(i).toString() );
			}else
				System.out.println(" Not found");
		}
		
		driver.quit(); 
	}

	
}
