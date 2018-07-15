package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MergeLeadsPages extends WebDriverServiceImpl {
	public MergeLeadsPages(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@id='partyIdFrom']/following::a")
	WebElement eleLeadId1;
	@FindBy(xpath="//input[@id='partyIdTo']/following-sibling::a/img")
	WebElement eleLeadId2;
	@FindBy(xpath="//a[text()='Merge']")
	WebElement eleMergeButton;
	
	public MergeLeadsPages clickMergeButton()
	{
		click(eleMergeButton);
		acceptAlert();
		return this;
	}
	public FindLeadsFrame clickLeadId2Img()
	{
		click(eleLeadId2);
		switchToWindow(1);
		return new FindLeadsFrame(driver, test);
	}
	
	public FindLeadsFrame clickLeadId1Img()
	{
		click(eleLeadId1);
		switchToWindow(1);
		return new FindLeadsFrame(driver, test);
	}

}
