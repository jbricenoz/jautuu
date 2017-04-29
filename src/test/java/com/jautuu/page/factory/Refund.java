package com.mcmcg.gbs.bluefin.pages.factory;

import com.mcmcg.gbs.bluefin.pages.object.RefundPage;

public class Refund {
	
	public static String getSaleTransactionTitle() {
		if (RefundPage.lblPageTitle.isDisplayed()) {
			return RefundPage.lblPageTitle.getText().toString();
		}
		return "Missing Title";
	}

	public static boolean cleanForm() {
		RefundPage.txtTransactionID.clear();
		return true;
	}
	
	public static boolean search(){
		RefundPage.btnSearch.click();
		return true;
	}

}
