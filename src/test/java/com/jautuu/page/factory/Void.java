package com.mcmcg.gbs.bluefin.pages.factory;

import com.mcmcg.gbs.bluefin.pages.object.VoidPage;

public class Void {

	public static String getSaleTransactionTitle() {
		if (VoidPage.lblPageTitle.isDisplayed()) {
			return VoidPage.lblPageTitle.getText().toString();
		}
		return "Missing Title";
	}

	public static boolean cleanForm() {
		VoidPage.txtTransactionID.clear();
		return true;
	}
	
	public static boolean search(){
		VoidPage.btnSearch.click();
		return true;
	}

}
