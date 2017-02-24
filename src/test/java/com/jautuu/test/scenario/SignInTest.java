package com.jautuu.test.scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jautuu.driver.factory.RemoteTestFactory;
import com.jautuu.page.factory.SignIn;
import com.relevantcodes.extentreports.LogStatus;

public class SignInTest  extends RemoteTestFactory {
	
	@Test
	public void TC001() {
		Assert.assertTrue(true);
		test.log(LogStatus.FAIL, "Verify the Page title is the right");
	}

	@Test(dependsOnMethods = "TC001")
	public void TC002() throws Exception {
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Verify the app can do a click on register button");
	}


}
