package com.rb.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.*;
import com.rb.qa.base.TestBase;
import com.rb.qa.pages.LoginPage;
import com.rb.qa.pages.SearchResults;

public class CustomBusTest extends TestBase {
	LoginPage loginpage=new LoginPage();
	SearchResults searchresults=new SearchResults();
	
	
	public CustomBusTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()	{
		
		initialization();
		searchresults=loginpage.searchbuses(prop.getProperty("srccity"),prop.getProperty("destcity"));
		
	}
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testdata =TestUtil.gedatafromexcel();
		return testdata.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void custombuses(String Btype,String BP)
	{
		
		System.out.println(Btype);
		System.out.println(BP);
		searchresults.searchbuses2(Btype,BP);
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
}
