package com.accuride.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDialog {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public CartDialog(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cartIcon;
	
	@FindBy(xpath= "//div[@id='ui-id-1']")
	WebElement cartpopup;
	
	@FindBy(xpath="//span[contains(text(),'View and Edit Cart')]")
	WebElement viewAndEditCartLink;
	
	String expectedCartPageURL = "https://stage.accuride.com/checkout/cart/";
	
	
	public boolean verifyTheCartDialog() throws InterruptedException
	{
		cartIcon.click();
		Thread.sleep(3000);
		if(cartpopup.isDisplayed())
		{
			Thread.sleep(2000);
			viewAndEditCartLink.click();
			Thread.sleep(2000);
			String actualCartPageURL = driver.getCurrentUrl();
			if(actualCartPageURL.equalsIgnoreCase(expectedCartPageURL))
			{
				System.out.println("TEST RESULT(CartDialog): Correct page is appearing and it's URL is -> "+actualCartPageURL);
				return true;
			}
			else
			{
				System.out.println("TEST RESULT(CartDialog): Wrong page is appearing and it's URL is -> "+actualCartPageURL);
				return false;
			}
			
		}
		else
		{
			System.out.println("TEST RESULT(CartDialog): Cart dialog box is not opening");
			return false;
		}
		
		
	}
	
	
	
	

}
