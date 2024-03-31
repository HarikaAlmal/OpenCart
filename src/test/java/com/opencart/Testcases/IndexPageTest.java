package com.opencart.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchApp(browserName);
		indexpage = new IndexPage();
	} 

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void testValidateLogo() {
		
		Log.startTestCase("testValidateLogo");
		
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("testValidateLogo");
	}
	
	
	@Test(groups = "Smoke")
	public void testTitle() {
		
		Log.startTestCase("testTitle");
		String title = indexpage.getopencartTitle();
		Assert.assertEquals(title, "Your Store/");
		Log.endTestCase("testTitle");
	}
	
	
	
	
	
	
	
}
