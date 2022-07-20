package com.MagentoStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MagentoStore.testCases.BaseClass;

public class LoginPage  extends BaseClass{

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Customer Login']")
	WebElement loginText;
	@FindBy(id="email")
	WebElement txtEmail;
	@FindBy(id="pass")
	WebElement txtPassword;
	@FindBy(id="send2")
	WebElement loginBtn;

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public String validateLoginPageText()
	{
		return loginText.getText();
	}

	public MyAccountPage login(String un,String pwd)
	{
		txtEmail.sendKeys(un);
		txtPassword.sendKeys(pwd);
		loginBtn.click();

		return new MyAccountPage();
	}

}
