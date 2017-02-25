package com.jautuu.page.factory;

import com.jautuu.driver.object.HomePage;

public class Home {

	public static boolean navigateToSignInPage() {
		HomePage.lknSignIn.click();
		return true;
	}
	
	public static String getSliderHeader() {
		String h1 = HomePage.lblHeaderSlider.getText();
		return h1;
	}

}
