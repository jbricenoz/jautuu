package com.mcmcg.gbs.bluefin.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseFactory {

	private static WebDriver driver;

	public BaseFactory(WebDriver driver) {
		BaseFactory.driver = driver;
	}

	public static void visit(String url) {
		driver.get(url);
	}

	public static boolean clic(WebElement element) {
		if (element.isDisplayed()) {
			element.click();	
			return true;
		}
		return true;
	}

	public static boolean type(WebElement element, String text) {
		if (element.isDisplayed()) {
			element.sendKeys(text);	
			return true;
		}
		return false;
	}
}
