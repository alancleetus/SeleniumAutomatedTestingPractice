package tests.dropDownTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTest;

public class DropDownTest extends BaseTest{
	
	@Test
	public void testDropDown() {
		log.info("starting login page test");
		driver.get(cr.getDropdownUrl());
		Select dropdown = new Select(
				driver.findElement(By.id("dropdown")));

		//dropdown.selectByIndex(1);
		//dropdown.selectByValue("1");
		//dropdown.selectByVisbileText("Option 1");
		
		log.info("Dropdown options:");
		for(WebElement s : dropdown.getOptions()) {
			System.out.println("\t"+s.getText().toString());
		}
		
		dropdown.selectByValue("1");
		
		log.info("Current selection: "+ dropdown.getFirstSelectedOption().getText() );
		Assert.assertEquals( dropdown.getFirstSelectedOption().getText(), "Option 1");
		
		dropdown.selectByValue("2");
		
		log.info("Current selection: "+ dropdown.getFirstSelectedOption().getText() );
		Assert.assertEquals( dropdown.getFirstSelectedOption().getText(), "Option 2");
		
	}

}
