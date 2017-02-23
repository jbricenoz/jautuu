package com.jautuu.driver.factory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.jautuu.driver.factory.WebDriverFactory.Browser;
import com.jautuu.driver.object.LoginPage;
import com.jautuu.service.factory.ExtentReportService;
import com.jautuu.service.factory.WebDriverService;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LocalTestFactory {

	private static WebDriver driver;
	private ExtentReports report;
	protected ExtentTest test;

	protected LoginPage login;

	@BeforeClass
	@Parameters({ "url", "browser" })
	public void beforeClass(String url, String browser) throws Exception {
		report = ExtentReportService.getInstance();
		test = report.startTest(this.getClass().getCanonicalName().toString());
		driver = WebDriverFactory.createDriver(url, Browser.valueOf(browser));
		test.log(LogStatus.INFO, "Stating Test instance");
		/**
		 * Driver instances, Maybe we can use a Map<instances>
		 */
		login = new LoginPage(driver);

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
