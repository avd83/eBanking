package eBanking.testCase;

import org.testng.annotations.Test;
import eBanking.pageObjects.NewCustomerPage;

public class TC_NewCustomerTest extends BaseClass{
	public  NewCustomerPage nc;
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		TC_LoginTest lt = new TC_LoginTest();
		lt.login();
		Thread.sleep(5000);
		NewCustomerPage ncp = new NewCustomerPage(driver);
		ncp.clickLink();
		Thread.sleep(5000);
		ncp.setcustomerName("apoorv");
		ncp.setGender("male");
		ncp.setDate("12","22","1983");
		ncp.setAddress("pune");
		ncp.setCity("chinchwad");
		ncp.setState("maharashtra");
		ncp.setPinNo("411019");
		ncp.setPhNo("9975679862");
		ncp.setEmailId("abc@gmail.com");
		
		ncp.submit();
		Thread.sleep(5000);	
		
	}

}
