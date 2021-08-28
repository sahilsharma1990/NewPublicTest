package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.commons.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup // Will store this element to the cache memory
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signin;
	
	@FindBy(xpath="//*[@class='logo img-responsive']")
	WebElement pageLogo;
	
	@FindBy(xpath="//*[@class='login']")
	WebElement signinLink;
	
	// Initialization of Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLogo() {
		return pageLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		signinLink.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
	}
	

}
