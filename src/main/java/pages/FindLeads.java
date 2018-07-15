package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;
import tests.DemoReportCW;

public class FindLeads extends WebDriverServiceImpl{
	
	public FindLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='x-tab-strip x-tab-strip-top']/li[2]/a/em/span/span")
	WebElement elePhoneTab;
	@FindBy(xpath="(//table[@class='x-table-layout'])[5]/tbody/tr/td[2]/div/div/div/input")
	WebElement eleAreaCode;
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement elePhoneNum;
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindButton;
	@FindBy(xpath="//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")
	WebElement eleLeadIdLink;
	@FindBy(xpath="(//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder'])[8]/div/div/input")
	WebElement eleNameandID;
	@FindBy(linkText="Find Leads")
	WebElement eleFindLead;
	@FindBy(className="x-paging-info")// not able to find by class
	WebElement eleSearchResult;
	//click on email
	@FindBy(xpath="(//em[@class='x-tab-left'])[3]/span/span")
	WebElement eleEmailIdMenu;
	//email id text box
	@FindBy(name="emailAddress")
	WebElement eleEmailTB;
	//lead id link
	@FindBy(xpath="//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")
	WebElement eleSearchedLeadId;
	//First name
	@FindBy(xpath = "//table[@class='x-grid3-row-table']/tbody/tr/td[3]/div/a")
	WebElement eleFirstName;
	
	public String getFirstName()
	{
		String Fname = getText(eleFirstName);
		return Fname;
	}
	public String getLeadIdsearchedLeadId()// read the lead id
	{
		String LeadId = getText(eleSearchedLeadId);
		//String attribute = eleSearchedLeadId.getAttribute("value");
		//System.out.println(attribute);
		return LeadId;
	}
	
	public ViewLeads clickSearchedLeadId()// when we click on lead id link it shd navigate to viewleads page
	{
		click(eleSearchedLeadId);
		return new ViewLeads(driver, test);
	}
	public FindLeads typeEmailTB(String emailId)
	{
		type(eleEmailTB,emailId);
		return this;
	}
	
	public FindLeads clickEmailIdMenu()
	{
		click(eleEmailIdMenu);
		return this;
	}
	
	
	public FindLeads clickPhoneTab()
	{
		click(elePhoneTab);
		return this;
		
	}
	public FindLeads typeAreacode(String areaCode)
	{
		type(eleAreaCode,areaCode);
		return this;
	}
	public FindLeads typePhoneNum(String phonenum)
	{
		type(elePhoneNum,phonenum);
		return this;
	}
	public FindLeads clickFindBut()
	{
		click(eleFindButton);
		
		return this;
	}
	public String getLeadId()
	{
		return getText(eleLeadIdLink);
	}
	
	public ViewLeads clickLeadLink()// after clicking leadlink we will navigate to view lead page
	{
		click(eleLeadIdLink);
		return new ViewLeads(driver,test);
	}
	public FindLeads typeNameAndId(String data)
	{
		
		type(eleNameandID, data);
		return this;
		
	}
	public FindLeads clickFindLeadsLink()
	{
		click(eleFindLead);
		return this;
	}
	
	public FindLeads verifySearchMessage()
	{
		verifyExactText(eleSearchResult,"No records to display");
		return this;
	}
}
