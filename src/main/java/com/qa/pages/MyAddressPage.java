package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.commons.TestBase;

public class MyAddressPage extends TestBase{
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="city")
	WebElement cityv;
	
	@FindBy(id="id_state")
	WebElement stateV;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="phone")
	WebElement homephone;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;
	
	@FindBy(id="submitAddress")
	WebElement save;
	
	public MyAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MyAddressesPage addNewAddress(String fn,String ln,String city,String state,String phone,String zipcode,String address) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		cityv.sendKeys(city);		
		postcode.sendKeys(zipcode);
		homephone.sendKeys(phone);
		address1.sendKeys(address);
		Select s=new Select(stateV);
		s.selectByVisibleText(state);
		save.click();
		return new MyAddressesPage();
	}

}
