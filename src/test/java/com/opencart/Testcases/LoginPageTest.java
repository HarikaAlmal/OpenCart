package com.opencart.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.dataprovider.DataProviders;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.utility.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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

	//@Test(dataProvider = "Credentials",dataProviderClass = DataProviders.class)
	@Test(groups = {"Smoke","Sanity"})
	//public void testLogin(String username,String password) {
	public void testLogin() {
		
		Log.startTestCase("testLogin");
		loginpage = indexpage.clickOnmyAccount();
		//below line to read data from config properties file
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//dataprovider to read data from excel
		//homepage = loginpage.login(username,password);
		Log.endTestCase("testLogin");
		
		
	}
	
}
