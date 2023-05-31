package com.rb.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rb.qa.base.TestBase;
import com.rb.qa.pages.LoginPage;
import com.rb.qa.pages.SearchResults;

public class LoginTest extends TestBase{
	LoginPage loginpage = new LoginPage();
	SearchResults searchresults=new SearchResults();
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()	{
		
		initialization();	
	}
	@Test(priority=1)
	public void searchtest() throws Exception
{
		searchresults=loginpage.searchbuses(prop.getProperty("srccity"),prop.getProperty("destcity"));
		System.out.println("End of Test case 1");
}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}

}
