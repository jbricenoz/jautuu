package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author jbriceno
 *
 */
public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "inputEmail"), @FindBy(xpath = ".//*[@id='inputEmail']") })
	public static WebElement txtEmailAddress;

	@FindAll({ @FindBy(id = "inputPassword"), @FindBy(xpath = ".//*[@id='inputPassword']") })
	public static WebElement txtPassword;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div//section/div//form/div[4]/button"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div[2]/div/div/form/div[4]/button") })
	public static WebElement btnSignIn;

	@FindAll({ @FindBy(xpath = ".//*[@id='remember']/label/input") })
	public static WebElement chkRememberMe;
	
	
	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/h1") })
	public static WebElement lblHomeTitle;

}
