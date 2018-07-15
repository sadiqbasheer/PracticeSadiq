package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;


public class DuplicateLeadBackup extends WebDriverServiceImpl{
	
	@Test
	public void duplicateLead() 
	{
		
		WebElement eleUserName = locateElement("id","username");
		type(eleUserName,"DemoSalesManager");
		WebElement elePassWord = locateElement("id","password");
		type(elePassWord,"crmsfa");
		WebElement eleSubmit = locateElement("class","decorativeSubmit");
		click(eleSubmit);
		WebElement eleCRMLink = locateElement("link","CRM/SFA");
		click(eleCRMLink);
		// click on leads link
		WebElement eleLeadLink = locateElement("link", "Leads");
		click(eleLeadLink);
		//Click on Find Leads 
		WebElement eleFindLeadLink = locateElement("link","Find Leads");
		click(eleFindLeadLink);
		//Click on email id
		WebElement eleEmailId = locateElement("xPath","(//em[@class='x-tab-left'])[3]/span/span");
		click(eleEmailId);
		WebElement eleEmailTB = locateElement("name","emailAddress");
		type(eleEmailTB,"sadiqbasheer@gmail.com");
		//click on find button
		WebElement eleFindBT = locateElement("xPath","//button[contains(., 'Find Leads')]");
		click(eleFindBT);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get the lead id and store
		WebElement eleLeadID = locateElement("xPath","//table[@class='x-grid3-row-table']/tbody/tr/td/div/a");
		String LeadId = eleLeadID.getText();
		//get the first name and store
		WebElement eleFN = locateElement("xPath","//table[@class='x-grid3-row-table']/tbody/tr/td[3]/div/a");
		String FirstName=eleFN.getText();
		//click on first name
		click(eleFN);
		//Click on duplicate lead button
		WebElement eleDupBT = locateElement("xPath","//div[@class='frameSectionExtra']/a[1]");
		click(eleDupBT);
		//Verifying the page title
		verifyExactTitle("Duplicate Lead | opentaps");
		//click on create lead button
		WebElement eleCreateBT = locateElement("class","smallSubmit");
		click(eleCreateBT);
		// get the first name from view lead page
		WebElement eleFNVL = locateElement("id","viewLead_firstName_sp");
		//String textFN = getText(eleFNVL);
		verifyExactText(eleFNVL,FirstName);
		closeActiveBrowser();
		//closeAllBrowsers();
	}

	
}
