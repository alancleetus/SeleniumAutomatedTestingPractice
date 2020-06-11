package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class FrameTest extends BaseTest {

	@Test
	public void testFrame() {
		driver.get(cr.getFrameUrl());
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		WebElement content = driver.findElement(By.cssSelector("div#content"));
		log.info("current frame content = " + content.getText());
		Assert.assertEquals(content.getText(), "MIDDLE");
	}

}
