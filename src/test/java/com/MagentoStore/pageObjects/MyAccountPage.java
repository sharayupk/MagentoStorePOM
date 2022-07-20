package com.MagentoStore.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MagentoStore.testCases.BaseClass;

public class MyAccountPage extends BaseClass{

	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountText;
	@FindBy(css="span.logged-in")
	WebElement myAccountUserName;
	@FindBy(xpath="//span[text()='Women']")
	WebElement womenMenu;
	@FindBy(xpath="//span[text()='Tops']")
	WebElement topsSubMenu;
	@FindBy(xpath="//span[text()='Jackets']")
	WebElement jacketsSubMenu;
	@FindBy(xpath="//div[text()='M']")
	WebElement jacketSize;
	@FindBy(id="option-label-color-93-item-58")
	WebElement jacketColor;
	@FindBy(id="product-addtocart-button")
	WebElement addToCartBtn;
	@FindBy(xpath="//span[text()='Men']")
	WebElement menMenu;
	@FindBy(xpath="//*[@id='ui-id-17']/span[2]")
	WebElement bottomSubMenu;
	@FindBy(xpath="//*[@id='ui-id-22']/span")
	WebElement pantSubMenu;
	@FindBy(xpath="//div[text()='32']")
	WebElement pantSize;
	@FindBy(id="option-label-color-93-item-51")
	WebElement pantColor;
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement addToCart;


	public String validateMyAccountPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateMyAccountPageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateMyAccountPageUserName()
	{
		return myAccountUserName.isDisplayed();
	}

	public boolean validateMyAccountPageText()
	{
		return myAccountText.isDisplayed();
	}

	public AddToCartPage addProductsToCart() throws InterruptedException
	{
		Actions action=new Actions(driver);

		Thread.sleep(1000);
		//Move Mouse Cursor on Women Menu
		action.moveToElement(womenMenu).build().perform();

		//Move Mouse Cursor on Tops Sub Menu under Women Menu
		action.moveToElement(topsSubMenu).build().perform();

		//Click on Jackets on Tops Sub Menu under Women Menu
		action.moveToElement(jacketsSubMenu).click().build().perform();
		Thread.sleep(1000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,800)");

		List<WebElement> womenList=driver.findElements(By.cssSelector(".product-item-link"));

		for(int i=1;i<womenList.size();i++)
		{
			String jacketName=womenList.get(i).getText();
			System.out.println("Jacket Name:"+jacketName);

			if(jacketName.contains("Inez Full Zip Jacket"))
			{
				driver.findElement(By.xpath("//*[@id='product-item-info_1306']/div/strong/a")).click();
				break;
			}
		}

		//Click on M Size Btn
		jacketSize.click();
		Thread.sleep(1000);

		//Click on RED color
		jacketColor.click();
		Thread.sleep(1000);

		//Click on Add To Cart Btn
		addToCartBtn.click();

		Thread.sleep(1000);

		//Move Mouse Cursor on Men Menu
		action.moveToElement(menMenu).build().perform();
		Thread.sleep(1000);
		
		//Move Mouse Cursor on Bottoms Sub Menu under Men Menu
		action.moveToElement(bottomSubMenu).build().perform();
		Thread.sleep(1000);
		
		//Click on Pants on Bottoms Sub Menu under Men Menu
		action.moveToElement(pantSubMenu).click().build().perform();
		Thread.sleep(1000);

		List<WebElement> menList=driver.findElements(By.cssSelector(".product-item-link"));

		for(int i=1;i<menList.size();i++)
		{
			String pantName=menList.get(i).getText();
			System.out.println("Pant Name:"+pantName);

			if(pantName.contains("Aether Gym Pant"))
			{
				driver.findElement(By.xpath("//*[@id='product-item-info_873']/div/strong/a")).click();
				
				break;
			}
		}

		//Click on 32 Size Btn
		pantSize.click();
		Thread.sleep(1000);

		//Click on Brown color
		pantColor.click();
		Thread.sleep(1000);

		//Click on Add To Cart Btn
		addToCartBtn.click();

		WebDriverWait wb=new WebDriverWait(driver,10);
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action showcart']")));
		
		//Click on Add To Cart
		addToCart.click();

		return new AddToCartPage();

	}
}
