package com.jautuu.driver.factory;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.jautuu.driver.factory.WebDriverFactory.Browser;
import com.jautuu.driver.object.SignInPage;
import com.jautuu.service.factory.ExtentReportService;
import com.jautuu.service.factory.WebDriverService;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RemoteTestFactory {

	protected static WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;

	protected SignInPage login;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		WebDriverFactory.setUpLocalRemote();
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		WebDriverFactory.shutdownLocalRemote();
	}

	@BeforeClass
	@Parameters({ "appConfig", "browser", "browserVersion", "os", "osVersion" })
	public void beforeClass(String appConfig, String browser, String browserVersion, String os, String osVersion)
			throws Exception {

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(appConfig)) {
			Properties prop = new Properties();
			prop.load(input);

			String url = prop.getProperty("target.url");

			report = ExtentReportService.getInstance();
			test = report.startTest(this.getClass().getCanonicalName().toString());
			driver = WebDriverFactory.createRemoteDriver(new URL(url), Browser.valueOf(browser), browserVersion, os,
					osVersion);
			test.log(LogStatus.INFO, "Stating Test instance");
		}

		/**
		 * Driver instances, Maybe we can use a Map<instances>
		 */
		login = new SignInPage(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		if (!testResult.isSuccess()) {
			String path = WebDriverService.takeScreenShot("FAILED-", testResult.getName(), driver);
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getName(), imagePath);
		}
	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
