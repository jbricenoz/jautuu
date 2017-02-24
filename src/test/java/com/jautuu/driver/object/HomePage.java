package com.jautuu.driver.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "html/body/div[1]/header/div/div/div/a[1]")})
	public static WebElement lknSignIn;
	
	@FindAll({ @FindBy(xpath = "html/body/div[4]/div[1]/div/div/div[1]/h1")})
	public static WebElement lblHeaderSlider;
	
}
