package com.qa.testcases;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.commons.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTests extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();			
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest() {		
		String title=loginpage.validateTitle();
		Assert.assertEquals(title, "My Store");
		
	}
	@Test(priority=2)
	public void verifyPageLogoTest() {		
		boolean b=loginpage.validateLoginPageLogo();
		Assert.assertTrue(b);
		
	}
	@Test(priority=3)
	public void loginTest() {		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
