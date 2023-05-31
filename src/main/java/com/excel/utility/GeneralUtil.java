package com.excel.utility;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GeneralUtil {
	public String takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		fileWithPath=fileWithPath+"ss.jpg";
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
return fileWithPath;
	}
	//public void explicitwait(){
	//WebDriverWait wait = new WebDriverWait((); 
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")))
	//}

	//Another example  of explicitwait()
	public static void clickOn(WebDriver driver, WebElement element, Duration timeout) {
	WebDriverWait wait=	new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public static void sendKeys(WebDriver driver, WebElement element, Duration timeout,String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

}

