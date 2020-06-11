package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CheckboxTest extends BaseTest{
	
	@Test
	public void testCheckbox() {
		log.info("starting login page test");
		driver.get(cr.getBaseUrl()+"/checkboxes");
		
		for(WebElement checkbox: driver.findElements(By.tagName("input"))){
			log.info("before clicking: "+checkbox.isSelected());
			checkbox.click();
			log.info("after clicking: "+checkbox.isSelected());
		}
	}
}
