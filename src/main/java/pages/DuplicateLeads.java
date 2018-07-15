package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLeads extends WebDriverServiceImpl{
	public DuplicateLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class='smallSubmit']")
	WebElement eleCreateLead;
	public ViewLeads clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLeads(driver,test);
	}
}
