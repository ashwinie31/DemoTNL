package com.tutorialsninja.automation.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:FeatureFiles/1.Register.feature",
		                   "classpath:FeatureFiles/2.Login.feature",
				         "classpath:FeatureFiles/3.Search.feature",
				          "classpath:FeatureFiles/4.Orders.feature"
},       
                     glue={"com.tutorialsninja.automation.stepdef"},
                   plugin={"html:target/cucumber-html-reports"}
                  // tags=  "@Orders"                              // Here curly bracket {} get an errors so doesn't use curly bracket
 )

public class TestRunner {
	

}

