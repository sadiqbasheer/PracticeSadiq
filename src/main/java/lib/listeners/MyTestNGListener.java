package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class MyTestNGListener implements IAnnotationTransformer,IRetryAnalyzer{
	int maxCount=1;
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(this.getClass());
		
		if(testMethod.getName().equals("createLead"))//changed my method name instead of Class name
		{
			//annotation.setTimeOut(10);
			annotation.setInvocationCount(1);
			//annotation.setEnabled(false);//to ensure nothing is run
			int invocationCount = annotation.getInvocationCount();// to find the invocation count provided in class
			System.out.println("invocation count : "+ invocationCount);
			String[] groups = annotation.getGroups();//to find group name and list 
			System.out.println("Groups: "+ groups[0]);
			
			
		}
		
		if(testMethod.getName().equals("DeleateLead"))
		{
			annotation.setEnabled(false);
			
		}
	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(!result.isSuccess() & maxCount<2)
		{
			maxCount++;
			return true;
		}
		return false;
	}

}
