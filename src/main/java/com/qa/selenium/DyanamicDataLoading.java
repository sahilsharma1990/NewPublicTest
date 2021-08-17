package com.qa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicDataLoading {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		
		driver.findElement(By.id("save")).click();
		Thread.sleep(3000);
		for(int i=1;i<3;i++) {
		WebElement e=driver.findElement(By.xpath("//div[@id='loading']"));
		String lines[] = e.getText().split("Name :\\b");  //split("\\r?\\n");
		for(String line: lines) {
		    System.out.println(line);
		}
		
		
	}
		System.out.println("Completed");
		driver.quit();

}
}