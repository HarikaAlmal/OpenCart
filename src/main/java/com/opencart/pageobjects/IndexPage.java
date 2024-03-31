package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//img[@class='img-responsive' and @title='Your Store']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;
	
		
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginbtn;
	 
	@FindBy(xpath = "//a[(text()='Cameras')]")
	WebElement camera;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnmyAccount() {
		myAccount.click();
		Acts.click(getDriver(),loginbtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Acts.isDisplayed(getDriver(),logo);
	}
	
	public String getopencartTitle() {
		return Acts.getTitle(getDriver());
		
	}
	
	public ProductPage searchCamera() {
		Acts.click(getDriver(), camera);
		return new ProductPage();
	}
	
	

}
