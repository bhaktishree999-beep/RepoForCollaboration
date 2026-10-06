package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.businessUtility.BaseClass;

public class ListenerUtility /*extends BaseClass*/ implements ITestListener,ISuiteListener {
	
	
	   ExtentTest test;
	   ExtentReports reports;
	   
	   String time = LocalDateTime.now().toString().replace(":", "_");
	 

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("onStart Executed - STARTED",true);
		
				//create object for ExtentSparkReporter class
				ExtentSparkReporter spark = new ExtentSparkReporter("./reports/report_"+suite.getName()+"_"+".html");
				
				//create object for ExtentReports class
				reports = new ExtentReports();
				
				//call attachReporter() and pass spark reference
				reports.attachReporter(spark);
				
				//call createTest() and store it
			// 	test = reports.createTest("Sample Test Report");
				test = reports.createTest(suite.getName()+"_"+time);		 
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("onFinish Executed - ENDED",true);
		
		reports.flush();
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess Executed - PASS",true);
		
		test.log(Status.PASS, "Test case pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("onTestFailure Executed - FAILED",true);
		
		
		        //create object for chrome driver class
				//WebDriver driver = new ChromeDriver();
				
				//typecast driver reference into TakesScreenshot reference
				TakesScreenshot ts = (TakesScreenshot) /*BaseClass.driver*/ BaseClass.sdriver;
				
				//call getScreenshotAs() and pass OutputType argument, store it
				File temp = ts.getScreenshotAs(OutputType.FILE);
				
				
				//create destination file path, create object for file class
			//	File dest = new File("./errorshots/img"+time+".png");
				File dest = new File("./errorshots/img_"+result.getMethod().getMethodName()+"_"+".png");
				
				//copy temp into dest
				try {
				FileHandler.copy(temp, dest);
	  }catch (IOException e) {
		e.printStackTrace();
	}
				//log message
			//	test.log(Status.FAIL, "Test case failed");
				test.log(Status.FAIL,result.getMethod().getMethodName());
				
				//attach screenshot to the Extent Report
				test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
				test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),result.getMethod().getMethodName());
	//			test.addScreenCaptureFromPath("./errorshots/img"+time+".png");
				
	}				
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped Executed - SKIPPED",true);
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}
}

