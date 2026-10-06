package com.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class is used to re run failed testcases for 3 times
 */

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int num  = 0;
	int upperlimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		
		if (num<upperlimit) {
			
			num++;
			return true;
		}
		return false;
	}

}
