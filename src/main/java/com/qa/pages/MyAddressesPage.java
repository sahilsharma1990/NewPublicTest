package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.commons.TestBase;

public class MyAddressesPage extends TestBase{

	@FindBy(xpath="//*[@title='Add an address']")
	WebElement addAddressLink;
	
	
	public MyAddressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MyAddressPage clickOnAddAnAddressLink() {
		addAddressLink.click();
		return new MyAddressPage();
	}
	
	
}
