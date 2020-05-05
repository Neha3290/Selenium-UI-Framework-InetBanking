package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPage;

public class TC_LoginTest_testCase extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
			
			
			logger.info("URL is Opened");
			
			LoginPage lp= new LoginPage(driver);
			
			lp.setUserID(userID);
			logger.info("User ID is entered");
			
			lp.setPassword(password);
			logger.info("Password is entered");
			 
			lp.clickSubmit();
			logger.info("We have clicked on Submit button");
			
			String expTitle="Guru99 Bank Manager HomePage";
			
			if(driver.getTitle().equals(expTitle)) {
				
				logger.info("Login is done Successfully");
				Assert.assertTrue(true);	
				
				
			}else {
				
				captureScreenshot("loginTest");
				logger.info("Login is failed");
				Assert.assertTrue(false);
				
			}
		}

}
