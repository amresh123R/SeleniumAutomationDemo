package com.automationdemo.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automationdemo.utilities.BroswerFactory;
import com.automationdemo.utilities.ConfigDataProvider;

public class BaseTest {
	
	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();
	
	@BeforeTest
	public void setUp()
	{
		
		driver = BroswerFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		BroswerFactory.quitBroswer(driver);
	}
	
	public static void captureScreenShot(WebDriver driver,String testName) throws IOException
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }

}
