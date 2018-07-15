package tests;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class DemoReportCW {
	
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest testSuite, test;
	
	//@BeforeSuite
	public void startResult() {
		html = new ExtentHtmlReporter("./reports/results.html");
		//html.setAppendExisting(true);
		html.setAppendExisting(false);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(html);
	}
	
	//@BeforeClass
		public ExtentTest startTestCase(String testCaseName, String testDescription) {
			testSuite = extent.createTest(testCaseName, testDescription);
			return testSuite;
		}
		
	//@BeforeMethod
		public ExtentTest startTestModule(String nodes) {
			test = testSuite.createNode(nodes);
			return test;
		}

	
	//@AfterSuite
	public void endResult() {
		extent.flush();
	}
	
	public abstract long takeSnap();
public void reportSteps(String desc,String status) {
		
		MediaEntityModelProvider img = null;

		long snapNumber = 1000000L;

	
		try {
			snapNumber= takeSnap();
			
			img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".jpg").build();
		} catch (IOException e) {			
		}		

		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);		
		}else {
			test.info(desc);
		}
	}

}
	
	
	
	

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File file = new File("./reports/results.html");
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/results.html");
		//html.setAppendExisting(true);
		html.setAppendExisting(false);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(html);
		
		
		
		ExtentTest test = extent.createTest("TC_001", "Create test descriptiom");
		ExtentTest createTest = extent.createTest("TC_002");
		test.assignCategory("smoke test)");
		test.assignAuthor("BASHA");
		
		
		
		
		
		test.pass("the demo pass", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.fail("the data crms");
		test.pass("the login");
		test.warning("Display warining message");
		test.info("Info: Sprint 2");
		
		
		extent.flush();
	}

}
*/
/*public void startTestCase(String testcaseName, String testDesc, String node, String author, String category) {
testSuite = extent.createTest(testcaseName, testDesc);
test = extent.createTest(node);
test.assignCategory(category);
test.assignAuthor(author);
}*/
/*	public void reportStep(String desc, String status) {





if(status.equalsIgnoreCase("pass")) {
	try {
		test.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} else if(status.equalsIgnoreCase("fail")) {
	try {
		test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
*/