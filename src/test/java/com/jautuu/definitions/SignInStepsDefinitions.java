package com.jautuu.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.jautuu.driver.factory.WebDriverFactory;
import com.jautuu.driver.factory.WebDriverFactory.Browser;
import com.jautuu.driver.object.SignInPage;
import com.jautuu.page.factory.Home;
import com.jautuu.service.factory.WebDriverService;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInStepsDefinitions {

	private static WebDriver driver;
	protected SignInPage SignIn;

	@Before
	@Parameters({ "url", "browser" })
	public void beforeClass(String url, String browser) throws Exception {
		driver = WebDriverFactory.createDriver(url, Browser.valueOf(browser));
		SignIn = new SignInPage(driver);
	}

	@After
	public void tearDown(ITestResult testResult) throws Exception {
		if (!testResult.isSuccess()) {
			WebDriverService.takeScreenShot("FAILED-", testResult.getName(), driver);
		}
		driver.quit();
	}

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
