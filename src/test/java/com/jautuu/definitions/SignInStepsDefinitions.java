package com.jautuu.definitions;

import org.openqa.selenium.WebDriver;

import com.jautuu.driver.factory.WebDriverFactory;
import com.jautuu.driver.factory.WebDriverFactory.Browser;
import com.jautuu.driver.factory.WebDriverFactory.Environment;
import com.jautuu.driver.object.HomePage;
import com.jautuu.driver.object.SignInPage;
import com.jautuu.page.factory.Home;
import com.jautuu.page.factory.SignIn;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInStepsDefinitions  {
	
	// webdriver must be on null for each running
	private static WebDriver driver;
	
	// null instance of the class used in the test, we can implement map instances.
	protected SignInPage SignInst;
	protected HomePage HomeInst;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		// Choose the enviroment for run your test
		driver =  WebDriverFactory.createDriver(Environment.QA, Browser.CHROME);
		
		// Class driver instances.
		//  we can implements extends from LocalTestFactory
		SignInst = new SignInPage(driver);
		HomeInst = new HomePage(driver);
	}

	@When("^User Navigate to SignIn Page$")
	public void user_Navigate_to_SignIn_Page() throws Throwable {
		Home.navigateToSignInPage();
	}

	@When("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable arg1) throws Throwable {

		// This is to get the first data of the set (First Row + First Column)
		String data = arg1.raw().get(0).get(0).toString();
		SignIn.setUsername(data);
		
		// //This is to get the first data of the set (First Row + Second
		// Column)
		
		SignIn.setPassword(arg1.raw().get(0).get(1).toString());
		SignIn.clickBtnSignUpPage();

	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		driver.quit();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		// code here
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		// code here
	}

}
