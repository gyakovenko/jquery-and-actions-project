package com.sqa.gy.jqueryActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class JQDroppableTest extends BasicTest {

	public JQDroppableTest(String baseUrl) {
		super("https://jqueryui.com/droppable/");
	}

	@Test
	public void testDroppable() throws InterruptedException {
		WebElement demoiFrame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(demoiFrame);
		// Or can do by frame index or by ID ^
		AutoBasics.takesScreenshot(this.getDriver(), "Droppable - Before");
		WebElement boxToDrag = getDriver().findElement(By.id("draggable"));
		WebElement placeToDragTo = getDriver().findElement(By.id("droppable"));
		new Actions(getDriver()).clickAndHold(boxToDrag).moveToElement(placeToDragTo).release(placeToDragTo).build()
				.perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Droppable - After");
		Thread.sleep(5000);
	}

}
