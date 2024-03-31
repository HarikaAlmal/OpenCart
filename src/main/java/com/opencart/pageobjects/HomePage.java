package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;

public class HomePage extends BaseClass {
	
	
	
	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Order History']")
	WebElement orderhistory;
	
	@FindBy(xpath ="//a[text()='Cameras']")
	WebElement camera;
	
	@FindBy(xpath = "//aside//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement logoutconfirm; 
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean validateOrderHistory() {
		return Acts.isDisplayed(getDriver(), orderhistory);
	}
	
	public ProductPage searchCamera() {
		Acts.click(getDriver(), camera);
		return new ProductPage();
	}
	 
	public LogoutPage logout()
	{
		Acts.click(getDriver(), logout);
		Acts.click(getDriver(), logoutconfirm);
		return new LogoutPage();
	}
	

}
