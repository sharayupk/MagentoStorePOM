package com.MagentoStore.testCases;

import org.testng.annotations.Test;

import com.MagentoStore.pageObjects.AddToCartPage;
import com.MagentoStore.pageObjects.CheckOutPage;
import com.MagentoStore.pageObjects.HomePage;
import com.MagentoStore.pageObjects.LoginPage;
import com.MagentoStore.pageObjects.MyAccountPage;

public class AddToCartPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;

	public AddToCartPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validtaeProductsInCartTest() throws InterruptedException
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		addToCartPage=myAccountPage.addProductsToCart();

		checkOutPage=addToCartPage.validateProductsInCart();

		logger.info("Validated Products In Cart on AddToCart Page");
	}


}
