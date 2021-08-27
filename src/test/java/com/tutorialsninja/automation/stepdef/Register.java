package com.tutorialsninja.automation.stepdef;


import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	
	 HeadersSection  headersSection        = new  HeadersSection();
	 RegisterPage registerPage             = new   RegisterPage();
	 AccountSuccessPage accountSuccessPage = new AccountSuccessPage();
	 
	 
	@Given("I launch the application")
	public void i_launch_the_application() {
		Base.driver.get(Base.reader.getUrl());
	   
	}

	@And("I navigate to Account Registraition page")
	public void i_navigate_to_account_Registraition_page() {
				
		Elements.click(HeadersSection.myAccountLink);
		Elements.click(HeadersSection.Register);
	    
	}

	@When("I provide all the below valid details")
	public void i_provide_all_the_below_valid_details(DataTable dataTable) {
		
		RegisterPage.enterAllDetails(dataTable,"unique");
		
	   	}

	@And("I select the Privacy Policy")
	public void i_select_the_privacy_policy() {
		
		Elements.click(RegisterPage.privacyPolicy);
		
	   	}

	@And("I click on Continue button")
	public void i_click_on_continue_button() {
		
		Elements.click(RegisterPage.continueButton);
	   }
	

	@Then("I should see that the User Account has successfully created")
	public void i_should_see_that_the_user_account_has_successfully_created() {
			
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.SuccessBreadcrumb));	
		   
	}
     
	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_User_Account_is_not_created() {
	   
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));
		
	}
	
	@And("^I should see the error messages informing the user to fill the mandatory fields")
	public void I_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields() {
	   
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstnamewarning));
		
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastnamewarning));

		Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailwarning));

		Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephonewarning));

		Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordwarning));

		Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainwarning));
		
	  }
		
		@Then("^I subscribe to Newsletter")
		public void I_subscribe_to_Newsletter() {
		   
			Elements.click(RegisterPage.yesToNewsletter);
				
	   }
		
		
		@Then("^I provide the below duplicate details into the fields")
		public void i_provide_the_below_duplicate_details_into_the_fields(DataTable dataTable) {
			
			RegisterPage.enterAllDetails(dataTable,"duplicate");
	
	    }
		
		@Then("^I should see that the user is restricted from registring a duplicate account")
		public void I_should_see_that_the_user_is_restricted_from_registring_a_duplicate_account() {
		   
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainwarning,"Warning: E-Mail Address is already registered!"));
			
	
	}
		
		
		

}
