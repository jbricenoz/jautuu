package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefundPage {

	public RefundPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		@SuppressWarnings("unused")
		DetailsFor Details = new DetailsFor(driver);

	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/h1"),
			@FindBy(xpath = ".//*[@id='root']/div//section/section/h1[contains(.,'Refund')]"), })
	public static WebElement lblPageTitle;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/form/div/div/div[1]/div/input"),
			@FindBy(xpath = ".//*[@id='root']//div/section/section/form//div[1]/div/input[@name = 'transactionId']"),
			@FindBy(name = "transactionId") })
	public static WebElement txtTransactionID;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/form/div/div/div[2]/div/button"),
			@FindBy(xpath = ".//*[@id='root']/div//section/section/form//div/button") })
	public static WebElement btnSearch;

	public static class DetailsFor {

		public DetailsFor(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/div/div/div/table/thead/tr/th"),
				@FindBy(xpath = ".//*[@id='root']/div//section/section//div/table/thead/tr/th") })
		public static WebElement lbltableHeader;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/div/div/div/table/tbody/tr/td"),
				@FindBy(xpath = ".//*[@id='root']//div/section/section/div//table/tbody/tr/td") })
		public static WebElement lbltableEachCellFirstRow;

		@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/section/div/button"),
				@FindBy(xpath = ".//*[@id='root']/div//section/section/div/button") })
		public static WebElement btnRefund;

	}

}
