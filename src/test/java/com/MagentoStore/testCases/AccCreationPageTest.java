package com.MagentoStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MagentoStore.pageObjects.AccCreationPage;
import com.MagentoStore.pageObjects.HomePage;


public class AccCreationPageTest extends BaseClass{

	HomePage homePage;
	AccCreationPage accCreationPage;

	public AccCreationPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateAccCreationPageURLTest()
	{
		homePage=new HomePage();
		accCreationPage=homePage.clickOnAccCreationLink();

		String actAccCreationPageURL=accCreationPage.validateAccCreationPageURL();

		Assert.assertEquals(actAccCreationPageURL, "https://magento.nublue.co.uk/customer/account/create/");

		logger.info("Validated AccCreation Page URL");
	}

	@Test(priority=2)
	public void validateAccCreationPageTitleTest()
	{
		homePage=new HomePage();
		accCreationPage=homePage.clickOnAccCreationLink();

		String actAccCreationPageTitle=accCreationPage.validateAccCreationPageTitle();

		Assert.assertEquals(actAccCreationPageTitle, "Create New Customer Account");

		logger.info("Validated AccCreation Page Title");
	}

	@Test(priority=3)
	public void validateAccCreationPageTextTest()
	{
		homePage=new HomePage();
		accCreationPage=homePage.clickOnAccCreationLink();

		boolean actAccCreationPageText=accCreationPage.validateAccCreationPageText();

		Assert.assertTrue(actAccCreationPageText);

		logger.info("Validated AccCreation Page Text");
	}

	@Test(priority=4)
	public void createAccountTest()
	{
		homePage=new HomePage();
		accCreationPage=homePage.clickOnAccCreationLink();

		homePage=accCreationPage.createAccount(prop.getProperty("firstname"), prop.getProperty("lastname"), 
				prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("conPassword"));

		logger.info("Account Created Successfully");
	}

}
