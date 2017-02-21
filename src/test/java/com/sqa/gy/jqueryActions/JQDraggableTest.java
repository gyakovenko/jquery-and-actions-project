package com.sqa.gy.jqueryActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class JQDraggableTest extends BasicTest {

	public JQDraggableTest(String baseUrl) {
		super("https://jqueryui.com/draggable");
	}

	@Test
	public void testDraggable() throws InterruptedException {
		WebElement demoiFrame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(demoiFrame);
		// Or can do by frame index or by ID ^
		AutoBasics.takesScreenshot(this.getDriver(), "Draggable - Before");
		WebElement boxToDrag = getDriver().findElement(By.id("draggable"));
		new Actions(getDriver()).dragAndDropBy(boxToDrag, 100, 0).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Draggable - After");
		Thread.sleep(5000);
	}

}
