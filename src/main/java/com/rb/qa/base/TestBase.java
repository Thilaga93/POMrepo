package com.rb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
	
	public TestBase()
	{

		try
		{
			prop = new Properties();
			FileInputStream ip= new FileInputStream("C:/Users/Raja/eclipse-workspace/RBPOMtest/src/main/java/com/rb/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)

		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Raja\\Desktop\\chromedriver.exe");	
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.get(prop.getProperty("url"));
	}
}
}	


