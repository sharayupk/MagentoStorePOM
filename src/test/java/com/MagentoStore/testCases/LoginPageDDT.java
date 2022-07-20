package com.MagentoStore.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.MagentoStore.pageObjects.HomePage;
import com.MagentoStore.pageObjects.LoginPage;
import com.MagentoStore.pageObjects.MyAccountPage;
import com.MagentoStore.utilities.XLUtils;

public class LoginPageDDT extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@Test(dataProvider="loginData")
	public void loginTest(String username,String pwd) throws InterruptedException
	{
		homePage=new HomePage();
		Thread.sleep(1000);
		loginPage=homePage.clickOnLoginLink();

		myAccountPage=loginPage.login(username,pwd);

		logger.info("Login Done Successfully");
		
		Thread.sleep(2000);

		if(isTextPresent()==true)
		{
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}

		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}
	}

	public boolean isTextPresent()
	{
		try {
			driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div")).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	@DataProvider
	public Object[][] loginData() throws IOException
	{
		String xlPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\MagentoStore\\testData\\testData.xlsx";

		int rowCount=XLUtils.getRowCount(xlPath, "Sheet1");
		int cellCount=XLUtils.getCellCount(xlPath, "Sheet1", 0);

		String loginData[][]=new String[rowCount][cellCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(xlPath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
