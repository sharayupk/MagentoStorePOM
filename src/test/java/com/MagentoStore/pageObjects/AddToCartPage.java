package com.MagentoStore.pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MagentoStore.testCases.BaseClass;

public class AddToCartPage extends BaseClass{

	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='mini-cart']/li[1]/div/div/div[2]/div[1]/span/span/span/span")
	WebElement pantPrice;
	@FindBy(xpath="//*[@id='mini-cart']/li[2]/div/div/div[2]/div[1]/span/span/span/span")
	WebElement jacketPrice;
	@FindBy(xpath="//*[@id='minicart-content-wrapper']/div[2]/div[2]/div/span/span")
	WebElement totalPrice;
	@FindBy(id="top-cart-btn-checkout")
	WebElement proceedToCheckOutBtn;

	public CheckOutPage validateProductsInCart() throws InterruptedException
	{
		String[] itemsNeeded= {"Aether Gym Pant","Inez Full Zip Jacket"};

		List<WebElement>productList=driver.findElements(By.cssSelector(".product-item-name"));

		for(int i=1;i<productList.size();i++)
		{
			String names=productList.get(i).getText();

			//Convert Array to Arraylist
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if(itemsNeededList.contains(names))
			{
				System.out.println("Test Case Passed");
			}
			else 
			{
				System.out.println("Test Case Failed");
			}
		}

		Thread.sleep(1000);

		Double actPantPrice = Parse(pantPrice);
		System.out.println("Actual Men Pant Price--->"+actPantPrice);

		Thread.sleep(1000);

		Double actJacketPrice = Parse(jacketPrice);
		System.out.println("Actual Women Jacket Price--->"+actJacketPrice);

		Double expTotalPrice= actPantPrice+actJacketPrice;
		System.out.println("Expected Total Price--->"+expTotalPrice);

		Double actTotalPrice = Parse(totalPrice);
		System.out.println("Actual Total Price--->"+actTotalPrice);

		//Assert.assertEquals(actTotalPrice, expTotalPrice, "Total Price of products does not match");

		proceedToCheckOutBtn.click();

		return new CheckOutPage();
	}

	static Double Parse(WebElement element) {
		return Double.parseDouble(element.getText().split("£")[1].trim());
	}
}
