package com.accuride.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuride.comanPages.BrowserFactory;

public class ShoppingCartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to Checkout')]")
	WebElement proceedToCheckoutButton;
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	String expectedShoppingPageTitle = "Shopping Cart";	
	String expectedProductAddedIntoTheShoppingPage = SearchField.expectedProductIsInSmallLatter;
	String genratedXpathForAddedProductIntoTheShoppingPage1 = expectedProductAddedIntoTheShoppingPage.substring(0, 36);
	String genratedXpathForAddedProductIntoTheShoppingPage2 = expectedProductAddedIntoTheShoppingPage.substring(0, 14);
//	String finalXapthForAddedProductIntoTheShoppingPage = genratedXpathForAddedProductIntoTheShoppingPage2.concat(genratedXpathForAddedProductIntoTheShoppingPage1);
	String expectedSKUinProductPage = SearchField.ecpectedProductSKU;
//	String expectedProductAddedIntoTheShoppingPageWithSKU = expectedSKUinProductPage.concat(expectedProductAddedIntoTheShoppingPage);
	String expectedProductAddedIntoTheShoppingPageWithSKU = expectedSKUinProductPage + " " +expectedProductAddedIntoTheShoppingPage;
	String finalXpathForAddedProductIntoTheShoppingPageWithSKU = expectedSKUinProductPage + " " + genratedXpathForAddedProductIntoTheShoppingPage1;
	
	//String addedProductNameIs = "//td[@class='col item']//a[contains(text(),'CB0116-CASSRC CB0116-CASSRC 116RC Cassette with Po')]";
	                                                                           
	
	public boolean checkAddedProductInToShoppingCart() throws InterruptedException
	{
		Thread.sleep(5000);
		BrowserFactory.checkPopupWindow();
		String actualShoppingPageTitle = driver.getTitle();
		if(actualShoppingPageTitle.equalsIgnoreCase(expectedShoppingPageTitle))
		{
			System.out.println("TEST RESULT(ShoppingCartPage): Correct shopping page title is coming -> "+actualShoppingPageTitle);
			System.out.println("TEST RESULT(ShoppingCartPage): Getting xpath -> "+finalXpathForAddedProductIntoTheShoppingPageWithSKU);
			String actualProductAddedIntoTheShoppingPage = driver.findElement(By.xpath("//td[@class='col item']//a[contains(text(),'"+finalXpathForAddedProductIntoTheShoppingPageWithSKU+"')]")).getText();
			System.out.println("TEST RESULT(ShoppingCartPage): Expected product name in shopping page: "+expectedProductAddedIntoTheShoppingPage);
			System.out.println("TEST RESULT(ShoppingCartPage): Actual product name in shopping page : "+actualProductAddedIntoTheShoppingPage);
			System.out.println("TEST RESULT(ShoppingCartPage): Actaul product name in shopping page with sku : "+expectedProductAddedIntoTheShoppingPageWithSKU);
			
			if(actualProductAddedIntoTheShoppingPage.equalsIgnoreCase(expectedProductAddedIntoTheShoppingPageWithSKU))
			{
				System.out.println("TEST RESULT(ShoppingCartPage): The same product is added -> "+actualProductAddedIntoTheShoppingPage);
				return true;
			}
			else
			{
				System.out.println("TEST RESULT(ShoppingCartPage): The same product is Not added -> "+actualProductAddedIntoTheShoppingPage);
				return false;
			}
			
		}
		else
		{
			System.out.println("TEST RESULT(ShoppingCartPage): Wrong shopping page title is coming -> "+actualShoppingPageTitle);
			return false;
		}
		
	}
	
	
	public boolean proceedToCheckoutButton () throws InterruptedException
	{
		proceedToCheckoutButton.click();
		Thread.sleep(5000);
		String expectedCheckOutPageUrl = "https://stage.accuride.com/checkout/#shipping";
		String actualCheckOutPageUrl = driver.getCurrentUrl();
		
		if (expectedCheckOutPageUrl.equalsIgnoreCase(actualCheckOutPageUrl))
		{
			System.out.println("TEST RESULT(ShoppingCartPage): Correct page url is coming : "+actualCheckOutPageUrl);
			return true;
		}
		else
		{
			System.out.println("TEST RESULT(ShoppingCartPage): Wrong page url is coming : "+actualCheckOutPageUrl);
			return false;
		}
		
		
	}

}
