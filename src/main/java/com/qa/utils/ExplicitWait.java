package com.qa.utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qa.commons.TestBase;

public class ExplicitWait extends TestBase {
	 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(40, TimeUnit.SECONDS)
			.pollingEvery(10, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);

	public void waitForVisibilityOfELement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public void waitForTestPresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}
	public void waitForElemenToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}