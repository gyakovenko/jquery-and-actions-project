package com.sqa.gy.jqueryActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.sqa.gy.helpers.*;

public class JQSelectableTest extends BasicTest {

	public JQSelectableTest(String baseUrl) {
		super("https://jqueryui.com/selectable/");
	}

	@Test
	public void testSelectable() throws InterruptedException {
		WebElement demoiFrame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(demoiFrame);

		AutoBasics.takesScreenshot(this.getDriver(), "MultiSelect - Before");
		WebElement select2 = getDriver().findElement(By.xpath("//ol[@id='selectable']/li[2]"));
		WebElement select5 = getDriver().findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		// WebElement select2 =
		// getDriver().findElement(By.cssSelector("li.ui-selectee:nth-child(2)"));
		// WebElement select5 =
		// getDriver().findElement(By.cssSelector("li.ui-selectee:nth-child(5)"));
		new Actions(getDriver()).keyDown(Keys.COMMAND).click(select2).click(select5).keyUp(Keys.COMMAND).build()
				.perform();
		AutoBasics.takesScreenshot(this.getDriver(), "MultiSelect - After");
		Thread.sleep(5000);
	}

}
