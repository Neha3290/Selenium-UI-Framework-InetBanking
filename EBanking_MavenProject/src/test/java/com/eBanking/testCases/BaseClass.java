package com.eBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();	
	
	public String baseURL =readConfig.getApplicationURL();
	public String userID =readConfig.getUserID();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public String homeDir=System.getProperty("user.dir");
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws InterruptedException {		

		logger= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		Thread.sleep(2000);
		driver=new ChromeDriver();
		
		} else if(br.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			Thread.sleep(2000);
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
		//logger.log(LogStatus.FAIL, logger.addScreenCapture(target));
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}	
		
	}
	
	public String generatedStr(int count)
	{
		String ranStr = RandomStringUtils.randomAlphabetic(count);
		return ranStr;		
	}
	
	public String generatedNum(int count)
	{
		String ranNum = RandomStringUtils.randomAlphanumeric(4);
		return ranNum;		
	}


}
