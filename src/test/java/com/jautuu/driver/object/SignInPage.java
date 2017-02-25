package com.jautuu.driver.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "login_field"),  @FindBy(xpath = ".//*[@id='login_field']"), @FindBy(css = "#login_field") })
	public static WebElement txtUsername;

    @FindAll({ @FindBy(id = "password"), @FindBy(xpath = ".//*[@id='password']"), @FindBy(css = "#password") })
	public static WebElement txtPassword;

	@FindBy(xpath = ".//*[@id='login']/form/div[4]/input[3]")
	public static WebElement btnSignIn;
	
	@FindBy(xpath = "html/body/div[1]/header/div/a/svg")
	public static WebElement icnGitHub;

}
