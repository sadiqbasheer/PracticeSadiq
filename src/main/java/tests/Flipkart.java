package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Flipkart extends WebDriverServiceImpl {
	
	@Test
	public void flipkart() throws InterruptedException
	{
		//press esc button in keyboard to close login window
		pressEscButton();
		Actions driver1 = new Actions(driver);
		
		//mouse over TV&appliances
		WebElement eleTV = locateElement("xPath","//a[@title='TVs & Appliances']");
		driver1.moveToElement(eleTV).perform();
		
		// web driver wait object created to implicit wait for web objects
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		// click on samsung link 
		WebElement eleSum = locateElement("xPath","(//span[text()='Samsung'])[2]");
		
		// introduce wait from webdriver since samsumg object is taking time to load
		wait.until(ExpectedConditions.visibilityOf(eleSum));
		
		//click on samsung link
		click(eleSum);
		
		//select min &max range value
		WebElement eleMin = locateElement("xPath","//div[@class='_1qKb_B']/select");
		selectDropDownUsingValue(eleMin,"20000");
		
		WebElement eleMax = locateElement("xPath","//div[@class='_1YoBfV']/select");
		selectDropDownUsingValue(eleMax,"60000");
		
		//select screen size drop down
		WebElement eleSize = locateElement("xPath","//div[text()='Screen Size']");
		//wait.until(ExpectedConditions.visibilityOf(eleSize));
		wait.until(ExpectedConditions.elementToBeClickable(eleSize));
		
		click(eleSize);
		
		//Select the size
		WebElement eleSizeSel = locateElement("xPath","//div[text()='48 - 55']");
		//wait.until(ExpectedConditions.visibilityOf(eleSizeSel));
		wait.until(ExpectedConditions.elementToBeClickable(eleSizeSel));
		click(eleSizeSel);
		
		
		//click on first element
		WebElement eleFirstPro = locateElement("xPath","//div[text()='Samsung Series 6 123cm (49 inch) Full HD Curved LED Smart TV']");
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(eleFirstPro));
		click(eleFirstPro);
		
		//Switch to new window
		switchToWindow(1);
		
		// get the price in new window
		WebElement elePriceNew = locateElement("xPath","//div[text()='₹59,999']");
		//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		wait.until(ExpectedConditions.visibilityOf(elePriceNew));
		String newPrice = getText(elePriceNew);
		Thread.sleep(3000);
		
		//close new window
		closeActiveBrowser();
		switchToWindow(0);
		//get the price in old window
		WebElement elePriceOld = locateElement("xPath","//div[text()='₹59,999']");
		String oldPrice = getText(elePriceOld);
		System.out.println("new price:  "+newPrice);
		System.out.println("old price:  "+oldPrice);
		
		//click on add to compare 1st pro
		WebElement eleAddCom1 = locateElement("xPath","//span[text()='Add to Compare']");
		click(eleAddCom1);
		
		//Click on add to compare 2nd pro
		WebElement eleAddCom2 = locateElement("xPath","(//label[@class='_10TB-Q']/span)[2]");
		click(eleAddCom2);
		
		//Click on compare button
		WebElement eleCompare = locateElement("xPath","//span[@class='G934d8']/span");
		click(eleCompare);
		
		//get the price of first element
		WebElement eleFirstPP = locateElement("xPath","(//div[@class='_1vC4OE'])[1]");
		String price1 = getText(eleFirstPP);
		String replaceAll = price1.replaceAll("[₹,]", "");
		int parseInt1 = Integer.parseInt(replaceAll);
		
		//get the price of second element
		WebElement eleSecondPP = locateElement("xPath","(//div[@class='_1vC4OE'])[2]");
		String price2 = getText(eleSecondPP);
		String replaceAll2 = price2.replaceAll("[₹,]", "");
		int parseInt2 = Integer.parseInt(replaceAll2);
		
		System.out.println("product1 price:  "+parseInt1+"  product2 price:  "+parseInt2);
		
		if(parseInt1<parseInt2)
		{
			System.out.println("lowest price is : "+parseInt1 );
		}
		else
		{
			System.out.println("lowest price is : "+parseInt2);
		}
		closeActiveBrowser();
	}

}
