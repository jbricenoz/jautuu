package com.jautuu.driver.factory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.jautuu.driver.factory.WebDriverFactory.Browser;
import com.jautuu.driver.object.SignInPage;
import com.jautuu.service.factory.WebDriverService;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class LocalTestFactory {

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
}
