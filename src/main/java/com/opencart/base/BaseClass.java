package com.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.opencart.actiondriver.Acts;
import com.opencart.utility.ExtentManager;
import com.opencart.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
	public static Properties prop;
	//----this belowline---
	//public static WebDriver driver;
	//------or-------below
	//threadlocal driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		//get driver from threadlocalmap
		return driver.get();
	}
	//------till here------
	
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(fis);
			System.out.println("driver: "+driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public void launchApp(String browserName) {
		
		//instead of threadlocal
		//WebDriverManager.chromedriver().setup();
		
		//to get browser from config properties file below line
		//String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			
			//----driver = new ChromeDriver();----
			//set broswer to threadlocalmap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			//------driver = new FirefoxDriver();
			//set broswer to threadlocalmap
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//----driver = new InternetExplorerDriver();
			//set broswer to threadlocalmap
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Acts.implicitWait(getDriver(),10);
		Acts.pageLoadTimeOut(getDriver(),30);
		
		getDriver().get(prop.getProperty("uri"));
		
		
	}
	
	
	@AfterSuite(alwaysRun=true)
	
	public void afterSuite() {
		Log.info("inside aftersuite");
		System.out.println("im here6");
		ExtentManager.endReport();
		System.out.println("im here7");
	}
	
	
	
	

}
