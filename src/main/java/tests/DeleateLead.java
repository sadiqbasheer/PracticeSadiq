package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost1;
import pages.FindLeads;
import pages.MyHome;
import pages.MyLeads;
import pages.ViewLeads;


public class DeleateLead extends PreAndPost1{
	//@Test(dependsOnMethods = "tests.CreateLead.createLead", alwaysRun = true)
	//@Test(groups="sanity")

	@BeforeTest
	public void setValue()
	{
		testCaseName = "DeleteLeadPages";
		testDesc = "Delete a existing lead";
		nodeName="Lead";
		author = "Basha";
		category = "Sprint1";
		excelFileName="DeleteLeadDataSheet";
	}

	@Test(dataProvider="test-delete")
	public void deleateLead(String Area, String Ph)
	{
		String data=new MyHome(driver,test)
				.clickLead()
				.clickFindLeads()
				.clickPhoneTab()
				.typeAreacode(Area)
				.typePhoneNum(Ph)
				.clickFindBut()
				.getLeadId();
				new FindLeads(driver,test).clickLeadLink();
				
				new ViewLeads(driver,test)
				.clickDeleteButton()
				.clickFindLeads()
				.typeNameAndId(data)
				.clickFindBut()
				.verifySearchMessage();
				
	}

}
/*WebElement eleUserName = locateElement("id","username");
		type(eleUserName,"DemoSalesManager");
		WebElement elePassWord = locateElement("id","password");
		type(elePassWord,"crmsfa");*/
/*WebElement eleSubmit = locateElement("class","decorativeSubmit");
		click(eleSubmit);
		WebElement eleCRMLink = locateElement("link","CRM/SFA");
		click(eleCRMLink);*/
// click on leads link
/*WebElement eleLeadLink = locateElement("link", "Leads");
		click(eleLeadLink);
		//Click on Find Leads 
		WebElement eleFindLeadLink = locateElement("link","Find Leads");
		click(eleFindLeadLink);
		//Click on phone tab
		WebElement ElePhoneTab = locateElement("xPath","//ul[@class='x-tab-strip x-tab-strip-top']/li[2]/a/em/span/span");
		click(ElePhoneTab);
		//Click on area code and type area code
		WebElement eleAreaCode = locateElement("xPath","(//table[@class='x-table-layout'])[5]/tbody/tr/td[2]/div/div/div/input");
		type(eleAreaCode,Area);
		//click on phone number and enter phone number
		WebElement elePhoneNum = locateElement("xPath","//input[@name='phoneNumber']");
		type(elePhoneNum,Ph);
		//Click on find leads button
		WebElement eleFindBT = locateElement("xPath","//button[contains(.,'Find Leads')]");
		click(eleFindBT);*/

/*//Get the lead id
		WebElement eleLeadID = locateElement("xPath","//table[@class='x-grid3-row-table']/tbody/tr/td/div/a");
		String LeadIDTxt = getText(eleLeadID);
		//click on first lead id
		click(eleLeadID);*/
//click on delete button
/*WebElement eleDelBT = locateElement("class","subMenuButtonDangerous");
		click(eleDelBT);
		//Need to verify the title of page
		verifyExactTitle("My Leads | opentaps CRM");
		if (verifyExactTitle)
		{
			System.out.println("we are in right page");
		}
		else
		{
			System.out.println("we are not in right page");
		}
		//Click on find menu to click on Findsleads sub menu item
		WebElement eleFindM = locateElement("link","Find Leads");
		click(eleFindM);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Enter lead id
		WebElement eleLeadIdSearch = locateElement("xPath","(//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder'])[8]/div/div/input");
		type(eleLeadIdSearch,LeadIDTxt);
		//click on find leads button
		WebElement eleFindlBTN = locateElement("xPath","//button[contains(.,'Find Leads')]");
		click(eleFindlBTN);
		//Check for the message post deletion
		WebElement eleMSG = locateElement("class","x-paging-info");
		verifyPartialText(eleMSG,"No records to display");*/



/*@DataProvider(name = "Test",indices=0)
	public String[][] inputData()
	{
		String[][] data = new String[2][2]; 
		data[0][0] = "44";
		data[0][1]="55566677";
		data[1][0] = "55";
		data[1][1] = "88899900";
		return data;

	}*/

