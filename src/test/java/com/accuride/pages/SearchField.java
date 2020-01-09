package com.accuride.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchField {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//input[@id='search']")
	static WebElement searchbox;
	
	
	String inputSearchbox = "116RC";//Please enter the input for searching.
	String expectedProductIs = "CB0116-CASSRC 116RC CASSETTE WITH POLYMER BEARINGS"; //Please enter the what product should be click or select.
	static String expectedProductIsInSmallLatter = "CB0116-CASSRC 116RC Cassette with Polymer Bearings";//Please enter the product name with small latter.
	static String ecpectedProductSKU = "CB0116-CASSRC";//Please enter the SKU value of the product.
	String expectedProductPageTitle = "Polymer Bearing Cassette|116RC Accessory|Accuride International";//Please enter the product detail page title.
	String expectedProductDetailsPageUrl = "https://stage.accuride.com/cb0116-cassette-with-polymer-bearings";//Please enter the product detail page url.
	                                        
	
//	String inputSearchbox = "116RC";
//	String expectedProductIs = "SS0116-CASSRC 116RC CASSETTE WITH STAINLESS STEEL BEARINGS";
//	static String expectedProductIsInSmallLatter = "SS0116-CASSRC 116RC Cassette with Stainless Steel Bearings";
//	static String ecpectedProductSKU = "SS0116-CASSRC";
//	String expectedProductPageTitle = "Stainless Steel Bearing Cassette|116RC Accessory|Accuride";
//	String expectedProductDetailsPageUrl = "https://www.accuride.com/ss0116-cassette-with-stainless-steel-bearings";
	
//	String inputSearchbox = "116RC DAMPER";
//	String expectedProductIs = "116RC DAMPER";
//	static String expectedProductIsInSmallLatter = "116RC Damper";
//	static String ecpectedProductSKU = "CB0116-DAMP";
//	String expectedProductPageTitle = "Damper|116RC Accessory|Accuride International";
//	String expectedProductDetailsPageUrl = "https://www.accuride.com/cb0116-damp-damper";
	
	
//	String inputSearchbox = "heavy";
//	String expectedProductIs = "HEAVY-DUTY OVER-TRAVEL SLIDE WITH ADAPTER RAIL MOUNT DISCONNECT";
//	static String expectedProductIsInSmallLatter = "Heavy-Duty Over-Travel Slide with Adapter Rail Mou";
//	String expectedProductPageTitle = "3640A|Heavy-Duty Lateral File Slide|Accuride International";
//	String expectedProductDetailsPageUrl = "https://www.accuride.com/3640a-heavy-duty-over-travel-slide-with-adapter-rail-mount-disconnect";
	

	
	public SearchField(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean searchProduct() throws InterruptedException, IOException
	{
//		Properties obj = new Properties();
//		FileInputStream objFile = new FileInputStream("./application.properties");
//		obj.load(objFile);
//		String inputSearchbox = obj.getProperty("inputOnSearchbox");
		
		searchbox.click();
		searchbox.sendKeys(inputSearchbox);
		Thread.sleep(5000);
		
		String listOfItem = driver.findElement(By.xpath("//div[@id='sli_raclist_products']")).getText();
		
		//Show all the search product 
		//System.out.println(listOfItem);
		
		Thread.sleep(5000);
		
//		String expectedProductIs = "CB0116-CASSRC 116RC CASSETTE WITH POLYMER BEARINGS";
//		String expectedProductIsInSmallLatter = "CB0116-CASSRC 116RC Cassette with Polymer Bearings";
		
		WebElement expectedProductClick = driver.findElement(By.xpath("//h2[contains(text(),'"+expectedProductIsInSmallLatter+"')]"));
		
//		Properties exProIs = new Properties();
//		FileInputStream exProIsFile = new FileInputStream("./application.properties");
//		exProIs.load(exProIsFile);
//		String expectedProductIs = exProIs.getProperty("expectedProductNameIs");
		
		if(listOfItem.contains(expectedProductIs))
		{
			System.out.println("TEST RESULT(SearchField): Getting the same expected product");	
			expectedProductClick.click();
			Thread.sleep(10000);
			String productSearchedPageTitle = driver.getTitle();
			System.out.println("TEST RESULT(SearchField): Getting page title is - "+productSearchedPageTitle);
			String productDetailsPageUrl = driver.getCurrentUrl();
			if(expectedProductDetailsPageUrl.equalsIgnoreCase(productDetailsPageUrl))
			{
				System.out.println("TEST RESULT(SearchField): The actual and expected url is SAME");
				return true;
			}
			else
			{
				System.out.println("TEST RESULT(SearchField): The actual and expected url is NOT SAME ");
				return false;
			}
			
		}
		else
		{
			System.out.println("TEST RESULT(SearchField): Not getting the expected product");
			return false;
		}
		
		
		
		
	}
	

}
