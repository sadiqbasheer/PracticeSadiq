package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl{
	public MyLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);

	}
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	@FindBy(linkText="Find Leads")
	WebElement eleFindLead;
	@FindBy(linkText="Merge Leads")
	WebElement eleMergedLead;
	
	public MergeLeadsPages clickMergeLeads()
	{
		click(eleMergedLead);
		return new MergeLeadsPages(driver, test);
	}
	public FindLeads clickFindLeads()
	{
		click(eleFindLead);
		return new FindLeads(driver, test);
	}
	
	

	public CreateLeadPages clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeadPages(driver, test);
	}
	 
	
}

