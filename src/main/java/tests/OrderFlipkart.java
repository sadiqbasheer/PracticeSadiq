package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class OrderFlipkart extends WebDriverServiceImpl{
	
	@Test
	public void order()
	{
		//press esc button in keyboard to close login window
		pressEscButton();
				
		// web driver wait object created to implicit wait for web objects
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Actions driver1 = new Actions(driver);
		
		//mouse over TV&appliances
		WebElement eleTV = locateElement("xPath","//a[@title='TVs & Appliances']");
		driver1.moveToElement(eleTV).perform();
		// click on samsung link 
		WebElement eleSum = locateElement("xPath","(//span[text()='Samsung'])[2]");
		click(eleSum);
		WebElement elePro = locateElement("xPath","(//div[@class='_3wU53n'])[2]");
		click(elePro);
		
		//switch to new window
		switchToWindow(1);
		
		//get the view details 
		WebElement eleView = locateElement("xPath","//span[@class='_3yGtFA']");
		click(eleView);
		
		//switch to window
		switchToWindow(1);
		WebElement eleBut = locateElement("xPath","//button[@class='_2AkmmA _2Rr3iH']");
		click(eleBut);
		
		//click on view plans
		WebElement elePlan = locateElement("xPath","//span[@class='uD4D24']");
		click(elePlan);
		switchToWindow(1);
		WebElement eleStan = locateElement("xPath","//div[text()='STANDARD EMI']");
		click(eleStan);
		
		//click on citibank
		WebElement eleCiti = locateElement("xPath","//div[text()='Citibank']");
		click(eleCiti);
		//expand 24 moths EMI
		WebElement eleXpan = locateElement("xPath","(//div[@class='_1IYGYQ col col-1-12 _2T0KN5'])[2]/following::div");
		click(eleXpan);
		
		//get the emi text
		WebElement eleInt = locateElement("xPath","(//div[@class='col-3-12 tX0Os4'])[2]");
		String text2 = getText(eleInt);
		
		String intertt = text2.replaceAll("\\D", "");
		System.out.println("interest : "+ intertt);
		
	}

}
