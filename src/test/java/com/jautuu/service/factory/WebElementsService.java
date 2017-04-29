package com.mcmcg.gbs.bluefin.service.factory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementsService {

	public WebElementsService() {

	}

	public static List<WebElement> getDropDownListItems(WebElement element) {
		Select ddl = new Select(element);
		List<WebElement> options = ddl.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		return options;
	}

	public static List<WebElement> setDropDownListItem(WebElement element, String itemToClick) {
		Select ddl = new Select(element);
		List<WebElement> options = ddl.getOptions();
		for (WebElement option : options) {
			if (option.getText().toLowerCase().equals(itemToClick.toLowerCase())) {
				option.click();
			} else {
				System.err.println("404 - Option not found");
			}
		}
		return options;
	}

}
