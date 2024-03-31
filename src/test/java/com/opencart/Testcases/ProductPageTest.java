/**
 * 
 */
package com.opencart.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;
import com.opencart.pageobjects.CheckoutPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.utility.Log;

/**
 * @author harik
 *
 */
public class ProductPageTest extends BaseClass {
	

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	CheckoutPage checkoutpage;
	
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
	
	
	@Test(groups = {"Sanity","Regression"})
	public void testaddToCart() {
	
		Log.startTestCase("testaddToCart");
		loginpage = indexpage.clickOnmyAccount();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		productpage = homepage.searchCamera();	
		productpage.clickProduct();
		productpage.addtoCart();
		boolean result = productpage.validateProductaddedTOCart();
		Assert.assertTrue(result);
		productpage.goToCart();
		Acts.implicitWait(getDriver(), 10);
		checkoutpage = productpage.viewCart();
		Log.endTestCase("testaddToCart");
	}

}
