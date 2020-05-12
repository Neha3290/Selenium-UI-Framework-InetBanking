package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	//Create constructor for initiate the lcoal driver
	public LoginPage(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//Finding all elements of login page
	// User ID
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserID;
	
	//Password
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	//Login Button
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	//Reset Button
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement btnReset;
	
	//Welcome Text Just After Login
	@FindBy(xpath="//marquee[@class='heading3']")
	@CacheLookup
	WebElement welcomeTxt;
	
	//Logout Button
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutBtn;
	
	//Set Action method for all these element
	// Set User ID
	public void setUserID(String userID) {
		
		txtUserID.sendKeys(userID);
	}
	
	// Set Password
	public void setPassword(String password) {
			
		txtPassword.sendKeys(password);
	}
		
	// Click on Submit Button
	public void clickSubmit() {
			
		btnLogin.click();
	}	
	
	// Click on Reset Button
	public void clickReset() {
		
		btnReset.click();
	}	
	
	//Check Welcome text is present or not after log in
	public boolean checkWelTxt()
	{
		boolean status = welcomeTxt.isDisplayed();
		return status;
	}
	
	// Click on Submit Button
	public void clickLogout() {		
		logoutBtn.click();		
	}	
}










