package com.MagentoStore.testCases;

import org.testng.annotations.Test;

import com.MagentoStore.pageObjects.AddToCartPage;
import com.MagentoStore.pageObjects.CheckOutPage;
import com.MagentoStore.pageObjects.HomePage;
import com.MagentoStore.pageObjects.LoginPage;
import com.MagentoStore.pageObjects.MyAccountPage;
import com.MagentoStore.pageObjects.OrderSummaryPage;

public class OrderSummaryPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;
	OrderSummaryPage orderSummaryPage;

	public OrderSummaryPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateOrderSummaryTest() throws InterruptedException
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		addToCartPage=myAccountPage.addProductsToCart();

		checkOutPage=addToCartPage.validateProductsInCart();

		orderSummaryPage=checkOutPage.enterShippingDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("street"), prop.getProperty("country"), 
				prop.getProperty("state"), prop.getProperty("city"), prop.getProperty("postalCode"), prop.getProperty("telephone"));

		orderSummaryPage.validateOrderSummary();

		logger.info("Validated Order Summary on OrderSummary Page");
	}

}
