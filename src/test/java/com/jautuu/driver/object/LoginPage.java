package com.jautuu.driver.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "username"), @FindBy(css = "usernameField") })
	public static WebElement txtUsername;

	@FindBy(id = "password")
	public static WebElement txtPassword;

	@FindBy(xpath = ".//*[@id='app-content']/div/div/header/nav/div/ul[2]/li[5]/a")
	public static WebElement test;

	@FindBy(xpath = ".//*[@id='app-content']/div/div/header/nav/div[1]/div[2]/form/div/div/div/input")
	public static WebElement test2;

}
