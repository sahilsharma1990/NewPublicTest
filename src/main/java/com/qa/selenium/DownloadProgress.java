package com.qa.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DownloadProgress {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
		
		driver.findElement(By.id("downloadButton")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='ui-id-1']")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='dialog']/div[@class='progress-label']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@type='button']")).getText());
		//driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@type='button']")).click();
		//FluentWait wait=new FluentWait(driver);
	//	wait.withTimeout(Duration.ofSeconds(60));
		boolean t=true;
		while (t) {
			WebElement element = driver
					.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@type='button']"));
			//System.out.println(element.getText());
			System.out.println(driver.findElement(By.xpath("//div[@class='progress-label']")).getText());
			/*FluentWait wait=new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofSeconds(5));
			wait.ignoring(StaleElementReferenceException.class); */
			
			///System.out.println(" in while");
			Thread.sleep(1000);
			if (element.getText().equals("Close")) {
				System.out.println(element.getText());
				t = false;
				break;
			}
			//wait.until(ExpectedConditions.textToBePresentInElementValue(element, "Close"));
		}
		System.out.println("Execution Finished");
		driver.quit();

	}

}
