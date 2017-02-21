package com.sqa.gy.jqueryActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class JQSortableTest extends BasicTest {

	public JQSortableTest(String baseUrl) {
		super("https://jqueryui.com/sortable");
	}

	@Test
	// the 5->1 works. 2-> anywhere does not work. by pixel or by to element.
	// MAYBE because its xpath, which changes as you move it?
	// He says use link text, but not working for him.
	public void testSortable() throws InterruptedException {
		WebElement demoiFrame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(demoiFrame);
		AutoBasics.takesScreenshot(this.getDriver(), "Sortable - Before");
		WebElement item1 = getDriver().findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = getDriver().findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item4 = getDriver().findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = getDriver().findElement(By.xpath("//li[text()='Item 5']"));
		new Actions(getDriver()).clickAndHold(item2).moveToElement(item4).release(item2).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Sortable - After1");
		Thread.sleep(2000);
		AutoBasics.takesScreenshot(this.getDriver(), "Sortable - After1.5");
		new Actions(getDriver()).clickAndHold(item5).moveToElement(item1).release(item5).build().perform();
		AutoBasics.takesScreenshot(this.getDriver(), "Sortable - After2");
		Thread.sleep(2000);
	}

}
