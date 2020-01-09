package com.accuride.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuride.comanPages.BrowserFactory;

public class ShoppingAddressPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public ShoppingAddressPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@class='control _with-tooltip']//input[@id='customer-email']")
	WebElement customerEmail;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="street[0]")
	WebElement street;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="region_id")
	WebElement state;
	
	@FindBy(xpath="//div[@class='shipping-address-item selected-item']")
	WebElement addressPopup;
	
	@FindBy(xpath="//div[@class='field required']//span[contains(text(),'Email Address')]")
	WebElement emailAddressText;

	@FindBy(xpath="//div[contains(text(),'Shipping Methods')]")
	WebElement shippingMethod;
	
	@FindBy(how=How.XPATH,using ="//input[starts-with(@name,'ko_unique')]")
	WebElement homeDeliveryradiobutton;
	
	@FindBy(how=How.XPATH,using ="//input[@value='shqfedex_FEDEX_EXPRESS_SAVER']")
	WebElement expressSaverradioButton;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath= "//div[@class='panel header']//a[contains(text(),'Login / Sign Up')]")
	WebElement loginSignUp;
	
	String selectShippingMethod = "Express Saver";
	
	
	public boolean shoppingAddressPageTitle() throws InterruptedException
	{
		Thread.sleep(8000);
		BrowserFactory.checkPopupWindow();
		String expectedshoppingAddressPageTitle = "Checkout";
		String actualShoppingAddresspageTitle = driver.getTitle();
		if(expectedshoppingAddressPageTitle.equalsIgnoreCase(actualShoppingAddresspageTitle))
		{
			System.out.println("TEST RESULT(ShoppingAddressPage): Correct shopping address page title is appearing : "+actualShoppingAddresspageTitle);
			return true;
		}
		else
		{
			System.out.println("TEST RESULT(ShoppingAddressPage): Wrong shopping address page title is appearing : "+actualShoppingAddresspageTitle);
			return false;
		}
		
		
	}
	
	public void checkedUserLoggedInOrNot() throws InterruptedException
	{
		wait=new WebDriverWait(driver, 20);
		BrowserFactory.checkPopupWindow();
		wait=new WebDriverWait(driver, 20);
		try
		{
			if(customerEmail.isDisplayed())
			{
				    System.out.println("TEST RESULT(ShoppingAddressPage): The Testcase is FAIL because User is not logged into the application.");
					
			}
		}
		catch (Exception e)
			{
			System.out.println("TEST RESULT(ShoppingAddressPage): The Testcase is PASS because User is logged into the application.");
			}
		
	}
	
	
	public void checkedUserIsNotLoggedIn() throws InterruptedException
	{
		wait=new WebDriverWait(driver, 20);
		BrowserFactory.checkPopupWindow();
		wait=new WebDriverWait(driver, 20);
		try
		{
			if(customerEmail.isDisplayed())
			{
				    System.out.println("TEST RESULT(ShoppingAddressPage): The Testcase is PASS because User is not logged into the application.");
					
			}
		}
		catch (Exception e)
			{
			System.out.println("TEST RESULT(ShoppingAddressPage): The Testcase is FAIL because User is logged into the application.");
			}
		
	}
	
	public void signInToTheUser() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(2000);
		System.out.println("TEST RESULT(ShoppingAddressPage): Scrolled the page");
		Thread.sleep(3000);
		//loginSignUp.click();
		
		LogIn loginInToApp = new LogIn(driver);
		loginInToApp.validLogin();
		
		Thread.sleep(2000);
		System.out.println("TEST RESULT(ShoppingAddressPage): Successfully logged into the application");
		Thread.sleep(2000);
		BrowserFactory.checkPopupWindow();
	}
	
	public void goToThePaymentPage() throws InterruptedException
	{
		Thread.sleep(2000);
		BrowserFactory.checkPopupWindow();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", shippingMethod);
		Thread.sleep(2000);
		
		List<WebElement>radioButton = driver.findElements(By.xpath("//table[@class='table-checkout-shipping-method']//tbody"));
		System.out.println("TEST RESULT(ShoppingAddressPage): The size of the radio button is : "+radioButton.size());
		String listOfShippingMethod = driver.findElement(By.xpath("//table[@class='table-checkout-shipping-method']//tbody")).getText();
		//System.out.println("TEST RESULT(ShoppingAddressPage): List of the Shipping Method is : "+listOfShippingMethod);
		
		if(listOfShippingMethod.contains(selectShippingMethod))
		{
			if(selectShippingMethod.equalsIgnoreCase("Home Delivery"))
			{
				homeDeliveryradiobutton.click();
				System.out.println("TEST RESULT(ShoppingAddressPage): 'Home Delivery' radio button is selected as expected");
				nextButton.click();
			}
			else if(selectShippingMethod.equalsIgnoreCase("Express Saver"))
			{
				expressSaverradioButton.click();
				System.out.println("TEST RESULT(ShoppingAddressPage): 'Express Saver' radio button is selected as expected");
				nextButton.click();
			}
		}
		else
		{
			System.out.println("TEST RESULT(ShoppingAddressPage): Expected shipping method is not in listed.");
		}
		
		

	}
	
		
	
	public void enterTheDetails() throws InterruptedException
	{
		customerEmail.sendKeys("test01@mailinator.com");
		Thread.sleep(5000);
		firstName.sendKeys("Tester");
		lastName.sendKeys("One");
		street.sendKeys("Demo street road");
		city.sendKeys("Demo City");
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText("California");
	}
	
	
	
	

	

}
