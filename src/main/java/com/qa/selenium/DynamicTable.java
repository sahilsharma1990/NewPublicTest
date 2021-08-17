package com.qa.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		
		driver.findElement(By.xpath("//*[@id='task-table-filter']")).sendKeys("wire");
		Thread.sleep(2000);

		// *[@id='task-table']/tbody/tr[@style='display: table-row;']
		// *[@id='task-table']/tbody/tr[@style='display:
		// table-row;']/td[1]/following-sibling::td
		// for all the list Xpath is : //*[@id='task-table']/tbody/tr/td
		// for Filtered result Xpath is : //*[@id='task-table']/tbody/tr[@style='display: table-row;']/td
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='task-table']/tbody/*[not(contains(@style,'none'))]/td"));
		System.out.println(list.size());
		/*for (WebElement e : list) {
			System.out.println(e.getText());
		}*/
		int cur = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getText() + "	");
			cur++;
			if (cur % 4 == 0 && cur!=0)
				System.out.println();
		}
		System.out.println("finished");
		driver.findElement(By.xpath("//*[@class='btn btn-default btn-xs btn-filter']")).click();
		
		driver.findElement(By.xpath("//*[@class='form-control' and  @placeholder='Username']")).sendKeys("chris");
		List<WebElement> l1=driver.findElements(By.xpath("//*[@class='table']/tbody/*[not(contains(@style,'none'))]/td"));
		int cur1 = 0;
		for (int i = 0; i < l1.size(); i++) {
			System.out.print(l1.get(i).getText() + "	");
			cur1++;
			if (cur1 % 4 == 0 && cur!=0)
				System.out.println();
		}
	}

}
