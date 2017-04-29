package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {

	public UserManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/button"),
			@FindBy(xpath = ".//*[@id='root']/div//div/section/div/div/form/div/button[contains(.,'Create a new user')]"), })
	public static WebElement btnSubmit;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/h1") })
	public static WebElement pageTitle;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/button"),
			@FindBy(xpath = ".//*[@id='root']//div/section/div/div/button[contains(.,'Create a new user')]"), })
	public static WebElement btnCreateNewUser;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[1]/div[1]/div/input"),
			@FindBy(name = "firstName") })
	public static WebElement firstName;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[1]/div[2]/div/input"),
			@FindBy(name = "lastName") })
	public static WebElement lastName;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[1]/div[3]/div/input"),
			@FindBy(name = "username") })
	public static WebElement username;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[1]/div[4]/div/input"),
			@FindBy(name = "email") })
	public static WebElement email;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[2]/div[1]/div/select"),
			@FindBy(name = "legalEntities") })
	public static WebElement legalEntities;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/form/div/div[2]/div[2]/div/select"),
			@FindBy(name = "roles") })
	public static WebElement roles;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[1]/table/thead/tr/th") })
	public static WebElement tableHeaders;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[1]/table/tbody/tr/td") })
	public static WebElement tableContent;

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[1]/table/tbody/tr/td/a/i") })
	public static WebElement tableActions;

}
