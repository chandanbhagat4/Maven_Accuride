package com.accuride.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public  LogIn(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(xpath= "//div[@class='panel header']//a[contains(text(),'Login / Sign Up')]")
	WebElement loginOrSignUp;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	
	@FindBy(xpath="//div[@class='field password']//input[@id='pass']")
	WebElement passwordField;
	
	@FindBy(xpath= "//span[contains(text(),'Log In')]")
	WebElement loginButton;
	
	
	public boolean validLogin() throws InterruptedException
	{
		Thread.sleep(8000);
		
		//WebElement loginSignUp = driver.findElement(By.linkText("https://stage.accuride.com/customer/account/login/referer/aHR0cHM6Ly9zdGFnZS5hY2N1cmlkZS5jb20vY2IwMTE2LWNhc3NldHRlLXdpdGgtcG9seW1lci1iZWFyaW5ncw%2C%2C/"));
		WebElement loginSignUp = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Login / Sign Up')]"));
		Thread.sleep(2000);
		loginSignUp.click();
		
		Thread.sleep(3000);
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys("chandan.bhagat@indusnet.co.in");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@class='field password']//input[@id='pass']"));
		passwordField.sendKeys("#Abcd1234");
		
		WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
		loginButton.click();
		
		Thread.sleep(4000);
		
		String expectedLoginPageTitle = "Customer Login";
		String actualLoginPageTitle = driver.getTitle();
		
		if(expectedLoginPageTitle.equalsIgnoreCase(actualLoginPageTitle))
		{
			System.out.println("TEST RESULT(LoginIn): Test case FAIL because of user is not logged in to the application and page title is coming as : '"+actualLoginPageTitle+"'");
			return false;
		}
		else
		{
			System.out.println("TEST RESULT(LoginIn): Test case PASS because of user is logged in to the application and page title is coming as : '"+actualLoginPageTitle+"'");
			return true;
		}
		
		
		
	}

}
