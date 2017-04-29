package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mcmcg.gbs.bluefin.pages.object.SalePage.BasicInformation;

public class SearchForTransactionsPage {

	public SearchForTransactionsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		@SuppressWarnings("unused")
		BasicInformation Basic = new BasicInformation(driver);

	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/button"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/button[contains(.,'Submit')]"), })
	public static WebElement btnSubmit;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/h1"),
			@FindBy(xpath = ".//*[@id='root']/div//section/div/h1[contains(.,'Search & Reporting')]"),
			@FindBy(css = ".page-header") })
	public static WebElement lblPageTitle;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[1]/div[1]/div/input"),
			@FindBy(name = "applicationTransactionId") })
	public static WebElement transactionID;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[1]/div[2]/div/select"),
			@FindBy(name = "legalEntity") })
	public static WebElement legalEntity;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[1]/div[3]/div/select"),
			@FindBy(name = "transactionType") })
	public static WebElement transactionType;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[1]/div[4]/div/select"),
			@FindBy(name = "transactionStatusCode") })
	public static WebElement transactionStatusCode;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[2]/div[1]/div/input"),
			@FindBy(name = "accountNumber") })
	public static WebElement accountNumber;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[2]/div[2]/div/input"),
			@FindBy(name = "customer") })
	public static WebElement customer;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[2]/div[3]/div/select"),
			@FindBy(name = "cardType") })
	public static WebElement cardType;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[2]/div[4]/div/select"),
			@FindBy(name = "processorName") })
	public static WebElement processorName;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[3]/div[1]/div/input"),
			@FindBy(name = "minamount") })
	public static WebElement minamount;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[3]/div[2]/div/input"),
			@FindBy(name = "maxamount") })
	public static WebElement maxamount;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[3]/div[3]/div/input"),
			@FindBy(name = "mincreatedDate") })
	public static WebElement mincreatedDate;

	@FindAll({
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div/div[3]/div[4]/div/input"),
			@FindBy(name = "maxcreatedDate") })
	public static WebElement maxcreatedDate;

}
