package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.commons.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAddressesPage;

import junit.framework.Assert;

public class HomePageTests extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	MyAddressesPage myaddresses;

	public HomePageTests() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageLogoTest() {
		boolean b=homepage.validateHomePageLogo();
		Assert.assertTrue(b);
	}
	@Test(priority=2)
	public void verifyHomePageTitileTest() {
		String title=homepage.validateHomePageTitle();
		Assert.assertEquals("Homepage Title not Matched", "My account - My Store", title);
	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
