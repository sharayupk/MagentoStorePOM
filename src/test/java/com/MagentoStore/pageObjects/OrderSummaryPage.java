package com.MagentoStore.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MagentoStore.testCases.BaseClass;

public class OrderSummaryPage extends BaseClass{

	public OrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='opc-sidebar']/div[1]/table/tbody/tr[1]/td/span")
	WebElement cartSubtotal;
	@FindBy(xpath="//*[@id='opc-sidebar']/div[1]/table/tbody/tr[2]/td/span")
	WebElement discountPrice;
	@FindBy(xpath="//*[@id='opc-sidebar']/div[1]/table/tbody/tr[3]/td/span")
	WebElement shippingPrice;
	@FindBy(xpath="//*[@id='opc-sidebar']/div[1]/table/tbody/tr[4]/td/strong/span")
	WebElement totalPrice;
	@FindBy(xpath="//span[text()='Place Order']")
	WebElement placeOrderBtn;
	
	public void validateOrderSummary() throws InterruptedException
	{
		Double actCartSubtotal = Parse(cartSubtotal);
		System.out.println("Actual Cart Subtotal Price--->"+actCartSubtotal);

		Double actDiscountPrice = Parse(discountPrice);
		System.out.println("Actual Discount Price--->"+actDiscountPrice);
		
		Double actShippingPrice= Parse(shippingPrice);
		System.out.println("Actual Shipping Price--->"+actShippingPrice);
		
		Double expTotalPrice= actCartSubtotal+actDiscountPrice+actShippingPrice;
		System.out.println("Expected Total Price--->"+expTotalPrice);

		Double actTotalPrice = Parse(totalPrice);
		System.out.println("Actual Total Price--->"+actTotalPrice);
		
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		placeOrderBtn.click();
	}
	
	static Double Parse(WebElement element) {
		return Double.parseDouble(element.getText().split("£")[1].trim());
	}

}
