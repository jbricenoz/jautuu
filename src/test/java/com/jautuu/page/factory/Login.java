package com.jautuu.page.factory;

import com.jautuu.driver.object.LoginPage;

public class Login {

	public static boolean setUsername(String username) {
		LoginPage.txtUsername.sendKeys(username.toString().toLowerCase());
		return true;
	}

	public static boolean setPassword(String password) {
		LoginPage.txtPassword.sendKeys(password.toString().toLowerCase());
		return true;
	}

	public static boolean test() {
		LoginPage.test.click();
		LoginPage.test2.sendKeys("It's works!");
		return false;
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean setLogin(String username, String password) throws Exception {
		// Code here
		return true;
	}

}
