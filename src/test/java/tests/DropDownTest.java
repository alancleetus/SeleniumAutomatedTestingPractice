package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.DropdownPage;
public class DropDownTest extends BaseTest {

	@Test
	public void testDropDown() {
		driver.get(cr.getDropdownUrl());
		DropdownPage dropdownPage = new DropdownPage(driver);
		
		log.info(dropdownPage.getAllOptions());

		dropdownPage.selectByValue("1");
		Assert.assertEquals(dropdownPage.getSelected(), "Option 1");

		dropdownPage.selectByText("Option 2");
		Assert.assertEquals(dropdownPage.getSelected(), "Option 2");
	}
}
