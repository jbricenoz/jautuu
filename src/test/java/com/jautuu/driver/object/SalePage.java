package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalePage {

	public SalePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		@SuppressWarnings("unused")
		BasicInformation Basic = new BasicInformation(driver);

		@SuppressWarnings("unused")
		BillingInformation Billing = new BillingInformation(driver);

		@SuppressWarnings("unused")
		CreditDebitCardInformation CardInformation = new CreditDebitCardInformation(driver);

	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[4]/div/div/button"),
			@FindBy(xpath = ".//*[@id='root']/div//section/div/form//div/button[contains(.,'Submit')]"), })
	public static WebElement btnSubmit;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/h1"),
			@FindBy(xpath = ".//*[@id='root']//div/section/div/h1[contains(.,'Sale Transaction')]"),
			@FindBy(css = ".page-header") })
	public static WebElement lblPageTitle;

	public static class BasicInformation {

		public BasicInformation(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[1]/div/div[1]/div/input"),
				@FindBy(name = "merchantID") })
		public static WebElement txtMerchantID;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div//div/section/div/form/div[1]/div/div[2]/input"),
				@FindBy(xpath = ".//*[@id='root']/div//div/section/div/form//div[2]/input[@name = 'latitudeDesk']"),
				@FindBy(name = "latitudeDesk") })
		public static WebElement txtLatitudeDesk;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']//div[2]/div/section/div/form/div[1]/div/div[3]/div/select"),
				@FindBy(name = "legalEntityApp") })
		public static WebElement ddlLegalEntityApp;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']//div[2]/div/section/div/form/div[1]/div/div[4]/div/select"),
				@FindBy(name = "origin") })
		public static WebElement ddlOrigin;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[1]/div/div[6]/div/select"),
				@FindBy(name = "period") })
		public static WebElement ddlAccountingPeriodforTransaction;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[1]/div/div[5]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div[5]/div/input[@name = 'accountNumber']"),
				@FindBy(name = "accountNumber") })
		public static WebElement txtAccountNumber;

	}

	public static class BillingInformation {

		public BillingInformation(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[1]/div[1]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='firstName']"),
				@FindBy(name = "firstName") })
		public static WebElement txtFirstName;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[1]/div[2]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='lastName']"),
				@FindBy(name = "lastName") })
		public static WebElement txtLastName;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[2]/div/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='email']"),
				@FindBy(name = "email") })
		public static WebElement txtEmail;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[3]/div/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='address']"),
				@FindBy(name = "address") })
		public static WebElement txtStreetAddress;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[4]/div[1]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='city']"),
				@FindBy(name = "city") })
		public static WebElement txtCity;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[4]/div[2]/div/select"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div[2]/div/select[@name='state']"),
				@FindBy(name = "state") })
		public static WebElement txtState;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[5]/div[1]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/input[@name='postalCode']"),
				@FindBy(name = "postalCode") })
		public static WebElement txtPostalCode;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[2]/div[5]/div[2]/div/select"),
				@FindBy(xpath = ".//*[@id='root']/div//section/div/form/div[2]//div/select[@name='country']"),
				@FindBy(name = "country") })
		public static WebElement ddlCountry;

	}

	public static class CreditDebitCardInformation {

		public CreditDebitCardInformation(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[1]/div[1]/div/input"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div[1]/div/input[@name='card']"),
				@FindBy(name = "card") })
		public static WebElement txtCard;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[1]/div[2]/div/input"),
				@FindBy(xpath = ".//*[@id='root']/div//section/div/form//div/input[@name='expirationDate']"),
				@FindBy(name = "expirationDate") })
		public static WebElement txtExpirationDate;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[2]/div[1]/div/select"),
				@FindBy(xpath = ".//*[@id='root']//div/section/div/form//div/select[@name='currency']"),
				@FindBy(name = "currency") })
		public static WebElement ddlCurrency;

		@FindAll({
				@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[1]/div[5]/div/input"),
				@FindBy(xpath = ".//*[@id='root']/div//div/section/div/form//div[5]/div/input[@placeholder='Amount']"),
				@FindBy(name = "Amount") })
		public static WebElement txtAmount;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/form/div[3]/div[1]/div[3]/div/input"),
				@FindBy(xpath = ".//*[@id='root']/div//div/section/div/form//div[3]/div/input[@name='cvv']"),
				@FindBy(name = "cvv") })
		public static WebElement txtCVV;

	}

}
