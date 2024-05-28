package eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class ReadConfig  {
	Properties pro;
	//public static Logger logger;	
	public ReadConfig()  
	{			
		
	File src = new File("./Configuration/global.properties");
	
	try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
	}catch (Exception e)
		{
			System.out.println("Exception is"+ e.getMessage());		
		}
	//logger.info("intialize the global properties file");
	}
	public String applicationURL()
	{
		//logger.info("intialize the global properties file");
		String url = pro.getProperty("baseUrl");
		return url;		
	}	
	public String getUserName()
	{
		String userName= pro.getProperty("userName");
		return userName;
	}	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;		
	}
	public String getFirfoxPath()
	{
		String chromePath = pro.getProperty("firfoxPath");
		return chromePath;		
	}
	public String getMsedgePath()
	{
		String chromePath = pro.getProperty("msedgePath");
		return chromePath;
	}
	public String getNewCustomerDetails()
	{
		String customerName= pro.getProperty("customerName");
		return customerName;
		
	}
	

}

