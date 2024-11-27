package com.automationdemo.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationdemo.pages.BaseTest;
import com.automationdemo.pages.LoginPage;
import com.automationdemo.utilities.ConfigDataProvider;
import com.automationdemo.utilities.ReadExcelFile;

public class TestDataDrivenLogin extends BaseTest{
	
	String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	ConfigDataProvider cdp = new ConfigDataProvider();
	
	
	@Test(priority = 1, dataProvider = "loginDataProvider")
	public void verifyLogin(String username, String password) throws IOException
	{
		LoginPage obj = new LoginPage(driver);
		obj.loginPortal(username,password);
		
		if(username.equals(cdp.getUsername()) && password.equals(cdp.getPassword()))
		{
			System.out.println("Test Passed");
			org.testng.Assert.assertTrue(true);
			obj.logoutPortal();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			org.testng.Assert.assertTrue(false);
			
		}
	}
	
	@DataProvider(name = "loginDataProvider" )
	public Object [][] loginDataProvider()
	{
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		//System.out.println("total row count"+ttlRows);
		
		int ttlColumns = ReadExcelFile.getCellCount(fileName, "LoginData");
		//System.out.println("Total column count"+ttlColumns);
		Object data [][] = new Object[ttlRows -1][ttlColumns];
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
		
	}

}
