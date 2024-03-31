package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id = "input-email")
	WebElement email;
	
	@FindBy(id = "input-password")
	WebElement pwd;
	
	@FindBy(css = "input.btn")
	WebElement loginsubmit;  
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public HomePage login(String username,String password) {
		Acts.type(email,username);
		Acts.type(pwd, password);
		Acts.click(getDriver(), loginsubmit);
		return new HomePage();
	}
		
	
	

}
