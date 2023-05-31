package com.rb.qa.pages;

import com.rb.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ryde extends TestBase {
	
	/*public ryde()
	{
		super();
		
	}*/
	public void navigatetotryde()
	{
	 WebElement rydelink=driver.findElement(By.xpath("//a[@title='rYde']"));
	 rydelink.click();
	}

	
}
