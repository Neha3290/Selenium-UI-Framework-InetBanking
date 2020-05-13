package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	//Create constructor for initiate the lcoal driver
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//Finding all elements of Add Customer Page
	
	// New Customer link
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement newCustomerLinkTxt;
	
	// Customer Name field
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement customerName;
	
	// Gender "Male" field
	@FindBy(xpath="//tr[5]//td[2]//input[1]")
	@CacheLookup
	WebElement genderMale;

	
	//  Gender "Female" field
	@FindBy(xpath="//tr[5]//td[2]//input[2]")
	@CacheLookup
	WebElement genderFemale;
	
	// Date Of Birth field
	@FindBy(xpath="//input[@id='dob']")
	@CacheLookup
	WebElement dob;


	
	// Address Text Area
	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement addrTxtArea;

	
	// City field
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement city;

	
	// State field
	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement state;

	
	// Pin No field
	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement pinNo;

	
	// Mobile No field
	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement mobileNo;
	
	// Email field
	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement email;

	
	// Password field
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement pwd;

	
	// Submit Button field
	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	WebElement submitBtn;
	
	// Reset Button field
	@FindBy(xpath="//input[@name='res']")
	@CacheLookup
	WebElement resetBtn;
	
	public void clickNewCustLink()
	{
		newCustomerLinkTxt.click();	
	}
	
	
	public void enterName(String name)
	{
		customerName.sendKeys(name);	
	}
	
	public void clickMale()
	{
		genderMale.click();	
	}
	
	public void clickFemale()
	{
		genderFemale.click();	
	}
	
	public void enterDOB(String mm, String dd, String yy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	
	public void enterAddress(String address)
	{
		addrTxtArea.sendKeys(address);	
	}
	
	public void enterCity(String cityName)
	{
		city.sendKeys(cityName);	
	}
	

	public void enterState(String stateName)
	{
		state.sendKeys(stateName);	
	}
	
	public void enterPinNo(String pin)
	{
		pinNo.sendKeys(pin);	
	}
	
	
	public void enterMobileNo(String mobile)
	{
		mobileNo.sendKeys(mobile);	
	}
	
	public void enterEmail(String emailAdd)
	{
		email.sendKeys(emailAdd);	
	}
	
	public void enterPassword(String password)
	{
		pwd.sendKeys(password);	
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}
	
	public void clickReset()
	{
		resetBtn.click();
	}	
	

}
