package com.jautuu.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/SignIn.feature",
		glue = "com.jautuu.definitions",
		format = {"pretty", "html:target/cucumber"}
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
