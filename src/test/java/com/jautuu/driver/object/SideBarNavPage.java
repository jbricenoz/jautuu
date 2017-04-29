package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBarNavPage {

	public SideBarNavPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = ".//*[@id='sidebarnav']/li[1]/a"),
			@FindBy(xpath = ".//*[@id='sidebarnav']/li[1]/a[contains(.,'Credit/Debit Card')]"), })
	public static WebElement lknPanelCreditDebitCard;

	@FindAll({ @FindBy(xpath = ".//*[@id='section1']/li[1]/a"),
			@FindBy(xpath = ".//*[@id='section1']/li[1]/a[contains(.,'Sale')]"), @FindBy(css = ".selected>a") })
	public static WebElement lknSale;

	@FindAll({ @FindBy(xpath = ".//*[@id='section1']/li[2]/a"),
			@FindBy(xpath = ".//*[@id='section1']/li[2]/a[contains(.,'Void')]"), })
	public static WebElement lknVoid;

	@FindAll({ @FindBy(xpath = ".//*[@id='section1']/li[3]/a"),
			@FindBy(xpath = ".//*[@id='section1']/li[3]/a[contains(.,'Refund')]"), })
	public static WebElement lknRefund;

	@FindAll({ @FindBy(xpath = ".//*[@id='sidebarnav']/li[1]/a"),
			@FindBy(xpath = ".//*[@id='sidebarnav']/li[2]/a[contains(.,'Search & Reporting')]"), })
	public static WebElement lknPanelSearchReporting;

	@FindAll({ @FindBy(xpath = ".//*[@id='section2']/li/a"),
			@FindBy(xpath = ".//*[@id='section2']/li/a[contains(.,'Search for Transactions')]"),
			@FindBy(css = "#section2>li>a") })
	public static WebElement lknSearchForTransactions;

	@FindAll({ @FindBy(xpath = ".//*[@id='sidebarnav']/li[3]/a"),
			@FindBy(xpath = ".//*[@id='sidebarnav']/li[3]/a[contains(.,'Settings')]"), })
	public static WebElement lknPanelSettings;

	@FindAll({ @FindBy(xpath = ".//*[@id='section3']/li[1]/a"),
			@FindBy(xpath = ".//*[@id='section3']/li[1]/a[contains(.,'Account Information')]"), })
	public static WebElement lknAccountInformation;

	@FindAll({ @FindBy(xpath = ".//*[@id='section3']/li[2]/a"),
			@FindBy(xpath = ".//*[@id='section3']/li[2]/a[contains(.,'User Management')]"), })
	public static WebElement lknUserManagement;

	@FindAll({ @FindBy(xpath = ".//*[@id='section3']/li[3]/a"),
			@FindBy(xpath = ".//*[@id='section3']/li[3]/a[contains(.,'Payment Processor Rules')]"), })
	public static WebElement lknPaymentProcessorRules;

	
}
