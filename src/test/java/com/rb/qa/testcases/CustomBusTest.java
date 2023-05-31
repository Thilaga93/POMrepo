package com.rb.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excel.utility.*;
import com.rb.qa.base.TestBase;
import com.rb.qa.pages.LoginPage;
import com.rb.qa.pages.SearchResults;
import com.rb.qa.pages.ryde;

import freemarker.log.Logger;

import com.rb.qa.pages.redrail;
//@Listeners(Listeners.class)
public class CustomBusTest extends TestBase {
	LoginPage loginpage=new LoginPage();
	SearchResults searchresults=new SearchResults();
	ryde ryde=new ryde();
	redrail redrail=new redrail();
Logger log=Logger.getLogger(CustomBusTest.class.getName());

	public CustomBusTest()
	{
		super();
	}
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception	{

		initialization();
		searchresults=loginpage.searchbuses(prop.getProperty("srccity"),prop.getProperty("destcity"));

	}
	@DataProvider
	public Iterator<String[]> getTestData()
	{
		ArrayList<String[]> testdata =TestUtil.gedatafromexcel();
		return testdata.iterator();
	}

	//@Test(dataProvider="getTestData")
	@Test
	@Parameters({"Btype","BP"})
	public void custombuses(String Btype,String BP) throws InterruptedException
	{

		System.out.println(Btype);
		System.out.println(BP);
		searchresults.searchbuses2(Btype,BP);
		//searchresults.chepeastbus();
	}
	@Test(groups= {"navigation"},dependsOnMethods={"printtext"})
	public void ride()
	{
		ryde.navigatetotryde();
		System.out.println("Navigated to Ryde");
		log.info("logger information Naviagted");
	}
	@Test(groups= {"navigation"},enabled=true)
	public void train()
	{
		redrail.navigatetoredrail();
		System.out.println("Navigated to Rail");
	}
	
	@Test(groups= {"navigation"})
	public void printtext()
	{
		System.out.println("this is test");
	}
	@AfterMethod (alwaysRun = true)
	public void Teardown()
	{
		driver.quit();
	}
}
