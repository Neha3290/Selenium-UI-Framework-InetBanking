package com.eBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.XLUtils;

public class TC_LoginTest_DDT_001 extends BaseClass{
	
	
	@Test(dataProvider="Login Data")
	public void login_DDT(String ID, String pwd) throws InterruptedException
	{
		BaseClass bc = new BaseClass();
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserID(ID);
		logger.info("User ID entered");
		lp.setPassword(pwd);
		logger.info("User password is entered");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		if(bc.isAlertPresent()==true)
		{
			
			logger.warn(ID+" = Login Failed");
			driver.switchTo().alert().accept();
			logger.info("Ok button is clicked on Alert after unsuccessfull login");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();//focus on main page from alert
			Assert.assertTrue(false);
			
			
		}else {
			logger.info(ID+" = Login Successfull");
			Assert.assertTrue(true);
			lp.clickLogout();	
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			logger.info("Ok button is clicked on Logout Alert");
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	@DataProvider(name="Login Data")
	String[][] getData() throws IOException
	{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/eBanking/testData/LoginTestData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++)
		{
			
			for(int j=0; j<colCount; j++)			
			{
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
			
		}
		
	return loginData;
		
	}

}
