package com.MagentoStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MagentoStore.pageObjects.AddToCartPage;
import com.MagentoStore.pageObjects.HomePage;
import com.MagentoStore.pageObjects.LoginPage;
import com.MagentoStore.pageObjects.MyAccountPage;

public class MyAccountPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AddToCartPage addToCartPage;

	public MyAccountPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateMyAccountPageURLTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		String actMyAccountPageURL=myAccountPage.validateMyAccountPageURL();

		Assert.assertEquals(actMyAccountPageURL, "https://magento.nublue.co.uk/");

		logger.info("Validated MyAccount Page URL");
	}

	@Test(priority=2)
	public void validateMyAccountPageTitleTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		String actMyAccountPageTitle=myAccountPage.validateMyAccountPageTitle();

		Assert.assertEquals(actMyAccountPageTitle, "Home Page");

		logger.info("Validated MyAccount Page Title");
	}

	@Test(priority=3)
	public void validateMyAccountPageUserNameTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		boolean actMyAccountPageUserName=myAccountPage.validateMyAccountPageUserName();

		Assert.assertTrue(actMyAccountPageUserName);

		logger.info("Validated MyAccount Page UserName");
	}

	@Test(priority=4)
	public void validateMyAccountPageTextTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		boolean actMyAccountPageText=myAccountPage.validateMyAccountPageText();

		Assert.assertTrue(actMyAccountPageText);

		logger.info("Validated MyAccount Page Text");
	}

	@Test(priority=5)
	public void addProductsToCartTest() throws InterruptedException
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		addToCartPage=myAccountPage.addProductsToCart();	

		logger.info("Added Products To Cart on MyAccount Page");
	}

}
