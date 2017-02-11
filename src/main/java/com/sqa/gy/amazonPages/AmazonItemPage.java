package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.gy.helpers.*;

public class AmazonItemPage extends BasicPage {

	@FindBy(id = "add-to-cart-button")
	public WebElement addToCartButton;

	@FindBy(id = "quantity")
	public WebElement quantityDropDown;

	private WebDriver driver;

	public AmazonItemPage(WebDriver driver) {
		super(driver);
	}

	public AmazonAddedToCartPage clickAddToCart() {
		this.addToCartButton.click();
		return new AmazonAddedToCartPage(this.driver);
	}

	public void selectQuantityToBuy(String quantity) {
		Select select = new Select(this.quantityDropDown);
		select.selectByVisibleText(quantity);
	}
}
