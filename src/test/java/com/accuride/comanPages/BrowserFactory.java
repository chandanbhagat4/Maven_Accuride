package com.accuride.comanPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {


	static WebDriver driver;
	static WebDriverWait wait;
	
	public static WebDriver browserLunch(String browserName, String url) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/firefox.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./driver/iexplore.exe");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		//Thread.sleep(2000);
		return driver;
	}
	
	public static WebDriver closeBrowser()
	{
		driver.close();
		return driver;
		
	}
	
	
	public static void checkPopupWindow()
	{
		wait = new WebDriverWait(driver,20);
		try
		{
			if(driver.findElement(By.id("cookieconsent:desc")).isDisplayed())
			{
				driver.findElement(By.className("cc-dismiss")).click();
			}
		}
		catch (Exception e)
		{
			System.out.println("TEST RESULT: NoSuchElement Exception");
		}
	}
	

}
