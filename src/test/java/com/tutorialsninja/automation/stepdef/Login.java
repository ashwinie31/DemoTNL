package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import io.cucumber.java.en.*;


public class Login  {

	 HeadersSection  headersSection        = new  HeadersSection();
	 LoginPage LoginPage                   = new LoginPage();
	 MyAccountPage MyAccountPage           = new  MyAccountPage();
	 ForgotPasswordPage ForgotPasswordPage = new  ForgotPasswordPage();
	 
	 @Given("I naviage to Account Login page")
	 public void i_naviage_to_account_login_page() {
			
			Elements.click(HeadersSection.myAccountLink);
			Elements.click(HeadersSection.Login);
	 }
	
	
	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_Username_and_Password(String email, String password)  {
		
		com.tutorialsninja.automation.pages.LoginPage.doLogin(email,password);
		
	}
	
	@Then("^I should see that the User is able to successfully login$")
	public void i_should_see_that_the_User_is_able_to_successfully_login()  {
		
		Assert.assertTrue(Elements.isDisplayed(com.tutorialsninja.automation.pages.MyAccountPage.registerAffiliateAccount));
		
	}
	
	@Then("^I should see an error message informing the User about invalid credentials$")
	public void i_should_see_an_error_message_informing_the_User_about_invalid_credentials()  {
		
		Assert.assertTrue(Elements.VerifyTextEquals(com.tutorialsninja.automation.pages.LoginPage.mainwarning,"Warning: No match for E-Mail Address and/or Password."));
	    
	}


    @When("^I reset the forgotten password for \"([^\"]*)\"$")
    public void i_reset_the_forgotten_password_for(String email) {
    
	Elements.click(com.tutorialsninja.automation.pages.LoginPage.forgotPassword);
	Elements.TypeText(com.tutorialsninja.automation.pages.ForgotPasswordPage.emailField,email);
	Elements.click(com.tutorialsninja.automation.pages.ForgotPasswordPage.continueButton);
	
     }

    @Then("I should see a message informing that the password reset details have been sent to the email addres")
    public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_addres() {
        
		Assert.assertTrue(Elements.VerifyTextEquals(com.tutorialsninja.automation.pages.LoginPage.mainwarning,"An email with a confirmation link has been sent your email address."));

    }


}

