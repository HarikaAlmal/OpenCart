package com.opencart.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.utility.Log;

public class HomePageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchApp(browserName);
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		productpage = new ProductPage();
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority = 1,groups = "Smoke")
	public void testvalidatOrderHistory() {
		
		Log.startTestCase("testvalidatOrderHistory");
		loginpage = indexpage.clickOnmyAccount();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		boolean result = homepage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("testvalidatOrderHistory");
	}
	
	@Test(priority = 2,groups = "Smoke")
	public void testSearchCamera() {
		
		Log.startTestCase("testSearchCamera");
		productpage = homepage.searchCamera();	
		//boolean result = productpage.productIsAvaliable();
		productpage.clickProduct();
		boolean result = productpage.productIsInStock();
		//Assert.assertTrue(result);
		Assert.assertTrue(result);
		Log.endTestCase("testSearchCamera");
	}
	


}
