package com.mcmcg.gbs.bluefin.pages.factory;

import org.openqa.selenium.WebDriver;

import com.mcmcg.gbs.bluefin.pages.object.LoginPage;

public class Login extends BaseFactory {

	public Login(WebDriver driver) {
		super(driver);
	}

	public static boolean setTxtEmailAddress(String email) {
		return type(LoginPage.txtEmailAddress, email);
	}

	public static boolean setTxtPassword(String password) {
		if (LoginPage.txtPassword.isDisplayed()) {
			LoginPage.txtPassword.sendKeys(password.toString());
			return true;
		}
		return false;
	}

	public static String getPageTitle() {
		return LoginPage.lblHomeTitle.getText().toString();
	}

	public static boolean with(String email, String password) throws Exception {
		if (setTxtEmailAddress(email) && setTxtPassword(password)) {
			Thread.sleep(2000);
			LoginPage.chkRememberMe.click();
			LoginPage.btnSignIn.click();
			Thread.sleep(2000);
			return true;
		}
		return false;
	}

}
