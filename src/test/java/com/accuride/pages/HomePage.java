package com.accuride.pages;

import org.openqa.selenium.WebDriver;

import com.accuride.comanPages.BrowserFactory;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	public boolean checkPageTitle() 
	{
		BrowserFactory.checkPopupWindow();
		String expectedTitle = "Global Manufacturer of Premium Ball-Bearing Drawer Slides | Accuride International";
		//Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("TEST RESULT(HomePage): Getting the page title is = "+actualTitle+", So expected title and actual Title is SAME");			
			return true;
		}
		else
		{
			System.out.println("TEST RESULT(HomePage): Getting the page title is = "+actualTitle+", So expected title and actual title is NOT SAME");
			return false;
		}		
		
		
	}

}
