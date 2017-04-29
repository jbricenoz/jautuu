package com.mcmcg.gbs.bluefin.test.scenarios;

import org.testng.annotations.Test;

import com.mcmcg.gbs.bluefin.driver.factory.LocalTestFactory;
import com.mcmcg.gbs.bluefin.pages.factory.Login;
import com.mcmcg.gbs.bluefin.pages.factory.Sale;
import com.mcmcg.gbs.bluefin.pages.factory.SideBarNav;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class SaleTransactions extends LocalTestFactory {

	@Test
	public void login() throws Exception {
		Assert.assertTrue(Login.with("cvega3", "123"));
		test.log(LogStatus.PASS, "Verify the Sign In is ok");
	}
	
	@Test(dependsOnMethods = "login")
	public void verifyIfCanClickOnSaleLink() throws Exception {
		Assert.assertTrue(SideBarNav.clickOnSaleLink());
		test.log(LogStatus.PASS, "Verify the app can go to Sale section");
	}

	@Test(dependsOnMethods = "verifyIfCanClickOnSaleLink")
	public void verifyIFCanCleanForm() throws Exception {
		Assert.assertTrue(Sale.cleanForm());
		test.log(LogStatus.PASS, "Verify the Page form can be cleaned");
	}
	
	@Test(dependsOnMethods = "verifyIFCanCleanForm")
	public void verifyIFtheTitleIsCorrect() throws Exception {
		Assert.assertEquals("Sale Transaction", Sale.getSaleTransactionTitle());
		test.log(LogStatus.PASS, "Verify the Page title is the right for Sale section");
	}
	
	@Test(dependsOnMethods = "verifyIFtheTitleIsCorrect")
	public void verifyIfCanSetBasicInformation() throws Exception {
		Assert.assertTrue(Sale.setBasicInformation("Visa", 2, "123456"));
		test.log(LogStatus.PASS, "Verify the Basic Information can be filled");
	}
	
	@Test(dependsOnMethods = "verifyIfCanSetBasicInformation")
	public void verifyIfCanSetBillingInformation() throws Exception {
		Assert.assertTrue(Sale.setBillingInformation("Joshua", "Briceno", "joshua.briceno@mcmcg.com", "San Diego", "CA", "Test", "11508", 2));
		test.log(LogStatus.PASS, "Verify the Billing Information can be filled");
	}
	
	@Test(dependsOnMethods = "verifyIfCanSetBillingInformation")
	public void verifyIfCanSetCardInformation() throws Exception {
		Assert.assertTrue(Sale.setCreditDebitCardInformation("4000225643176329", "2016-12-12", 1, "20000", "123"));
		test.log(LogStatus.PASS, "Verify the Credit / Debit Card Information can be filled");
	}
	
	@Test(dependsOnMethods = "verifyIfCanSetCardInformation")
	public void verifyIfCanSubmitForm() throws Exception {
		Assert.assertTrue(Sale.submit());
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Verify the form can be submitted");
	}

}
