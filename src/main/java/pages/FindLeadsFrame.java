package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeadsFrame extends WebDriverServiceImpl{
	public FindLeadsFrame(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class=' x-form-text x-form-field ']")
	WebElement eleLeadId;
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindButton;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	WebElement eleLeadIdLink;
	public MergeLeadsPages clickLeadIdLink()
	{
		click(eleLeadIdLink);
		switchToWindow(0);
		return new MergeLeadsPages(driver, test);
	}
	public FindLeadsFrame clickFindButton()
	{
		click(eleFindButton);
		return this;
	}
	public FindLeadsFrame typeLeadId(String leadId)
	{
		
		WebDriverWait obj = new WebDriverWait(driver, 20);
		obj.until(ExpectedConditions.visibilityOfAllElements(eleLeadId));
		type(eleLeadId,leadId);
		return this;
	}
}
