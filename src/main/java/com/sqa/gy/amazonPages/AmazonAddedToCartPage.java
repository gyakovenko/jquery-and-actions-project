package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.gy.helpers.*;

public class AmazonAddedToCartPage extends BasicPage {

	@FindBy(id = "nav-cart")
	public WebElement cartIconButton;

	private WebDriver driver;

	public AmazonAddedToCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public AmazonShoppingCartPage clickOnShoppingCartIcon() {
		this.cartIconButton.click();
		return new AmazonShoppingCartPage(this.driver);
	}
}
