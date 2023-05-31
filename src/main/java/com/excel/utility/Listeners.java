package com.excel.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.rb.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Log;



public class Listeners extends TestBase implements ITestListener,IReporter{
	GeneralUtil generalutil=new GeneralUtil();
	ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("extent.html");
	ExtentReports extent = new ExtentReports();

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String output) {

		extent.attachReporter(htmlreporter);
		for (ISuite suite : suites) {
			System.out.println("The current suite name is "+suite);
			Map<String, ISuiteResult> result = suite.getResults();
			System.out.println("The suite result is "+result);
			for (ISuiteResult r : result.values()) {
			
				ITestContext context = r.getTestContext();
				System.out.println("The context "+context);
				try {
					buildTestNodes(context.getPassedTests(), Status.PASS);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The passed testst "+context.getPassedTests());
				try {
					buildTestNodes(context.getFailedTests(), Status.FAIL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The failed testst "+context.getFailedTests());
				try {
					buildTestNodes(context.getSkippedTests(), Status.SKIP);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The skipped testst "+context.getSkippedTests());
			}
		}

		extent.flush();

	}
	private void buildTestNodes(IResultMap tests, Status status) throws IOException, Exception {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName(),"TestDesc can be provided");

				//test.setStartedTime(getTime(result.getStartMillis()));
				//test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
					test.addScreenCaptureFromPath(generalutil.takeSnapShot(driver,"/Users/Raja/eclipse-workspace/RBPOMtest/test-output/"));
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed!!!");
				}



			}
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("I'm coming from"+result);
	}	

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Failed Test");
		try {
			generalutil.takeSnapShot(driver,"/Users/Raja/eclipse-workspace/RBPOMtest/test-output/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
