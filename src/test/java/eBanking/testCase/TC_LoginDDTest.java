package eBanking.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import eBanking.pageObjects.LoginPage;
import eBanking.utilities.XLUtilis;

public class TC_LoginDDTest extends BaseClass{

	String title="GTPL Bank Manager HomePage";   
	
	@Test(dataProviderClass = XLUtilis.class,dataProvider="loginDDT")
	public void loginDDT(String userName,String password) 
	{	
		logger.info("url is opened");
		driver.manage().window().maximize();
		LoginPage lp= new LoginPage(driver) ;
		lp.setUserName(userName);
		logger.info("username is enetered");
		lp.setPassword(password);
		logger.info("password is enetered");
		lp.submit();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals(title))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}

}
