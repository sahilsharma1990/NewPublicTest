package com.qa.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop ;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	String propFilePath = "D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Environment.properties";

	public TestBase() {

		try {
			prop = new Properties();
			
			FileInputStream fp = new FileInputStream(propFilePath);
			prop.load(fp);
			System.out.println(prop.getProperty("username"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intilization() {
		String url = prop.getProperty("url");
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdrivr.gecko.driver",
					"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {

		} else
			System.out.println(" Error : Sutiable browser is not found");
		
		// Create Object of Event Firing WebDriver class
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		
	}
	public static void takeScreenshotOnFailure() throws IOException {
		
		/* 
		 * 1. Use the TakesScreenshot Interface reference (t) and convert that into with your WebDriver object.
		 * 2. Create the File Source reference variable that will take the returned file by calling the t.getScreenshotAs()method
		 *  Also we need get the OutputType as file using the OutputType.FILE
		 * 
		 * 3. Then create another object of File destilantion file where you want to create the file.
		 * 
		 * 4. Call the FileUtils.copyFile() method to copy the file created by getScreenshotAs() method to your destination folder.
		 * 		TakesScreenshot t= (TakesScreenshot)driver;
				File srcFile=t.getScreenshotAs(OutputType.FILE);
				File destFile=new File("D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Screenshot.png");
				FileUtils.copyFile(srcFile, destFile);
		 */
		File file1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Screenshot.png"));
		
	}

	public static void main(String[] args) {
		TestBase t = new TestBase();
		t.intilization();
		System.out.println("Object Created");
	}

}
