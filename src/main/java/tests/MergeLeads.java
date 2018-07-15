package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost1;
import lib.selenium.WebDriverServiceImpl;
import pages.FindLeadsFrame;
import pages.MyHome;

public class MergeLeads extends PreAndPost1{
	
	@BeforeTest
	public void setValue()
	{
		testCaseName = "Merge Leads Pages";
		testDesc = "Create Merge leads";
		nodeName = "Merge Lead";
		author = "sadiq";
		category = "smoke";
		excelFileName = "MergeLeadDataSheet";
	}
	
	//@Test(enabled=false)
	//@Test(groups="sanity")
	@Test(dataProvider="test-MergeLead"/* invocationCount=2*/)
	public void merge(String LD1, String LD2)
	{
		System.out.println("ld1:  "+LD1+"  ld2:"+LD2);
		new MyHome(driver,test)
		.clickLead()
		.clickMergeLeads()
		.clickLeadId1Img()
		.typeLeadId(LD1)
		.clickFindButton()
		.clickLeadIdLink()
		.clickLeadId2Img()
		.typeLeadId(LD2)
		.clickFindButton()
		.clickLeadIdLink()
		.clickMergeButton();
	}
}
		/*WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleLocator = locateElement("link", "Create Lead");
		click(eleLocator);
		//Click on merge leads
		WebElement eleMerge = locateElement("link","Merge Leads");
		click(eleMerge);
		//click on from leads
		WebElement eleFromLD = locateElement("xPath","//input[@id='partyIdFrom']/following::a");
		click(eleFromLD);
		//set new window and maximize
		switchToWindow(1);
		//click on lead id
		WebElement eleLeadId1 = locateElement("xPath","//label[contains(.,\"Lead ID:\")]/following-sibling::div/input");
		type(eleLeadId1,LD1);
		//click on find
		WebElement eleFindBT1 = locateElement("xPath","//button[contains(.,\"Find Leads\")]");
		click(eleFindBT1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("ld1 ...............  "+LD1);
		WebElement eleleadidLK = locateElement("link","11291");
		click(eleleadidLK);
		switchToWindow(0);
		WebElement eleToLead = locateElement("xPath","//input[@id='partyIdTo']/following-sibling::a/img");
		click(eleToLead);
		switchToWindow(1);
		WebElement eleLead = locateElement("xPath","//div[@class='x-form-clear-left']/preceding::input");
		type(eleLead,LD2);
		WebElement eleFind = locateElement("xPath","//button[contains(.,\"Find Leads\")]");
		click(eleFind);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click 
		WebElement eleLeadidLK2 = locateElement("link",LD2);
		click(eleLeadidLK2);
		switchToWindow(0);
		WebElement eleLink2 = locateElement("link","Merge");
		click(eleLink2);
		acceptAlert();
		WebElement eleFindMenu = locateElement("link","Find Leads");
		click(eleFindMenu);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click o lead id in find leads 
		WebElement eleLeadId;
		try {
			eleLeadId = locateElement("xPath","//input[@class=' x-form-text x-form-field ']");
			type(eleLeadId,LD1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click on find button
		WebElement eleBut = locateElement("xPath","//button[text()='Find Leads']");
		click(eleBut);
		//WebElement eleFindLead = locateElement("xPath","//label[contains(.,\\\"Lead ID:\\\")]/following-sibling::div/input");
		//type(eleFindLead,LD1);
		//WebElement eleFBtn = locateElement("xPath","//button[contains(.,\\\"Find Leads\\\")]");
		//click(eleFBtn);
		WebElement eleInfo = locateElement("class","x-paging-info");
		verifyPartialText(eleInfo,"No records");
		closeActiveBrowser();
		closeAllBrowsers();
		
	}
	@DataProvider(name="TestData", indices=0)
	public String[][] data()
	{
		String[][] Leadid= new String[1][2];
		Leadid[0][0] = "11291";
		Leadid[0][1] = "11300";
		return Leadid;
	}
*/
