package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class DeleateLeadListen implements IAnnotationTransformer, IRetryAnalyzer {

	int max=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()& max<2)
		{
			max++;
			return true;
		}
		
		return false;
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("deleateLead"))
		{
			annotation.setInvocationCount(1);
			annotation.setDescription("Find Leads execution report");
			String dataProvider = annotation.getDataProvider();
			System.out.println("Data provider name is :  "+dataProvider);
			
		
	}

}
}
