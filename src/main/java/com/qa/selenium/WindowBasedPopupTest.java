package com.qa.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowBasedPopupTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s5sharma\\Downloads\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		//First Testcase Twitter 
		driver.findElement(
				By.xpath("//a[@class='btn btn-primary followeasy' and @title='Follow @seleniumeasy on Twitter']"))
				.click();

		// Actions a=new Actions(driver);
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String popupWin = null;

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			//System.out.println(" In while");
			popupWin = itr.next();
			 System.out.println(popupWin);
			// Thread.sleep(2000);
			driver.switchTo().window(popupWin).manage().window().maximize();
			String t = driver.switchTo().window(popupWin).getTitle();
			System.out.println(" If T value: "+t);
			Thread.sleep(2000);
			if (t.equals("Selenium Easy (@seleniumeasy) / Twitter")) {
				System.out.println(popupWin);
				Set<String> inner = driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				String iP=null;
				
				String set=driver.findElement(By.xpath("//div[@class='css-901oao r-14j79pv r-37j5jr r-a023e6 r-16dba41 r-rjixqe r-bcqeeo r-ttdzmv r-qvutc0']/*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']")).getText();
				System.out.println(" Set value: "+set);
				
				System.out.println(driver.findElement(By.xpath("//*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0' and contains(text(),'No, thanks')]")).getText());
				driver.findElement(By.xpath("//*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0' and contains(text(),'No, thanks')]")).click();
				Thread.sleep(3000);
			}

		}

		System.out.println(" Execution Finished First ");
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.switchTo().window(parentWindow).getTitle());
		
		//Second Testcase Facebook 
		driver.findElement(By.xpath("//*[@class='btn btn-primary followeasy' and @title='Follow @seleniumeasy on Facebook']")).click();
		
		Set<String> fwin = driver.getWindowHandles();
		String fP=null;
		Iterator<String> it = fwin.iterator();
		
		while(it.hasNext()) {
			fP=it.next();
			driver.switchTo().window(fP).manage().window().maximize();
			Thread.sleep(2000);
			String Ftitle=driver.switchTo().window(fP).getTitle();
			System.out.println(Ftitle);
			if(Ftitle.equals("Selenium Easy - à¤¹à¥‹à¤® à¤ªà¥‡à¤œ | Facebook"))
			{
			 driver.findElement(By.xpath("//div[@class='_4qb-']/a[@class='_42ft _4jy0 _3obb _4jy6 _4jy1 selected _51sy']")).click();
			}
		
		}
		System.out.println(" Execution Finished Second ");
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.switchTo().window(parentWindow).getTitle());
		
		//Third Testcase both Twitter and Facebook
		System.out.println("Third Testcase both Twitter and Facebook");
		driver.findElement(By.xpath("//*[@class='btn btn-primary ']")).click();
		Set<String> doubleP = driver.getWindowHandles();
		Iterator<String> itd = doubleP.iterator();
		String handler=null;
		System.out.println(" Before While");
		while(itd.hasNext()) {
			handler=itd.next();
			System.out.println(handler);
			driver.switchTo().window(handler).manage().window().maximize();
			String winName=driver.switchTo().window(handler).getTitle();
			System.out.println(winName);
			
			if(winName.equals("Selenium Easy - à¤¹à¥‹à¤® à¤ªà¥‡à¤œ | Facebook"))
			{
			 driver.findElement(By.xpath("//div[@class='_4qb-']/a[@class='_42ft _4jy0 _3obb _4jy6 _4jy1 selected _51sy']")).click();
			}
			if (winName.equals("Selenium Easy (@seleniumeasy) / Twitter")) {		
				
				
				String set=driver.findElement(By.xpath("//div[@class='css-901oao r-14j79pv r-37j5jr r-a023e6 r-16dba41 r-rjixqe r-bcqeeo r-ttdzmv r-qvutc0']/*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']")).getText();
				System.out.println(" Set value: "+set);
				
				System.out.println(driver.findElement(By.xpath("//*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0' and contains(text(),'No, thanks')]")).getText());
				driver.findElement(By.xpath("//*[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0' and contains(text(),'No, thanks')]")).click();
				Thread.sleep(3000);
			}
			driver.close();
			
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.switchTo().window(parentWindow).getTitle());
	
	}

}

