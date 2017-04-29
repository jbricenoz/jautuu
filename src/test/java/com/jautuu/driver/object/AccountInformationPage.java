package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {

	public AccountInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/button"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/button[contains(.,'Submit')]"), })
	public static WebElement btnSubmit;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/h1") })
	public static WebElement pageTitle;

}
