package com.sqa.gy;

import java.sql.*;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.gy.amazonPages.*;
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
		AmazonHomePage homePage = new AmazonHomePage(getDriver());
		getLogger().info("Homepage: Searching for item " + item);
		getLogger().info("Sending keys to search bar");
		homePage.enterSearchText(item);
		getLogger().info("Submitting on search button");
		homePage.submitSearchQuery();

		// NOW THIS WORKS SO LETS WORK FROM HERE.
		// SearchResults Page
		getLogger().info("Search Results Page: Clicking on first result");
		WebElement firstItem = super.getDriver().findElement(By.cssSelector("#result_0 a.a-link-normal.a-text-normal"));
		firstItem.click();

		// Page Elements Not Working
		// AmazonResultsPage resultsPage = new AmazonResultsPage(getDriver());
		// resultsPage.clickOnFirstResult();

		// Product Page
		getLogger().info("Item Page: Selecting quantity " + quantity);
		AmazonItemPage itemPage = new AmazonItemPage(getDriver());
		itemPage.selectQuantityToBuy(quantity);

		getLogger().info("Adding to cart");
		itemPage.clickAddToCart();

		// Added To Cart Page
		AmazonAddedToCartPage addedToCartPage = new AmazonAddedToCartPage(getDriver());
		getLogger().info("Added To Cart Page: Clicking on shopping cart icon");
		addedToCartPage.clickOnShoppingCartIcon();

		// Shopping Cart Page
		AmazonShoppingCartPage shoppingCartPage = new AmazonShoppingCartPage(getDriver());
		getLogger().info("Shopping Cart Page: Retrieving Subtotal");
		String subtotalString = shoppingCartPage.retrieveSubtotalString();
		getLogger().info("subtotalString: " + subtotalString);
		getLogger().info("Converting subtotal string to double");
		double subtotalDouble = AppBasics.convertMoneyStringIntoDouble(subtotalString);

		// Asserting Equals
		getLogger().info("Actual Subtotal: " + subtotalDouble);
		getLogger().info("Expected Expected: " + priceTotalExpected);
		Assert.assertEquals(subtotalDouble, Double.parseDouble(priceTotalExpected));
	}

}