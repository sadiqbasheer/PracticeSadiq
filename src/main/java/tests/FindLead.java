package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost1;
import lib.selenium.WebDriverServiceImpl;

public class FindLead extends PreAndPost1{
	
	//@Test(dependsOnMethods = "tests.CreateLead.createLead", description="InsideFindLead")
	//@Test(groups= {"smoke"})
	@Test

	public void findLead() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		/*WebElement eleUserName = locateElement("id","username");
		type(eleUserName,"DemoSalesManager");
		WebElement elePassWord = locateElement("id","password");
		type(elePassWord,"crmsfa");
		*/WebElement eleSubmit = locateElement("class","decorativeSubmit");
		click(eleSubmit);
		WebElement eleCRMLink = locateElement("link","CRM/SFA");
		click(eleCRMLink);
		// click on leads link
		WebElement eleLeadLink = locateElement("link", "Leads");
		click(eleLeadLink);
		//Click on Find Leads 
		WebElement eleFindLeadLink = locateElement("link","Find Leads");
		click(eleFindLeadLink);
		WebElement eleFN = locateElement("xPath","(//input[@name='firstName'])[3]");
		type(eleFN,"Sadiq");
		WebElement eleFindLeadBut = locateElement("xPath","//button[contains(.,'Find Leads')]");
		click(eleFindLeadBut);
		WebElement eleLeadIdList = locateElement("xPath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		wait.until(ExpectedConditions.elementToBeClickable(eleLeadIdList));
		//wait.until(ExpectedConditions.visibilityOf(eleLeadIdList));
		Thread.sleep(5000);
		String leadID = getText(eleLeadIdList);
		System.out.println("lead id is"+leadID);
		click(eleLeadIdList);
		//Click on Edit button
		WebElement eleEdit = locateElement("xPath","//div[@class='frameSectionExtra']/a[3]");
		click(eleEdit);
		WebElement eleCompanyName = locateElement("xPath","//input[@id='updateLeadForm_companyName']");
		type(eleCompanyName,"UpdatedCompany name");
		WebElement eleUpdateButton = locateElement("class","smallSubmit");
		click(eleUpdateButton);
		Thread.sleep(3000);
		//Error is reported when execution starts here, i have used same element eleCompanyName as well instead of declaring eleCompanyName1
		WebElement eleCompanyName1 = locateElement("id","viewLead_companyName_sp");
		
		// check for updated company name
		int compareTo = eleCompanyName1.getText().compareTo("UpdatedCompany name (11217)");
		String text = eleCompanyName1.getText();
		System.out.println(text);
		
		if (compareTo == 0)
		{
			System.out.println("update is successfull");
		}
		else
		{
			System.out.println("update is unsuccesfull");
		}
		
		// same compare functionality done in implementation level also
		verifyPartialText(eleCompanyName1, "UpdatedCompany");
	}

}
