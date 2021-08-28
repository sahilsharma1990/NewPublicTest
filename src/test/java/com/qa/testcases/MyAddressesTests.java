package com.qa.testcases;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.commons.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAddressPage;
import com.qa.pages.MyAddressesPage;
import com.qa.utils.ReadDataFromExcel;

public class MyAddressesTests extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	MyAddressesPage myaddressespage;
	MyAddressPage myaddresspage;
	String sheetname="Address";
	public MyAddressesTests() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		myaddressespage=homepage.clickOnMyAddressesLink();		
	}
	@DataProvider
	public Object [][] getMySheetData() throws EncryptedDocumentException, InvalidFormatException {
		Object [][] data=ReadDataFromExcel.getSheetData(sheetname);
		return data;
	}
	
	@Test(dataProvider="getMySheetData")
	public void addNewAddressTest(String fname,String lname,String city,String state,String phone,String zipcode,String address)  {
		myaddresspage=myaddressespage.clickOnAddAnAddressLink();
		myaddresspage.addNewAddress(fname, lname, city, state, phone, zipcode, address);
		
	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
