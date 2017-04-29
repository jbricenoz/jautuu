package com.mcmcg.gbs.bluefin.pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLegalEntitiesPage {

	public ManageLegalEntitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = ".//*[@id='root']/div//section//div/a/button[contains(.,'Create a new Legal Entity')]"),
			@FindBy(xpath = ".//*[@id='root']/div/div/div[2]/div/section/div/div/div[1]/div/div/div/a/button") })
	public static WebElement btnCreateNewLegalEntity;

}
