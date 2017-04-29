package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePaymentProcessorPage {

	public ManagePaymentProcessorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div//section/div//a/button[contains(.,'Create a new Payment Processor')]"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[1]/div/div/div/a/button") })
	public static WebElement btnCreateNewPaymentProcessor;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[2]/table/thead/tr/th") })
	public static WebElement tableHeaders;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[2]/table/tbody/tr/td") })
	public static WebElement tableContent;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[2]/table/tbody/tr/td/a/i") })
	public static WebElement tableActions;
	
}
