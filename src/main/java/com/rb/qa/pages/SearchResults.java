package com.rb.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rb.qa.base.TestBase;

public class SearchResults extends TestBase {
	JavascriptExecutor js;
	//public SearchResults()
	//{
	//super();
	//}
	public void searchbuses2(String Btype,String BP) throws InterruptedException
	{
		WebElement Bustype=driver.findElement(By.xpath("//label[@title='"+Btype+"' and @class='cbox-label']"));
		Bustype.click();
		System.out.println("clicked on bustype");

		//js.executeScript("window.scrollBy(0,500)"); 
		
		Thread.sleep(5000);
		WebElement BPbox=driver.findElement(By.xpath("//input[@placeholder='BOARDING POINT']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", BPbox);
		BPbox.click();
		System.out.println("clicked on Bpbox");
		Actions action = new Actions(driver);
		action.moveToElement(BPbox).perform();
		WebElement BPtextbox=driver.findElement(By.xpath("//input[@placeholder='BOARDING POINT' and @name='inpFilter']"));
		BPtextbox.sendKeys(BP);
		WebElement BoardingPoint=driver.findElement(By.xpath("//label[@title='"+BP+"' and @class='cbox-label']"));
		BoardingPoint.click();
		WebElement Primoclosebtn=driver.findElement(By.xpath("//i[@class='icon icon-close']"));
		Primoclosebtn.click();		
		WebElement ApplyBtn=driver.findElement(By.xpath("//div[@class='button btn-apply bp-apply']"));
		ApplyBtn.click();
		System.out.println("clicked on Apllybtn");
		
	}

	/*public void chepeastbus()
{
	WebElement Busesfound=driver.findElement(By.xpath("//div//span[@class='f-bold busFound']"));
	int totalnoofbuses=Integer.parseInt((Busesfound.getText().substring(0,3)));
	System.out.println(totalnoofbuses+"The type is");
	List<WebElement> allfares=driver.findElements(By.xpath("//div[@class='fare d-block']"));	
	System.out.println("before scroll the no of buses listed is:"+allfares.size());
	while(!(allfares.size()==totalnoofbuses))
	{
		System.out.println("The size now is"+allfares.size());
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> allfarestemp=driver.findElements(By.xpath("//div[@class='fare d-block']"));	
		allfares.addAll(allfarestemp);		
		System.out.println("real "+allfares.size());
	}

	for(WebElement e:allfares)
	{
		System.out.println(e.getText());
		//String Allfarestext = e.getText();
		//List<String> Allfarestext2=new ArrayList<String>();
		//Allfarestext2.add(Allfarestext.replaceAll("[^\\d]", ""));
		//System.out.println(Allfarestext2);
	}*/


	public void chepeastbus() throws InterruptedException
	{

		WebElement Busesfound=driver.findElement(By.xpath("//div//span[@class='f-bold busFound']"));
		int totalnoofbuses=Integer.parseInt((Busesfound.getText().substring(0,3)));
		System.out.println("The total num of bus displayed is"+totalnoofbuses);
		while(!(clickonfooter()))
		{
			js = (JavascriptExecutor)driver;	


		}

		WebElement footer=driver.findElement(By.xpath("//a[@class='footerDescLink']"));
		js.executeScript("arguments[0].scrollIntoView(true);",footer);
		footer.click();
		Thread.sleep(8000);
		List<WebElement> allfares=driver.findElements(By.xpath("//div[@class='fare d-block']"));

		for(WebElement e:allfares)
		{
			System.out.println(e.getText());
		}

	}
	public boolean clickonfooter()
	{
	
		WebElement footer=driver.findElement(By.xpath("//a[@class='footerDescLink']"));
		try
		{
		footer.click();
		}
			catch(Exception e)
			{
				return false;
			}
		return false;
		}
		
	}
