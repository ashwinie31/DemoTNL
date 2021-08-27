package com.tutorialsninja.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class CheckoutPage {
	
public CheckoutPage() {
		
		PageFactory.initElements(Base.driver,this);
		
		}
	
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	public static WebElement continueButtonoofBillingDetailsSection ;
	

	@FindBy(xpath="//input[@id='button-shipping-address']")
	public static WebElement continueButtonoofDeliveryDetailsSection ;
	

	@FindBy(xpath="//input[@id='button-shipping-method']")
	public static WebElement continueButtonoofDeliveryMethodSection ;
	

	@FindBy(name="agree")
	public static WebElement termsAndConditionsCheckbox ;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	public static WebElement continueButtonoofpaymentMethodSection ;
	

	@FindBy(xpath="//input[@id='button-confirm']")
	public static WebElement confirmOrderButton;
	
	
    public static void placeAnOrder() {
		
    	Elements.click(CheckoutPage.continueButtonoofBillingDetailsSection);
    	Elements.click(CheckoutPage.continueButtonoofDeliveryDetailsSection);

    	Elements.click(CheckoutPage.continueButtonoofDeliveryMethodSection);

    	Elements.click(CheckoutPage.termsAndConditionsCheckbox);

    	Elements.click(CheckoutPage.continueButtonoofpaymentMethodSection);

    	Elements.click(CheckoutPage.confirmOrderButton);

		
	}
	
	
	
	
	
	

}
