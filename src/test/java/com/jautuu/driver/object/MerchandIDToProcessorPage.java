package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchandIDToProcessorPage {

	public MerchandIDToProcessorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(name = "paymentProcessorId"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div[1]/div/div/select") })
	public static WebElement paymentProcessor;

}
