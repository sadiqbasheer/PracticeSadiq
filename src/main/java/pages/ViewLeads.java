package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class ViewLeads extends WebDriverServiceImpl{
	
	public ViewLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className ="subMenuButtonDangerous")// not able to find element by class locator
	WebElement eleDeleteButton;
	@FindBy(xpath="//div[@class='frameSectionExtra']/a[1]")
	WebElement eleDuplicateButton;
	@FindBy(id="viewLead_companyName_sp")
	WebElement companyNameandID;
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	
	public void compareFirstNameFindLeadsViewLeads()
	{
		System.out.println("find:  "+firstName_FindLeads+" view    : "+firstName_View);
		System.out.println("find:  "+companyNameandId_View+" view    : "+leadId_FindLeads);
		int compareTo = firstName_FindLeads.compareTo(firstName_View);
		if(compareTo == 0)
		{
			System.out.println("First name is same in find leads and View leads page : FirstName = "+firstName_FindLeads);
		}
		else
		{
			System.out.println("First name is different in find leads and View leads page : FirstName = "+firstName_FindLeads);
		}
	}
	
	public void compareLeadIdFindLeadsViewLeads()
	{
		boolean contains = companyNameandId_View.contains(leadId_FindLeads);
		if(contains)
		{
			System.out.println("Lead Id is same in both find leads and View Leads pages: LeadId is :  "+leadId_FindLeads);
		}
		else
		{
			System.out.println("Lead Id is different in both find leads and View Leads pages: LeadId is :  "+leadId_FindLeads);
		}
	}
	public String getFirstName()
	{
		String attribute = eleFirstName.getAttribute("value");
		return attribute;
	}
	 public String getCompanyNameandId()
	 {
		 String attribute = companyNameandID.getAttribute("value");
		 return attribute;
	 }
	
	public DuplicateLeads clickDuplicateButton()
	{
		click(eleDuplicateButton);
		return new DuplicateLeads(driver,test);
	}
	
	public MyLeads clickDeleteButton()
	{
		click(eleDeleteButton);
		return new  MyLeads(driver, test);//want to return to find leads page
	}

	

	
}
