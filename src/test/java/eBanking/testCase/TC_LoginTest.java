package eBanking.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import eBanking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass {
	
	String title="GTPL Bank Manager HomePage";
	
	@Test
	public void login() throws InterruptedException
	{	
		logger.info("In test case execution");
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

