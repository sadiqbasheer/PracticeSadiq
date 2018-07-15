package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{
	
	public static Select mySelect;
	public static String Text;
	public static String leadId_FindLeads,firstName_FindLeads,companyNameandId_View,firstName_View;
	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));
			case "xPath" : return driver.findElement(By.xpath(locValue));
			case "name" : return driver.findElement(By.name(locValue));

			default:
				break;
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Element does not exist"+locator+ ": Locator is missing"+locValue+" cannot pass the value to locator specified" );
		}
		finally
		{
			//System.out.println("Snap shot taken");
			//takeSnap();
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			
			ele.sendKeys(data);
			reportSteps("the data entered value successfully:  "+ data, "Pass");
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		takeSnap();
	}

	public void click(WebElement ele){
		try {
			WebDriverWait obj = new WebDriverWait(driver, 20);
			obj.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
			//System.out.println("Web element exits: "+ele);
			reportSteps("Web element clicked successfully", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//	reportSteps("the ele not clicked successfully", "Fail");
			System.err.println("Web element does not exits :"+ ele);
		}
		finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		
		try {
			Text= ele.getText();
			reportSteps("Text received", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("WebElement missing : "+ele);
		}
		finally {
			takeSnap();
		}
		return Text;
		
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		mySelect=new Select(ele);
		mySelect.selectByVisibleText(value);
			
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		mySelect = new Select(ele);
		try {
			mySelect.selectByValue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("the element: "+ele+ " is not able to select the drop down value: "+ value);
		}
				

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		

		


	}

	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		String pageTitle = driver.getTitle();
		int compareTo = pageTitle.compareTo(expectedTitle);
		if (compareTo == 0)
		{
			System.out.println("we are in expected page with page title:"+ expectedTitle);
			return true;
		}
		else
		{
			System.out.println("we are in page :"+pageTitle +"Expected page is :  "+expectedTitle);
			return false;
		}

	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub

		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String text = ele.getText();
	
		if (text.equals(expectedText))
		{
			System.out.println("Both the string match each other: "+text);
		}
		else
		{
			System.out.println("Both the string mismatch: "+ text);
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String text = ele.getText();
		boolean contains = text.contains(expectedText);
		if (contains)
		{
			System.out.println("String :"+expectedText+" is present in :"+text);
		}
		else
		{
			System.out.println("String :"+expectedText+" is not present in :"+text);
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		
		// TODO Auto-generated method stub
		//driver.unregister(this);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> myList = new ArrayList<String>();
		myList.addAll(windowHandles);
		try {
			driver.switchTo().window(myList.get(index));
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("Window index passed is invalid index value: "+ index);
		}	catch(WebDriverException e3) {
			e3.printStackTrace();
			
			} 
		
		//driver.register(this);
		System.out.println(driver.getTitle());
		//maximize second window
		driver.manage().window().maximize();
}


public void switchToFrame(WebElement ele) {
	// TODO Auto-generated method stub

}

public void acceptAlert() {
	// TODO Auto-generated method stub
	Alert alert = driver.switchTo().alert();
	alert.accept();

}

public void dismissAlert() {
	// TODO Auto-generated method stub

}

public String getAlertText() {
	// TODO Auto-generated method stub
	return null;
}

public void closeActiveBrowser() {
	// TODO Auto-generated method stub
	driver.close();

}

public void closeAllBrowsers() {
	// TODO Auto-generated method stub
	driver.quit();

}

@Override
public void pressEscButton() {
	// TODO Auto-generated method stub
	driver.getKeyboard().sendKeys(Keys.ESCAPE);
	
}

}
