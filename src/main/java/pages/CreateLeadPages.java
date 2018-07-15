package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPages extends WebDriverServiceImpl{
	
	public CreateLeadPages(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	@FindBy(id="createLeadForm_firstName")
	WebElement eleCompanyFN;
	@FindBy(id="createLeadForm_lastName")
	WebElement eleCompanyLN;
	@FindBy(name="submitButton")
	WebElement eleCreateButton;
	
	@FindBy(xpath="//input[@id='createLeadForm_primaryPhoneAreaCode']")
	WebElement eleAreaCode;
	@FindBy(xpath="//input[@id='createLeadForm_primaryPhoneNumber']")
	WebElement elePhoneNum;
	@FindBy(xpath="//input[@id='createLeadForm_primaryEmail']")
	WebElement eleEmail;
	
	public CreateLeadPages typeDataCN(String CN )
	{
		 type(eleCompanyName, CN);
		 return this;
		
		
	}
	public CreateLeadPages typeDataFN(String FN)
	{
		
		type(eleCompanyFN, FN);
		return this;
		
	}
	public CreateLeadPages typeDataLN(String LN)
	{
		
		type(eleCompanyLN, LN);
		return this;
		
	}
	public CreateLeadPages typeAreaCode(String AC)
	{
		type(eleAreaCode, AC);
		return this;
	}
	public CreateLeadPages typePhone(String PH)
	{
		type(elePhoneNum, PH);
		return this;
	}
	public CreateLeadPages typeEmail(String EM)
	{
		type(eleEmail, EM);
		return this;
	}
	
	public void clickCreateButton()
	{
		click(eleCreateButton);
	}
	
}
