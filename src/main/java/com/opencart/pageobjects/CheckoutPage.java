package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;

public class CheckoutPage extends BaseClass{
	
	
	
	
	@FindBy(xpath = "//input[@name='quantity[6]']")
	WebElement quantity;
	
	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement checkout;
	
	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String count) {
		Acts.type(quantity, count);
		
	}
	
	
	public PaymentPage checkout() {
		Acts.click(getDriver(), checkout);
		return new PaymentPage();
	}
	
	

}
