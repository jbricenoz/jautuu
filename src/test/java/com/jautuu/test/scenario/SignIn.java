package com.mcmcg.gbs.bluefin.test.scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mcmcg.gbs.bluefin.driver.factory.LocalTestFactory;
import com.mcmcg.gbs.bluefin.pages.factory.Login;
import com.relevantcodes.extentreports.LogStatus;

public class SignIn extends LocalTestFactory {

	@Test
	public void TC001() throws Exception {
		Assert.assertTrue(Login.with("cvega3", "123"));
		test.log(LogStatus.PASS, "Verify the Sign In is ok");
	}

	@Test(dependsOnMethods = "TC001")
	public void TC002() throws Exception {
		Assert.assertEquals(Login.getPageTitle(), "Welcome to the Bluefin Web Portal.");
		test.log(LogStatus.PASS, "Verify Home page is displayed");
	}

}
