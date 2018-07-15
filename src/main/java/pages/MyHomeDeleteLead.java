package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyHomeDeleteLead extends WebDriverServiceImpl{
	
	public MyHomeDeleteLead(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Leads")
	WebElement eleCreateLead;
	
	public  FindLeads clickLead()
	{
		click(eleCreateLead);
		return new FindLeads(driver, test);
		
	}
}
