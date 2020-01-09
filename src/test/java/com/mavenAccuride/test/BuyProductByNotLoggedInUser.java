package com.mavenAccuride.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.accuride.comanPages.BrowserFactory;
import com.accuride.pages.CartDialog;
import com.accuride.pages.HomePage;
import com.accuride.pages.LogIn;
import com.accuride.pages.PaymentPage;
import com.accuride.pages.ProductDeatilsPage;
import com.accuride.pages.SearchField;
import com.accuride.pages.ShoppingAddressPage;
import com.accuride.pages.ShoppingCartPage;

public class BuyProductByNotLoggedInUser {
	
WebDriver driver;
	
	
	@BeforeTest
	public void browserLaunch() throws InterruptedException
	{
		driver = BrowserFactory.browserLunch("Chrome","https://stage.accuride.com");		
		//Thread.sleep(3000);
	}
	
	
	@Test(priority=1, enabled=true)
	public void checkHomePageTitle()
	{
		HomePage pageTitle = PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals(pageTitle.checkPageTitle(), true);
	}
	
		
	@Test(priority=2, enabled=true)
	public void searchProductOnTheSearchbox() throws InterruptedException, IOException
	{
		SearchField itemsearch = PageFactory.initElements(driver, SearchField.class);
		Assert.assertEquals(itemsearch.searchProduct(), true);
	}
	
	
	@Test(priority=3, enabled=true)
	public void intialProductQuantity() throws InterruptedException
	{
		ProductDeatilsPage productquant = PageFactory.initElements(driver, ProductDeatilsPage.class);
		Assert.assertEquals(productquant.checkTheInitialProductQuantity(), true);
	}
	
	@Test(priority=4, enabled=false)
	public void increasingTheproductCount() throws InterruptedException
	{
		ProductDeatilsPage increaseProduct = PageFactory.initElements(driver, ProductDeatilsPage.class);
		Assert.assertEquals(increaseProduct.increaseTheProductCountViaPlusIcon(), true);
	}
	
	
	@Test(priority=5, enabled=false)
	public void increasingTheProductCountViaDirectField() throws InterruptedException
	{
		ProductDeatilsPage enteredProductQuanaty = PageFactory.initElements(driver, ProductDeatilsPage.class);
		Assert.assertEquals(enteredProductQuanaty.increaseTheProductCountViaInputField(), true);
	}
	
//	@Test(priority=6, enabled=true)
//	public void productAddToCart() throws InterruptedException
//	{
//		ProductDeatilsPage addingProductToCart = PageFactory.initElements(driver, ProductDeatilsPage.class);
//		Assert.assertEquals(addingProductToCart.addToCart(), true);
//	}
//	
//	@Test(priority=7, enabled=true)
//	public void verifyTheCardDialogBox() throws InterruptedException
//	{
//		CartDialog verifythedialog = PageFactory.initElements(driver, CartDialog.class);
//		Assert.assertEquals(verifythedialog.verifyTheCartDialog(), true);
//	}
//	
//	@Test(priority=8, enabled=true)
//	public void verifyTheProductOnShoppingPage() throws InterruptedException
//	{
//		ShoppingCartPage verifyTheProducts = PageFactory.initElements(driver, ShoppingCartPage.class);
//		Assert.assertEquals(verifyTheProducts.checkAddedProductInToShoppingCart(), true);
//	}
	
	
//	@Test(priority=9, enabled=true)
//	public void verifyTheProceedToCartButton() throws InterruptedException
//	{
//		ShoppingCartPage verifyTheProceedToCartButton = PageFactory.initElements(driver, ShoppingCartPage.class);
//		Assert.assertEquals(verifyTheProceedToCartButton.proceedToCheckoutButton(), true);
//	}
//	
//	@Test(priority=10, enabled=true)
//	public void checkShippingPageTitle() throws InterruptedException
//	{
//		ShoppingAddressPage checkVerifyPageTitle = PageFactory.initElements(driver, ShoppingAddressPage.class);
//		Assert.assertEquals(checkVerifyPageTitle.shoppingAddressPageTitle(), true);
//	}
//	
//	@Test(priority=11, enabled=true)
//	public void checkingUserIsNotLoggedIn() throws InterruptedException
//	{
//		ShoppingAddressPage userNotLoggedIn = PageFactory.initElements(driver, ShoppingAddressPage.class);
//		userNotLoggedIn.checkedUserIsNotLoggedIn();
//	}
//	
//	@Test(priority=12,enabled=true)
//	public void validUserLogin() throws InterruptedException
//	{
//		ShoppingAddressPage login = PageFactory.initElements(driver, ShoppingAddressPage.class);
//		login.signInToTheUser();
//	}
//	
//	@Test(priority=13,enabled=false)
//	public void goingToThePayementPage() throws InterruptedException
//	{
//		ShoppingAddressPage goToPaymentPage = PageFactory.initElements(driver, ShoppingAddressPage.class);
//		goToPaymentPage.goToThePaymentPage();
//	}
//	
//	@Test(priority=14,enabled=false)
//	public void makePayment() throws InterruptedException
//	{
//		PaymentPage makingPayment = PageFactory.initElements(driver, PaymentPage.class);
//		Assert.assertEquals(makingPayment.placingOrder(), true);
//	}
	
//	@AfterTest
//	public void browserClose()
//	{
//		driver = BrowserFactory.closeBrowser();
//	}
	

}
