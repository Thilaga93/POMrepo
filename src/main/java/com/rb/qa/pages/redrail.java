package com.rb.qa.pages;

import com.rb.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class redrail extends TestBase {

	/*public redrail()
	{
		super();
		
	}*/
	public  void navigatetoredrail()
	{
	 WebElement redraillink=driver.findElement(By.xpath("//a[@title='redRail']"));
	 redraillink.click();
	}


}
