package com.sqa.gy.jqueryActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class JAResizableTest extends BasicTest {

	public JAResizableTest(String baseUrl) {
		super("https://jqueryui.com/resizable");
	}

	@Test
	public void testResizable() throws InterruptedException {
		WebElement demoiFrame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(demoiFrame);
		// Or can do by frame index or by ID ^
		AutoBasics.takesScreenshot(this.getDriver(), "Resizible - Before");

		WebElement rightSideToResize = getDriver().findElement(By.className("ui-resizable-e"));
		new Actions(getDriver()).dragAndDropBy(rightSideToResize, 100, 0).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Resizible - After1");

		// does not work with drag and drop
		WebElement bottomToResize = getDriver().findElement(By.className("ui-resizable-s"));
		new Actions(getDriver()).clickAndHold(bottomToResize).moveByOffset(0, 100).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Resizible - After2");

		// has issues w drag and drop if x = 0 but this works fine
		WebElement cornerToResize = getDriver().findElement(By.className("ui-resizable-se"));
		new Actions(getDriver()).clickAndHold(cornerToResize).moveByOffset(0, 50).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Resizible - After3");
		Thread.sleep(5000);
	}

}
