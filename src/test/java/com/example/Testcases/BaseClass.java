package com.example.Testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.example.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig config = new ReadConfig();
	
	public String baseUrl=config.getApplicationUrl();
	public String username =config.getUserName();
	public String password =config.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
	
		logger=Logger.getLogger("Example");
		PropertyConfigurator.configure("log4j.properties");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",config.getChromepath());
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",config.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",config.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(baseUrl);
		logger.info("Url is Opened");

	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	

}
