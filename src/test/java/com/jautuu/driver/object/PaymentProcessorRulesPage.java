package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentProcessorRulesPage {

	public PaymentProcessorRulesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/button"),
			@FindBy(xpath = ".//*[@id='root']/div//div/section/div/div/form/div/button[contains(.,'Create a new user')]"), })
	public static WebElement btnSubmit;

}
