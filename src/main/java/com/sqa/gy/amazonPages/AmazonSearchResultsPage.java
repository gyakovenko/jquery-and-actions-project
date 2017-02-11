package com.sqa.gy.amazonPages;

import org.openqa.selenium.*;

import com.sqa.gy.helpers.*;

public class AmazonSearchResultsPage extends BasicPage {

	private WebDriver driver;

	// @FindBy(css = "#result_0 a.a-link-normal.a-text-normal")
	// private WebElement firstResultOnPage;

	public AmazonSearchResultsPage(WebDriver driver) {
		super(driver);

	}

	public AmazonItemPage clickOnResult(int whichResult) {
		switch (whichResult) {
		case 1:
			this.logger.info("Selecting first search result");
			this.driver.findElement(By.cssSelector("#result_0  a.a-link-normal.a-text-normal"));
			// this.firstResultOnPage.click();
			this.logger.info("Clicked");
			break;
		default:
			this.logger.info("There was an issue selecting with # from results, but going forward");
			// this.firstResultOnPage.click();
			break;
		}
		return new AmazonItemPage(this.driver);
	}
}
