package com.mcmcg.gbs.bluefin.driver.factory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mcmcg.gbs.bluefin.driver.factory.WebDriverFactory.Browser;
import com.mcmcg.gbs.bluefin.driver.factory.WebDriverFactory.Environment;
import com.mcmcg.gbs.bluefin.pages.factory.BaseFactory;
import com.mcmcg.gbs.bluefin.pages.object.LoginPage;
import com.mcmcg.gbs.bluefin.pages.object.SalePage;
import com.mcmcg.gbs.bluefin.pages.object.SideBarNavPage;
import com.mcmcg.gbs.bluefin.service.factory.ExtentReportService;
import com.mcmcg.gbs.bluefin.service.factory.WebDriverService;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LocalTestFactory {

	private static WebDriver driver;
	private ExtentReports report;
	protected ExtentTest test;

	protected BaseFactory base;
	protected LoginPage login;
	protected SalePage sale;
	protected SideBarNavPage SideBar;

	@BeforeClass
	@Parameters({ "url", "browser" })
	public void beforeClass(String url, String browser) throws Exception {
		report = ExtentReportService.getInstance();
		test = report.startTest(this.getClass().getCanonicalName().toString());
		driver = WebDriverFactory.createDriver(Environment.valueOf(url), Browser.valueOf(browser));
		test.log(LogStatus.INFO, "Stating Test instance");
		/**
		 * Driver instances, Maybe we can use a Map<instances>
		 */
		base = new BaseFactory(driver);
		login = new LoginPage(driver);
		sale = new SalePage(driver);
		SideBar = new SideBarNavPage(driver);

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
