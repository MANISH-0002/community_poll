package testnglisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count=0;
	int retrylimit=2;
	

	@Override
	public boolean retry(ITestResult result) {
		if(count<retrylimit) {
			System.out.println("Retrying test: " + result.getName() + " for the " + (count + 1) + " time.");
            count++;
			return true;
		}
		
		return false;
	}

}
