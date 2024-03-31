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
import com.opencart.pageobjects.PaymentPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.utility.Log;

/**
 * @author harik
 *
 */
public class CheckoutPageTest extends BaseClass{
	

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	CheckoutPage checkoutpage;
	PaymentPage paymentpage;
	
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
	
	
	@Test(groups = "Regression")
	public void testCheckout() throws InterruptedException {
		Log.startTestCase("testCheckout");
		loginpage = indexpage.clickOnmyAccount();
		Log.info("--user is going to enter credentials--");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10);
		Log.info("--user is searching camera products--");
		productpage = homepage.searchCamera();
		Log.info("--click on product--");
		productpage.clickProduct();
		Log.info("--click on add to cart--");
		productpage.addtoCart();
		boolean result = productpage.validateProductaddedTOCart();
		Log.info("--validating product added to cart--");
		Assert.assertTrue(result);
		productpage.goToCart();
		Log.info("--moving to cart--");
		
		checkoutpage = productpage.viewCart();
		Log.info("--click on checkout--");
		paymentpage = checkoutpage.checkout();
		String paymentpageURL = getDriver().getCurrentUrl();
		Log.info("--verify user is in checkoutpage--");
		Assert.assertEquals(paymentpageURL, "http://localhost/opencart/upload/index.php?route=checkout/checkout");
		Log.endTestCase("testCheckout");
		
	}
	
	

}
