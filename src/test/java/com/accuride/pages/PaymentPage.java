package com.accuride.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuride.comanPages.BrowserFactory;

public class PaymentPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='checkout-agreement field choice required']//label[@class='label']")
	WebElement termsAndConditionsCheckbox;
	
	@FindBy(xpath="//span[contains(text(),'Subscribe for Newsletter')]")
	WebElement subscribeNewsLetter;
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	WebElement placedOrderButton;
	
	@FindBy(how=How.XPATH,using="//h1[@class='page-title']")
	WebElement orderConfirmationMessage;
	
	@FindBy(how=How.XPATH,using="//a[@class='order-number']")
	WebElement orderNumber;
	
	public boolean placingOrder() throws InterruptedException
	{
		
		Thread.sleep(2000);
		BrowserFactory.checkPopupWindow();
		Thread.sleep(2000);
		
//		WebElement termsAndConditionsCheckbox = driver.findElement(By.xpath("//*[name()='svg']/*[name()='circle']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsAndConditionsCheckbox);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", termsAndConditionsCheckbox);
		Thread.sleep(1000);
		
//		termsAndConditionsCheckbox.click();
		
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", subscribeNewsLetter);
		Thread.sleep(1000);
		
		placedOrderButton.click();
		Thread.sleep(10000);
		
		String expectedSuccessMessage = "Thank you for your purchase!";
		
		String actualSuccessMessage = orderConfirmationMessage.getText();
		String actualOrderNumber = orderNumber.getText();
		//String actualSucessPageTitle = driver.getTitle();
		if(actualSuccessMessage.equals(expectedSuccessMessage))
		{
			System.out.println("TEST RESULT(PaymentPage): The order number is coming as : "+ actualOrderNumber);
			System.out.println("TEST RESULT(PaymentPage): The success text message is : "+actualSuccessMessage);
			
			return true;
		}
		else 
		{
			System.out.println("TEST RESULT(PaymentPage): The page title is coming wrong and it's coming as : "+actualSuccessMessage);
			return false;
		}
		
		
	}
	
	
	

}
