package com.jautuu.page.factory;

import com.jautuu.driver.object.SignInPage;

public class SignIn {

	public static boolean setUsername(String username) {
		SignInPage.txtUsername.sendKeys(username.toString().toLowerCase());
		return true;
	}

	public static boolean setPassword(String password) {
		SignInPage.txtPassword.sendKeys(password.toString().toLowerCase());
		return true;
	}
	
	public static boolean clickBtnSignUpPage() {
		SignInPage.btnSignIn.click();
		return true;
	}
	
	public static boolean navigateToHomePage(){
		SignInPage.icnGitHub.click();
		return true;
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static boolean setSignUp(String username, String email, String password) throws Exception {
		setUsername(username);
		setPassword(password);
		return true;
	}

}
