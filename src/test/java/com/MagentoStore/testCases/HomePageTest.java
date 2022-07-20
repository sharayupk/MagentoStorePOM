package com.MagentoStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MagentoStore.pageObjects.AccCreationPage;
import com.MagentoStore.pageObjects.HomePage;

public class HomePageTest extends BaseClass{

	HomePage homePage;
	AccCreationPage accCreationPage;

	public HomePageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateHomePageURLTest()
	{
		homePage=new HomePage();
		String acthomePageURL=homePage.validateHomePageURL();

		Assert.assertEquals(acthomePageURL, prop.getProperty("url"));

		logger.info("Validated Home Page URL");
	}

	@Test(priority=2)
	public void validateHomePageTitleTest()
	{
		homePage=new HomePage();
		String acthomePageTitle=homePage.validateHomePageTitle();

		Assert.assertEquals(acthomePageTitle, "Home Page");

		logger.info("Validated Home Page Title");
	}

	@Test(priority=3)
	public void validateHomePageLogoTest()
	{
		homePage=new HomePage();
		boolean acthomePageLogo=homePage.validateHomePageLogo();

		Assert.assertTrue(acthomePageLogo);

		logger.info("Validated Home Page Logo");
	}

	@Test(priority=4)
	public void clickOnAccCreationLinkTest()
	{
		homePage=new HomePage();
		accCreationPage=homePage.clickOnAccCreationLink();

		logger.info("Clicked On AccCreation Link on Home Page");
	}

}
