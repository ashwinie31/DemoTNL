package com.tutorialsninja.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;


public class HeadersSection {
	
	public HeadersSection() {
		
		PageFactory.initElements(Base.driver,this);
		
		}
	
	
	@FindBy(xpath="/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	public static WebElement myAccountLink;
	
	@FindBy(linkText="Register")
	public static WebElement Register;

	
	@FindBy(linkText="Login")
	public static WebElement Login;
	
	@FindBy(name="search")
	public static WebElement searchBoxField;
	
	@FindBy(css="button[class$='btn-lg']")
	public static WebElement searchButton;
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span") //search by chroPath
	public static WebElement viewShoppingCartOption;
	
	@FindBy(linkText="Continue")
	public static WebElement Continue;

	
	
	public static void navigateToLoginPage() {
		
		Elements.click(myAccountLink);
		Elements.click(Login);
			
	}
	
    public static void searchProduct() {
		
		Elements.TypeText(searchBoxField,Base.reader.getProduct());
		Elements.click(searchButton);		
		
	}
	
     public static void navigateToShoppingCartPage()  {

    	 Elements.click(viewShoppingCartOption);
			
	}
	
}