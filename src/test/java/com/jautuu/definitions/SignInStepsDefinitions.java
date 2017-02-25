package com.jautuu.definitions;

import com.jautuu.driver.factory.LocalTestFactory;
import com.jautuu.page.factory.Home;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInStepsDefinitions  extends LocalTestFactory {

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		Home.getSliderHeader().equals("How people build software");
	}

	@When("^User Navigate to SignIn Page$")
	public void user_Navigate_to_SignIn_Page() throws Throwable {
		Home.navigateToSignInPage();
	}

	@When("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable arg1) throws Throwable {

		// This is to get the first data of the set (First Row + First Column)
		// String data = arg1.raw().get(0).get(0).toString();
		// SignIn.setUsername(data);
		//
		// //This is to get the first data of the set (First Row + Second
		// Column)
		// SignIn.setPassword(arg1.raw().get(0).get(1).toString());
		//
		// SignIn.clickBtnSignUpPage();

	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {

	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {

	}

}
