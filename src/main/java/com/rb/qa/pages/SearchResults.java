package com.rb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rb.qa.base.TestBase;

public class SearchResults extends TestBase {
	//public SearchResults()
	//{
		//super();
	//}
public void searchbuses2(String Btype,String BP)
{
	WebElement Bustype=driver.findElement(By.xpath("//label[@title='"+Btype+"' and @class='cbox-label']"));
	Bustype.click();
	System.out.println("clicked on bustype");
	WebElement BPbox=driver.findElement(By.xpath("//input[@placeholder='BOARDING POINT']"));
	BPbox.click();
	System.out.println("clicked on Bpbox");
	WebElement BPtextbox=driver.findElement(By.xpath("//input[@placeholder='BOARDING POINT' and @name='inpFilter']"));
	BPtextbox.sendKeys(BP);
	WebElement BoardingPoint=driver.findElement(By.xpath("//label[@title='"+BP+"' and @class='cbox-label']"));
	BoardingPoint.click();
	WebElement ApplyBtn=driver.findElement(By.xpath("//div[@class='button btn-apply bp-apply']"));
	ApplyBtn.click();
	System.out.println("clicked on Apllybtn");
}
}
