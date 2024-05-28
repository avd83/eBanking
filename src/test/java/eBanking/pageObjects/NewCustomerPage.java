package eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	public WebDriver driver;	
	public NewCustomerPage(WebDriver driver)
	{		
		super();
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New Customer")
	WebElement lnkNewCustomer;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement txtCustomerName;
		
	@FindBy(xpath = "//td/input[@type='radio']")
	WebElement rdGender;
	
	@FindBy(id = "dob")
	WebElement txtDate;	

	@FindBy(xpath = "//input[@name='city']")
	WebElement txtCity;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement txtState;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement txtPinNo;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement txtTelephoneNo;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement txtEmailId;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement txtAddress;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;
	
		public void clickLink()
		{
			lnkNewCustomer.click();
		}			
		public void setcustomerName(String cName)
		{
			txtCustomerName.sendKeys(cName);
		}		
		public void setGender(String cGender)
		{
			rdGender.click();
		}
		public void setDate(String mm,String DD,String yyyy)
		{
			txtDate.sendKeys(mm);
			txtDate.sendKeys(DD);
			txtDate.sendKeys(yyyy);
		}
		public void setAddress(String cAddress)
		{
			txtAddress.sendKeys(cAddress);
		}
		public void setCity(String cCity)
		{
			txtCity.sendKeys(cCity);
		}
		public void setState(String cState)
		{
			txtState.sendKeys(cState);
		}
		public void setPinNo(String cPinNo)
		{
			txtPinNo.sendKeys(String.valueOf(cPinNo));
		}
		public void setPhNo(String cPhNo)
		{
			txtTelephoneNo.sendKeys(cPhNo);
		}		
		public void setEmailId(String cEmailId)
		{
			txtEmailId.sendKeys(cEmailId);
		}		
		public void submit()
		{
			btnSubmit.click();
		}
		
	}

