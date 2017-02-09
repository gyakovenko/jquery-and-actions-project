package com.sqa.gy.helpers;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AmazonHomePage extends BasicPage {

	private WebDriver driver;

	private Logger logger;

	@FindBy(className = "nav-input")
	private Select searchButtonInput;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.logger = Logger.getLogger(AmazonHomePage.class);
	}

	public void enterSearchTest(String searchText) {
		this.searchField.clear();
		this.searchField.sendKeys(searchText);
	}

}
