package com.automationdemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() 
	{
		File src = new File("./Configurations/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch (Exception e) {
			System.out.println("Not able to load config file: "+e.getMessage());
			
		}

	}
	
	public String getBrowser() 
	{
		
		return pro.getProperty("broswer");
	}
	
	public String getStagingUrl()
	{
		return pro.getProperty("testurl");
	}
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	public String getPassword()
	{
		return pro.getProperty("password");
	}

}
