package com.sqa.gy.helpers;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class BasicPage {

	public Logger logger;

	private WebDriver driver;

	public BasicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.logger = Logger.getLogger(BasicPage.class); // you pass in the
															// class type. you
															// could put in a
															// string, but
															// unique to the
															// THIS logger.
	}

	public boolean takeScreenshot() {
		return AutoBasics.takesScreenshot(this.driver, "screenshot");
	}

	public boolean takeScreenshot(String filename) {
		return AutoBasics.takesScreenshot(this.driver, filename);
	}

}
