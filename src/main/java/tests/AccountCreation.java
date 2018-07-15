package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class AccountCreation extends WebDriverServiceImpl{
	
	@Test
	public void accountCreation(){
		
	
	WebElement eleUserName = locateElement("id", "username");
	type(eleUserName, "DemoSalesManager");
	
	WebElement elePassword = locateElement("id", "password");
	type(elePassword, "crmsfa");
	
	WebElement eleLogin = locateElement("class", "decorativeSubmit");
	click(eleLogin);
	
	WebElement eleCRM = locateElement("link", "CRM/SFA");
	click(eleCRM);
	
	WebElement eleAcc = locateElement("link","Accounts");
	click(eleAcc);
	
	WebElement eleCreate = locateElement("link","Create Account");
	click(eleCreate);
	
	WebElement eleInputAcc = locateElement("xPath","//td[@class='titleCell']/following-sibling::td/input");
	type(eleInputAcc,"MyAccSadiq99");
	
	WebElement eleInd = locateElement("name","industryEnumId");
	selectDropDownUsingValue(eleInd,"IND_AEROSPACE");
	
	WebElement elePreCur = locateElement("xPath","//select[@id='currencyUomId']");
	selectDropDownUsingValue(elePreCur,"AED");
	
	WebElement eleSrc = locateElement("id","dataSourceId");
	selectDropDownUsingValue(eleSrc,"LEAD_COLDCALL");
	
	WebElement eleMktCm = locateElement("id","marketingCampaignId");
	selectDropDownUsingValue(eleMktCm,"CATRQ_AUTOMOBILE");
	
	WebElement elePhone = locateElement("xPath","//input[@id='primaryPhoneNumber']");
	type(elePhone,"55566677");
	WebElement eleCity = locateElement("id","generalCity");
	type(eleCity,"Chennai");
	
	WebElement eleEmail = locateElement("xPath","//input[@id='primaryEmail']");
	type(eleEmail,"sadiq@gmail.com");
	
	
	WebElement eleCountry = locateElement("id","generalCountryGeoId");
	selectDropDownUsingValue(eleCountry,"IND");
	
	WebElement eleState = locateElement("xPath","//select[@id='generalStateProvinceGeoId']");
	selectDropDownUsingValue(eleState,"IN-AN");
	
	WebElement eleCreateAcc = locateElement("xPath","//input[@class='smallSubmit']");
	click(eleCreateAcc);
	
	WebElement eleAccIdTxt = locateElement("xPath","//td[@class='titleCell']/following::td");
	String AccTxt =  getText(eleAccIdTxt);
	int indexOf = AccTxt.indexOf("(");
	indexOf++;
	//System.out.println(indexOf);
	//String substring = AccTxt.substring(indexOf);
	int length = AccTxt.length();
	length--;
	//System.out.println(substring);
	String substring = AccTxt.substring(indexOf,length);
	System.out.println("company id :"+substring);
	//System.out.println(AccTxt.replaceAll("\\D", " "));
	
	WebElement eleFind = locateElement("xPath","//a[contains(.,'Find Accounts')]");
	click(eleFind);
	
	WebElement eleFindEle = locateElement("xPath","//label[contains(.,'Account ID:')]/following-sibling::div/input");
	type(eleFindEle,substring);
	
	WebElement eleFDBT = locateElement("xPath","//button[contains(.,'Find Accounts')]");
	click(eleFDBT);
	
	try {
		Thread.sleep(20);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement eleFi = locateElement("xPath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	String Str = getText(eleFi);
	boolean equals = Str.equals(substring);
	if(equals)
	{
		System.out.println("Record found");
	}
	else
	{
		System.out.println("Record not found");
	}
	
	
	closeActiveBrowser();
	
	
	}
}
