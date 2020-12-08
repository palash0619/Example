package com.example.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public Properties prop ;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		try 
		{
			
			FileInputStream fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @author palash
	 */
	public String getApplicationUrl()
	{
		String appUrl=prop.getProperty("baseUrl");
		return appUrl;
	}
	
	public String getUserName()
	{
		String userName=prop.getProperty("username");
		return userName;
	}
	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromePath=prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=prop.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIEPath()
	{
		String iePath=prop.getProperty("IEpath");
		return iePath;
	}
	
	

}
