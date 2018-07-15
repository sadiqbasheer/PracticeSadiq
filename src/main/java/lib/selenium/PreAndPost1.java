package lib.selenium;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import tests.data.ReadExcelCL;
import tests.data.ReadExcelDelete;

public class PreAndPost1 extends WebDriverServiceImpl {
	
	public String testCaseName,category,author,excelFileName;
	public String testDesc,nodeName;
 
	
	//@BeforeMethod(groups= {"smoke","sanity"})
	@BeforeMethod
	@Parameters({"url","username","password"})
  public void beforeMethod(String myurl, String myusername, String mypassword) {
		startTestModule(nodeName);
		test.assignAuthor(author);
		test.assignCategory(category);
		//Call to reports
		
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		
		driver.manage().window().maximize();
		//driver.get("https://www.flipkart.com/");
		driver.get(myurl);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, myusername);
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, mypassword);
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		

  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  startTestCase(testCaseName,testDesc);
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  startResult();
  }

  @AfterSuite
  public void afterSuite() {
	  endResult();
  }
  

  
	//@DataProvider(name="test", indices= {0})
	@DataProvider(name="test", indices= {1})
		public String[][] getData() throws IOException
		{
		
			ReadExcelCL excel = new ReadExcelCL();
			
				return excel.readExcel(excelFileName);
				
		
			//return data;
			/*String[][] data = new String[2][6];
			data[0][0] = "My company";
			data[0][1] = "Sadiq";
			data[0][2] = "Basha";
			data[0][3] = "44";
			data[0][4] = "55566677";
			data[0][5] = "sadiqbasheer@gmail.com";
			data[1][0] = "New Company";
			data[1][1] = "New-Sadiq";
			data[1][2] = "New-Basha";
			data[1][3] = "44";
			data[1][4] = "55566677";
			data[1][5] = "sadiqbasheer@gmail.com";*/
		}
	@DataProvider(name="test-delete")
	
		public String[][] getDataDelete() throws IOException
		{
			ReadExcelDelete excel = new ReadExcelDelete();
			return excel.readData(excelFileName);
			
		}
	
	@DataProvider(name="test-DuplicateLead")
	
	public String[][] getDataDuplicateLead() throws IOException
	{
		ReadExcelDelete excel = new ReadExcelDelete();
		return excel.readData(excelFileName);
		
	}
	
	@DataProvider(name = "test-MergeLead")
	public String[][] getDataMergeLead() throws IOException
	{
		ReadExcelDelete excel = new ReadExcelDelete();
		return excel.readData(excelFileName);	
	}
	
	

}
