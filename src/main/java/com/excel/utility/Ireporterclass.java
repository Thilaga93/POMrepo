package com.excel.utility;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class Ireporterclass implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for(ISuite suite:suites)
		{
			String suitename=suite.getName();	
			Map<String,ISuiteResult> suiteresults=suite.getResults();
			for(ISuiteResult result:suiteresults.values())
			{
				ITestContext context=result.getTestContext();
				System.out.println("Capture all passed results " + suitename + " num of testcases" + context.getPassedTests().getAllResults());
				System.out.println("Capture all failed results " + suitename+ " num of testcases" + context.getFailedTests().getAllResults());
			}
		}
	}

}
