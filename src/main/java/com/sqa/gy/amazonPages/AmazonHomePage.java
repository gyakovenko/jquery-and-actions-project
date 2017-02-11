package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.gy.helpers.*;

public class AmazonHomePage extends BasicPage {

	@FindBy(className = "nav-input")
	public WebElement searchButtonInput;

	private WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;

	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}

	public void enterSearchText(String searchText) {
		this.searchField.clear();
		this.searchField.sendKeys(searchText);
	}

	public void submitSearchQuery() {
		this.searchButtonInput.submit();
	}

}
