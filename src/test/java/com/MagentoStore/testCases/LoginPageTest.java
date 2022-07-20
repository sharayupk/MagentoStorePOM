package com.MagentoStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MagentoStore.pageObjects.AccCreationPage;
import com.MagentoStore.pageObjects.HomePage;
import com.MagentoStore.pageObjects.LoginPage;
import com.MagentoStore.pageObjects.MyAccountPage;

public class LoginPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	public LoginPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateLoginPageTitleTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		String actLoginPageTitle=loginPage.validateLoginPageTitle();

		Assert.assertEquals(actLoginPageTitle, "Customer Login");

		logger.info("Validated Login Page Title");
	}

	@Test(priority=2)
	public void validateLoginPageTextTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		String actLoginPageText=loginPage.validateLoginPageText();

		Assert.assertEquals(actLoginPageText, "Customer Login");

		logger.info("Validated Login Page Text");
	}

	@Test(priority=3)
	public void loginTest()
	{
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(prop.getProperty("emailId"), prop.getProperty("pwd"));

		logger.info("Login Done Successfully");
	}
}
