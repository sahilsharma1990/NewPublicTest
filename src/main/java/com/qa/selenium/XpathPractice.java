package com.qa.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");

		driver.findElement(By.xpath("//span[@class='input-group-addon']/i[@class='glyphicon glyphicon-th']")).click();
		;

		Thread.sleep(3000);

		String date = "9-June 2021";
		String[] spliter = date.split("-");
		String day = spliter[0];
		String month_year = spliter[1];

		// div[@class='datepicker-days']/table/thead/tr/th[@class='datepicker-switch']

		// for all the elements dates
		// //div[@class='datepicker-days']/table[@class='table-condensed']/tbody/tr/td

		selectDate(month_year, day);

		System.out.println(" Executed");

	}

	public static void selectDate(String month_year, String day) {
		
		boolean s = true;
		while (s) {
			WebElement month_y = driver.findElement(By.xpath(
					"//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='datepicker-switch']"));
			System.out.println(month_y.getText());
			driver.findElement(By.xpath(
					"//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='prev']"))
					.click();
			if (month_y.getText().equals(month_year)) {
				System.out.println(" In If");
				List<WebElement> days = driver.findElements(
						By.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']/tbody/tr/td"));
				
				for (WebElement l : days) {
					System.out.println(l.getText());
					if (l.getText().equals(day)) {
						l.click();
						s=false;
						break;
					}
				}
				// driver.findElement(By.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='prev']")).click();
				// selectDate(month_year,day);
			}
			System.out.println("After if");
		}
	}
}
