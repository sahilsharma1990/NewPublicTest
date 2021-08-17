package com.qa.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	Properties prop = new Properties();
	String propFilePath = "D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Environment.properties";

	public TestBase() {

		try {
			FileInputStream fp = new FileInputStream(propFilePath);
			prop.load(fp);
			System.out.println(prop.getProperty("username"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void intilization() {
		String url=prop.getProperty("url");
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdrivr.gecko.driver","C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
			driver =new FirefoxDriver();
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("IE")) {
			
		}else 
			System.out.println(" Error : Sutiable browser is not found");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	public static void main(String[] args) {
		TestBase t = new TestBase();
		t.intilization();
		System.out.println("Object Created");
	}

}
