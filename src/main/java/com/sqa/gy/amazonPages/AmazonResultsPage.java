package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.gy.helpers.*;

public class AmazonResultsPage extends BasicPage {

	private WebDriver driver;

	@FindBy(css = "#result_0 a.a-link-normal.a-text-normal")
	private WebElement firstResultOnPage;

	public AmazonResultsPage(WebDriver driver) {
		super(driver);
	}

	public AmazonItemPage clickOnFirstResult() {
		this.logger.info("Selecting first search result");

		WebElement firstResult = this.driver.findElement(By.cssSelector("#result_0 a.a-link-normal.a-text-normal"));
		firstResult.click();
		// this.firstResultOnPage.click();
		return new AmazonItemPage(this.driver);
	}
}
