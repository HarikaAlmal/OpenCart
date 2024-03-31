package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Acts;
import com.opencart.base.BaseClass;

public class ProductPage extends BaseClass {
	
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Nikon D300']")
	WebElement nikonCamera;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Canon EOS 5D']")
	WebElement canonCamera;
	
	@FindBy(xpath = "//li[contains(text(),'In Stock')]")
	WebElement instock;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addtoCart;
	
	@FindBy(xpath = "//div[text()='Success: You have added ']")
	WebElement addedtocart;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement goToCart;
	
	
	@FindBy(xpath = "//p//a//i[@class='fa fa-shopping-cart']")
	WebElement viewCart;
	
	
	 
	
	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean productIsAvaliable() {
		return Acts.isDisplayed(getDriver(), nikonCamera);
	}
	
		
	public void clickProduct() {
		Acts.click(getDriver(), nikonCamera);
	}
	
	public boolean productIsInStock() {
		return Acts.isDisplayed(getDriver(), instock);
	}
	
	public void addtoCart() {
		Acts.click(getDriver(), addtoCart);
			
	}
	
	public boolean validateProductaddedTOCart() {
		return Acts.isDisplayed(getDriver(), addedtocart);
	}
	
	public void goToCart() {
		Acts.click(getDriver(), goToCart);
	} 
	
	public CheckoutPage viewCart() {
		Acts.click(getDriver(), viewCart);
		return new CheckoutPage();
	}
	
	
	
	

}
