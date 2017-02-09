package com.sqa.gy;

import java.sql.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class AmazonCartTest1 extends BasicTest {

	public AmazonCartTest1() {
		super("https://www.amazon.com");
	}

	@DataProvider
	public Object[][] fromSQL1() throws ClassNotFoundException, SQLException {
		getLogger().info("Getting data from db and passing it");
		Object[][] dataForTesting = DataHelper.evalDatabaseTable("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:8889/Amazon_db1", "root", "root", "products");
		return dataForTesting;
	}

	@Test(dataProvider = "fromSQL1")
	public void testAddingItemsToCart(String id, String item, String quantity, String priceTotalExpected) {
		// automatically creates the instance of amazonCartTest1 above. And
		// thats why the url goes up there not here

		// HomePage
		// AmazonHomePage homePage = new AmazonHomePage(getDriver());
		WebElement searchbar = getDriver().findElement(By.id("twotabsearchtextbox"));
		getLogger().info("Sending keys to search bar");
		// homePage.enterSearchTest(item);
		searchbar.sendKeys(item);
		getLogger().info("submitting on search button");
		WebElement searchButtonInput = getDriver().findElement(By.className("nav-input"));
		getLogger().info("submitting on search button");
		searchButtonInput.submit();
		// SearchResults Page
		WebElement firstResult = getDriver().findElement(By.cssSelector("#result_0  a.a-link-normal.a-text-normal"));
		firstResult.click();
		// Product Page
		Select quantityDropDown = new Select(getDriver().findElement(By.id("quantity")));
		quantityDropDown.selectByVisibleText(quantity);
		WebElement addToCartButton = getDriver().findElement(By.id("add-to-cart-button"));
		addToCartButton.click();
		// Splash Added to cart page
		WebElement goToCart = getDriver().findElement(By.id("nav-cart"));
		goToCart.click();
		// Shopping Cart Page
		String subtotalString = getDriver()
				.findElement(By.xpath("//div[contains(@class, 'sc-subtotal a-spacing-mini')]//span/span[2]/text()"))
				.getText();
		subtotalString = subtotalString.replaceAll("$,", "");
		double subtotalDouble = 0;
		try {
			subtotalDouble = Double.parseDouble(subtotalString);
		} catch (Exception e) {
			System.out.println("Could not convert subtotal string into a double");
		}
		Assert.assertEquals(subtotalDouble, Double.parseDouble(priceTotalExpected));
	}

}
