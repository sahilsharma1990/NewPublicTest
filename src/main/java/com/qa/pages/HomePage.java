package com.qa.pages;

import static com.qa.commons.TestBase.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.commons.TestBase;

public class HomePage extends TestBase{

	//Page Factory OR
	@FindBy(xpath="//h1[contains(@class,'page-heading')]")
	WebElement homepagelogo;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement cartlink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public boolean verifyHomePageLogo() {
		return homepagelogo.isDisplayed();
	}
	public CartPage clickCartLink() {
		cartlink.click();
		return new CartPage();
	}
	
}
