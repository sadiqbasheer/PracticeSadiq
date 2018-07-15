package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class MergeListener implements IAnnotationTransformer,IRetryAnalyzer{
	public int maxCount = 1;
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("merge"))
		{
			annotation.setInvocationCount(1);
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
