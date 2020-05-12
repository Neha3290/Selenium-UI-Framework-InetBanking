package com.eBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddCustomerPage;
import com.eBanking.pageObjects.LoginPage;



public class TC_AddNewCustomer_TestCase_002 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
	LoginPage lp =new LoginPage(driver);
	
	lp.setUserID("mngr259076");
	lp.setPassword("huhetug");
	lp.clickSubmit();
	Thread.sleep(3000);
	logger.info("Login Successfull");	
	
	
	AddCustomerPage addCust = new AddCustomerPage(driver);	
	
	addCust.clickNewCustLink();
	logger.info("New Customer link text is clicked");
	Thread.sleep(3000);
	
	addCust.enterName("Putt");
	addCust.clickMale();
	addCust.enterDOB("15", "02", "89");
	addCust.enterAddress("Mansarovar");
	addCust.enterCity("Jaipur");
	addCust.enterState("Rajasthan");
	addCust.enterPinNo("302015");
	addCust.enterMobileNo("9876543210");
	
	//Create Random Unique Email ID
	String randomString = generatedStr(6);	
	addCust.enterEmail(randomString+"@gmail.com");
	
	addCust.enterPassword("Putt@143");
	logger.info("Customer detail is entered");
	addCust.clickSubmit();
	logger.info("Submit button is clicked");
	
	Thread.sleep(10000);
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("New Customer is added Successfully");
	}
	else
	{
		captureScreenshot("TC_AddNewCustomer_TestCase_002");
		Thread.sleep(5000);
		logger.info("New Customer is not added Successfully");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
	}
	
	}
	

}
