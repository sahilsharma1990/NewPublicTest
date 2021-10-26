package com.qa.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	static WebDriver driver;
	static Properties prop;
	String filepath = "D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Environment.properties";

	Practice() {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void setup() {
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.geekco.driver", "C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\geckodriver.exe");
			driver=new ChromeDriver();
		}
		else 
			System.out.println("Specified Broswer is not found");
		String url=prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		
		Practice p=new Practice();
		p.setup();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//input[@name='email']
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Test");
		
	}

}
