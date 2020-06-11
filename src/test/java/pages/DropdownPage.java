package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
	WebDriver driver;
 
	Select dropdown;
		
	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		dropdown = new Select(driver.findElement(By.id("dropdown")));
	}

	public String getAllOptions() {
		String s = "DropDown Options: ";
		for(WebElement w : dropdown.getOptions()) {
			s += (w.getText().toString()+"; ");
		}
		return s;
	}
	
	public void selectByValue(String value) {
		dropdown.selectByValue(value);
	}
	
	public void selectByText(String text) {
		dropdown.selectByVisibleText(text);
	}
	
	public void selectByIndex(int index) {
		dropdown.selectByIndex(index);
	}
	
	public String getSelected() {
		return dropdown.getFirstSelectedOption().getText();
	}
}
