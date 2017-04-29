package com.mcmcg.gbs.bluefin.pages.factory;

import com.mcmcg.gbs.bluefin.pages.object.SideBarNavPage;

public class SideBarNav {

	public static boolean clickOnPanelCreditDeborCardLink() throws Exception {
		if (SideBarNavPage.lknPanelCreditDebitCard.isDisplayed()) {
			SideBarNavPage.lknPanelCreditDebitCard.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnPanelSearchReporting() throws Exception {
		if (SideBarNavPage.lknPanelSearchReporting.isDisplayed()) {
			SideBarNavPage.lknPanelSearchReporting.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnPanelSettings() throws Exception {
		if (SideBarNavPage.lknPanelSettings.isDisplayed()) {
			SideBarNavPage.lknPanelSettings.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnSaleLink() throws Exception {
		if (SideBarNavPage.lknSale.isDisplayed()) {
			SideBarNavPage.lknSale.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnVoidLink() throws Exception {
		if (SideBarNavPage.lknVoid.isDisplayed()) {
			SideBarNavPage.lknVoid.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnRefundLink() throws Exception {
		if (SideBarNavPage.lknRefund.isDisplayed()) {
			SideBarNavPage.lknRefund.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnSearchForTransactions() throws Exception {
		if (SideBarNavPage.lknSearchForTransactions.isDisplayed()) {
			SideBarNavPage.lknSearchForTransactions.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnAccountInformation() throws Exception {
		if (SideBarNavPage.lknAccountInformation.isDisplayed()) {
			SideBarNavPage.lknAccountInformation.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnUserManagement() throws Exception {
		if (SideBarNavPage.lknUserManagement.isDisplayed()) {
			SideBarNavPage.lknUserManagement.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	public static boolean clickOnPaymentProcessorRules() throws Exception {
		if (SideBarNavPage.lknPaymentProcessorRules.isDisplayed()) {
			SideBarNavPage.lknPaymentProcessorRules.click();
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

}
