package com.MagentoStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MagentoStore.testCases.BaseClass;

public class HomePage extends BaseClass{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Create an Account']")
	WebElement acccCreationLink;
	@FindBy(css=".logo")
	WebElement homePageLogo;
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement loginLink;

	public String validateHomePageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateHomePageLogo()
	{
		return homePageLogo.isDisplayed();
	}

	public AccCreationPage clickOnAccCreationLink()
	{
		acccCreationLink.click();

		return new AccCreationPage();
	}

	public LoginPage clickOnLoginLink()
	{
		loginLink.click();

		return new LoginPage();
	}

}
