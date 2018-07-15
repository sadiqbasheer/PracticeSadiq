package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost1;
import pages.MyHome;

public class CreateLead extends PreAndPost1{
	
	  
	
	//@Test(invocationCount = 1,timeOut = 3000)
	//@Test(groups= {"smoke"})
	//@BeforeTest
	  
	@BeforeTest
	  public void setValue()
	  {
		  testCaseName = "CreateLeadPages";
		  testDesc = "create a new lead";
		  nodeName="Lead";
		  author = "sarath";
		  category = "sanity";
		  excelFileName="CreateLeadDataSheet";
	  }
	

	@Test(dataProvider= "test"/*, invocationCount=2, groups= {"smoke"}*/)
	
	public void createLead(String CN, String FN, String LN, String AC, String PH, String EM) {
		
		new MyHome(driver, test)
		.clickLead()
		.clickCreateLead()
		.typeDataCN(CN)
		.typeDataFN(FN)
		.typeDataLN(LN)
		.typeAreaCode(AC)
		.typePhone(PH)
		.typeEmail(EM)
		.clickCreateButton();
		
		
		
		
		/*WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		*/
		
		
		
/*		WebElement eleLocator = locateElement("link", "Create Lead");
		click(eleLocator);
		
		WebElement eleCompanyName = locateElement("id","createLeadForm_companyName");
		type(eleCompanyName, CN);
		
		
		
		WebElement eleFN = locateElement("id","createLeadForm_firstName");
		type(eleFN, FN);
		
		WebElement eleLN = locateElement("id","createLeadForm_lastName");
		type(eleLN,LN);*/
		
		/*WebElement eleAreaCode = locateElement("xPath","//input[@id='createLeadForm_primaryPhoneAreaCode']");
		type(eleAreaCode,AC);*/
		
		/*WebElement elePhone = locateElement("xPath","//input[@id='createLeadForm_primaryPhoneNumber']");
		type(elePhone,PH);
		
		WebElement eleEmail = locateElement("xPath","//input[@id='createLeadForm_primaryEmail']");
		type(eleEmail,EM);*/
		
		/*WebElement eleSubmit = locateElement("class","smallSubmit");
		click(eleSubmit);*/
		
		closeActiveBrowser();
	}
	
	
}




