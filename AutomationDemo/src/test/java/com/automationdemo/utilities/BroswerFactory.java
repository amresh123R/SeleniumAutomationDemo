package com.automationdemo.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BroswerFactory {
	
	
	public static WebDriver startApplication(WebDriver driver, String broswerName , String appUrl ) 
	{
		if(broswerName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
			System.out.println("HEEEEEEEEEEEEEEE");
		}
		else if(broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(broswerName.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void quitBroswer(WebDriver driver) 
	{
		driver.quit();
	}

}
