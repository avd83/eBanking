package eBanking.testCase;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import eBanking.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
    ReadConfig readConfig = new ReadConfig() ;
	public String baseUrl=readConfig.applicationURL();
	public String userName=readConfig.getUserName();
	public String password=readConfig.getPassword();
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("browser selection starting");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver = new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getFirfoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getMsedgePath());
			driver = new EdgeDriver();
		}		
		logger.info("url is to be open in chrome");
		driver.get(baseUrl);
		logger.info("basurl opened in chrome");
	}
	
	public String getScreenShort(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//Screenshots//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") +"//reports//" + testCaseName + ".png";
	}
	
	
	@AfterClass
	public void tearDown()
	{
		logger.info("logout");
		driver.quit();
	}
}
