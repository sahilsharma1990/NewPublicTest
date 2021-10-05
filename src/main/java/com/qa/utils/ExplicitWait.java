package com.qa.utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qa.commons.TestBase;

public class ExplicitWait extends TestBase {
	 static FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(40, TimeUnit.SECONDS)
			.pollingEvery(3, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);

	public static WebElement waitForVisibilityOfELement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public static WebElement waitForTextPresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		return element;

	}
	public static WebElement waitForElemenToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	public static WebElement waitForElementToBeSelected(WebElement element) {
		wait.until(ExpectedConditions.elementToBeSelected(element));
		return element;
	}
	public static String waitForTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return title;
	}
}