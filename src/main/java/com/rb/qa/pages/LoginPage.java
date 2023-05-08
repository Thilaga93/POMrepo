package com.rb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rb.qa.base.TestBase;

public class LoginPage extends TestBase {
	SearchResults searchresults=new SearchResults();
	
	public LoginPage()
	{
	
		super();
	}
	//String monthyear;
	//String date;
	//@FindBy(id="src")
	//WebElement sourcecity;
	//@FindBy(id="dest")
	//WebElement destcity;
	//@FindBy(id="search_btn")
	//WebElement searchbusbtn;
	
	
	public SearchResults searchbuses(String srccity,String destcity)  {
		WebElement sourcecity=driver.findElement(By.xpath("//input[@id='src']"));
		sourcecity.sendKeys(srccity);
		WebElement	subsrccitydd=(driver.findElement(By.xpath("//li[(text()='Chennai')]")));
		System.out.println(subsrccitydd);
		subsrccitydd.click();
		WebElement destinationcity=driver.findElement(By.xpath("//input[@id='dest']"));
		destinationcity.sendKeys(destcity);
		WebElement	subdestcitydd=(driver.findElement(By.xpath("//li[(text()='Coimbatore')]")));
		subdestcitydd.click();
		onwarddateselection(prop.getProperty("monthyear"),prop.getProperty("date"));
		WebElement searchbusbtn=driver.findElement(By.xpath("//button[@id='search_btn']"));
		searchbusbtn.click();
		System.out.println(searchbusbtn);
		System.out.println("clicked on button");
		return searchresults;
		
	}
	public static void onwarddateselection(String monthyear,String date)
	{

		driver.findElement((By.xpath("//input[@id='onward_cal']"))).click();
		String currentdisplayedmonth=driver.findElement((By.xpath("//td[@class='monthTitle']"))).getText();
		System.out.println(currentdisplayedmonth);
		while(!(currentdisplayedmonth.equals(monthyear)))
		{
			driver.findElement((By.xpath("//td[@class='next']"))).click();
			currentdisplayedmonth=driver.findElement((By.xpath("//td[@class='monthTitle']"))).getText();
			
		}	
		driver.findElement((By.xpath("//td[contains(text(),'"+date+"')]"))).click();
	}


}
