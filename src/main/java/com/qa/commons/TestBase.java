package com.qa.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	private static String propFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Environment.properties";

	public TestBase() {
		FileInputStream fp=null;
		try {
			prop = new Properties();
			fp = new FileInputStream(propFilePath);
			try {
				prop.load(fp);
				//System.out.println(prop.getProperty("username"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propFilePath);
		}finally {
            try {
                if (fp != null) fp.close();
            } catch (IOException ignore) {
            }
        }
		
	}

	public static void initialization() {
		String url = prop.getProperty("url");
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			// This is manual part for setup up the driver
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
			// We can use Webdriver Manager to Launch the Chrome Driver
			WebDriverManager.chromedriver().setup();
	
			ChromeOptions coptions=new ChromeOptions();
			coptions.addArguments("--incognito");
			driver = new ChromeDriver(coptions);

		} else if (prop.getProperty("browser").equalsIgnoreCase("FF")) {
			// This is manual part for setup up the driver
			System.setProperty("webdrivr.gecko.driver","C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\geckodriver.exe");
			// We can use Webdriver Manager to Launch the Chrome Driver
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);

		} else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {

		} else
			System.out.println(" Error : Sutiable browser is not found");

		// Create Object of Event Firing WebDriver class
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);

	}

	public static void takeScreenshotOnFailure() throws IOException {

		/*
		 * 1. Use the TakesScreenshot Interface reference (t) and convert that into with
		 * your WebDriver object. 2. Create the File Source reference variable that will
		 * take the returned file by calling the t.getScreenshotAs()method Also we need
		 * get the OutputType as file using the OutputType.FILE
		 * 
		 * 3. Then create another object of File destilantion file where you want to
		 * create the file.
		 * 
		 * 4. Call the FileUtils.copyFile() method to copy the file created by
		 * getScreenshotAs() method to your destination folder. TakesScreenshot t=
		 * (TakesScreenshot)driver; File srcFile=t.getScreenshotAs(OutputType.FILE);
		 * File destFile=new File(
		 * "D:\\Workspace_Auto\\AutomationFramework\\src\\main\\resources\\Screenshot.png"
		 * ); FileUtils.copyFile(srcFile, destFile);
		 */
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(file1, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	

}
