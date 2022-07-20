package com.MagentoStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MagentoStore.testCases.BaseClass;

public class AccCreationPage extends BaseClass{

	public AccCreationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Create New Customer Account']")
	WebElement acccCreationText;
	@FindBy(id="firstname")
	WebElement txtFirstname;
	@FindBy(id="lastname")
	WebElement txtLastname;
	@FindBy(id="email_address")
	WebElement txtEmail;
	@FindBy(id="password")
	WebElement txtPassword;
	@FindBy(id="password-confirmation")
	WebElement txtConPassword;
	@FindBy(xpath="//span[text()='Create an Account']")
	WebElement accCreationBtn;
	@FindBy(css="span.logged-in")
	WebElement signupUserName;
	@FindBy(xpath="//*[@id='html-body']/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement signoutDrpDownBtn;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signoutBtn;

	public String validateAccCreationPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateAccCreationPageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateAccCreationPageText()
	{
		return acccCreationText.isDisplayed();
	}

	public HomePage createAccount(String fn,String ln,String email,String pwd,String conpwd)
	{
		txtFirstname.sendKeys(fn);
		txtLastname.sendKeys(ln);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pwd);
		txtConPassword.sendKeys(conpwd);
		accCreationBtn.click();

		//Explicit Wait until UserName is displayed
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.logged-in")));

		//Click on Signout Drop Down Button
		signoutDrpDownBtn.click();

		//Click on Signout Button
		signoutBtn.click();

		return new HomePage();

	}


}
