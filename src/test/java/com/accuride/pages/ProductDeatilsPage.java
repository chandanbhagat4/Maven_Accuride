package com.accuride.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuride.comanPages.BrowserFactory;

public class ProductDeatilsPage {
	
	static WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='qty']")
	WebElement quantityOfProduct;
	
	@FindBy(xpath = "//span[@class='plus update']")
	WebElement plusIcon;
	
	@FindBy(xpath= "//button[@id='product-addtocart-button']")
	WebElement addToCartButton;
	
	public ProductDeatilsPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	String intialProductQuantity = "1";
	String enterTheProductQuantity = "1";
	String addedProductName = SearchField.expectedProductIsInSmallLatter;
	String genratedXpath = addedProductName.substring(0, 40);
	
	
	
	public boolean checkTheInitialProductQuantity () throws InterruptedException
	{
		BrowserFactory.checkPopupWindow();
		String checkInputQuantity = driver.findElement(By.xpath("//input[@id='qty']")).getAttribute("value");
		System.out.println("TEST RESULT(ProductDeatilsPage): Input product quantity is - "+checkInputQuantity);
		Thread.sleep(2000);
		if(checkInputQuantity.equalsIgnoreCase(intialProductQuantity))
		{
			System.out.println("TEST RESULT(ProductDeatilsPage): Intial product quantity is - "+intialProductQuantity+" and showing product quantity is - "+checkInputQuantity+" So both are SAME.");
			return true;
		}
		else
		{
			System.out.println("TEST RESULT(ProductDeatilsPage): Intial product quantity is 1. It is showing as "+checkInputQuantity);
			return false;
		}
		
	}
	
	public static String checkTheEnteredProductQuantity()
	{
		String enteredProductQuantity = driver.findElement(By.xpath("//input[@id='qty']")).getAttribute("value");
		//return true;
		return enteredProductQuantity;
	}
	
	
	public boolean increaseTheProductCountViaPlusIcon() throws InterruptedException
	{
		BrowserFactory.checkPopupWindow();
		Thread.sleep(3000);
		String pageurl = driver.getCurrentUrl();
		System.out.println("TEST RESULT(ProductDeatilsPage): The current product page url is -> "+pageurl);
		plusIcon.click();
//		String updatedProductQuanatitybyPlusIcon = ProductDeatilsPage.checkTheEnteredProductQuantity();
//	    System.out.println("The updated quantity is now - "+updatedProductQuanatitybyPlusIcon);
	    System.out.println("TEST RESULT(ProductDeatilsPage): The updated quantity is now2 -> "+checkTheEnteredProductQuantity());
		Thread.sleep(3000);
		return true;
	}
	
	public boolean increaseTheProductCountViaInputField() throws InterruptedException
	{
//		driver.findElement(By.xpath("//input[@id='qty']")).click();
//		driver.findElement(By.xpath("//input[@id='qty']")).clear();
//		driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(enterTheProductQuantity);
		
		quantityOfProduct.click();
		quantityOfProduct.clear();
		quantityOfProduct.sendKeys(enterTheProductQuantity);
		
		Thread.sleep(2000);
		System.out.println("TEST RESULT(ProductDeatilsPage): The updated quantity via entred by direct text box is -> "+checkTheEnteredProductQuantity());
		return true;
	}
	
	public boolean addToCart() throws InterruptedException
	{
		addToCartButton.click();
		Thread.sleep(3000);
		String expectedMessageIs = "You added "+addedProductName+" to your shopping cart.";
		String actualMessageIs = driver.findElement(By.xpath("//div[contains(text(),'You added "+genratedXpath+"')]")).getText();
		                                                      
		
		if(expectedMessageIs.equalsIgnoreCase(actualMessageIs))
		{
			System.out.println("TEST RESULT(ProductDeatilsPage): Correct product is added");
			return true;
		}
		else
		{
			System.out.println("TEST RESULT(ProductDeatilsPage): Wrong product is added");
			return false;
			
		}
				
	}

}
