package com.MagentoStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.MagentoStore.testCases.BaseClass;

public class CheckOutPage extends BaseClass{

	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".new-address-popup button")
	WebElement newAddressBtn;
	@FindBy(name="firstname")
	WebElement txtFirstname;
	@FindBy(name="lastname")
	WebElement txtLastname;
	@FindBy(name="street[0]")
	WebElement txtStreetAddr;
	@FindBy(name="country_id")
	WebElement countryDrpDown;
	@FindBy(name="region_id")
	WebElement stateDrpDown;
	@FindBy(name="city")
	WebElement txtCity;
	@FindBy(name="postcode")
	WebElement txtPostalCode;
	@FindBy(name="telephone")
	WebElement txtPhoneNo;
	@FindBy(xpath="//span[text()='Ship Here']")
	WebElement shipHereBtn;
	@FindBy(xpath="//*[@id='checkout-shipping-method-load']/table/tbody/tr/td[1]/input")
	WebElement shippingMethod;
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextBtn;

	public OrderSummaryPage enterShippingDetails(String fn,String ln,String street,
			String country,String state,String city,String postal,String phone) throws InterruptedException
	{
		newAddressBtn.click();
		txtFirstname.clear();
		txtFirstname.sendKeys(fn);
		txtLastname.clear();
		txtLastname.sendKeys(ln);
		txtStreetAddr.sendKeys(street);

		/*Scroll the WebPage-Window Level
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(3000);

		Scroll the WebPage-Table Level
		js.executeScript("document.querySelector('.modal-inner-wrap').scrollTop=500");*/

		Select cntryDrpDown=new Select(countryDrpDown);
		cntryDrpDown.selectByVisibleText(country);

		Select stDrpDown=new Select(stateDrpDown);
		stDrpDown.selectByVisibleText(state);

		txtCity.sendKeys(city);
		txtPostalCode.sendKeys(postal);
		txtPhoneNo.sendKeys(phone);
		shipHereBtn.click();

		Thread.sleep(1000);
		shippingMethod.click();

		nextBtn.click();
		
		return new OrderSummaryPage();

	}

}
