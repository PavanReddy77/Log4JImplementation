package com.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;
	Logger logger = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("----------Launching Chrome Browser----------");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("https://classic.crmpro.com/index.html");
		logger.info("Launching CRMPRO Application");
		
		//Others Logger Levels
		//logger.warn("This is Just a Warning Message");
		//logger.fatal("This is Just a Fatal Error Message");
		//logger.debug("This is Just a Debug Message");
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest()
	{
		logger.info("Starting freeCrmTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		logger.info("Printing Title of Application");	
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		logger.info("Closing freeCrmTitleTest");
	}
	
	@Test(priority=2)
	public void freemCRMLogoTest()
	{
		logger.info("Starting freemCRMLogoTest");
		boolean b = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
		Assert.assertTrue(b);
		logger.info("Free CRMPRO Logo is Verified");
		logger.info("Closing freemCRMLogoTest");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("----------Closing CRMPRO Application----------");
	}
}
