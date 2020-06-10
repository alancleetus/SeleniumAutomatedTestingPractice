package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFailurePage {

	WebDriver driver;

	@FindBy(id = "flash")
	WebElement errorMessage;

	public LoginFailurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
