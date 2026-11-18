package project.ApexGlobal.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT=3;
	
	@Override
	public boolean retry(ITestResult result){
		
		if(retryCount<MAX_RETRY_COUNT) {			
			retryCount++;			
			System.out.println("Retyring the test "+ result.getName()+"with status "+result.getStatus()+" for the"+retryCount+" 's time.");
			return true;
		}
		
		return false;
	}

}
