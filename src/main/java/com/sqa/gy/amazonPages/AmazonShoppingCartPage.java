package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.gy.helpers.*;

public class AmazonShoppingCartPage extends BasicPage {

	@FindBy(xpath = "//div[contains(@class, 'sc-subtotal a-spacing-mini')]//span/span[2]")
	public WebElement subtotalText;

	private WebDriver driver;

	public AmazonShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public String retrieveSubtotalString() {
		return this.subtotalText.getText();
	}
}
