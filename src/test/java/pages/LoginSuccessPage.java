package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {

	WebDriver driver;

	@FindBy(xpath="//a[@class='button secondary radius']")
	WebElement logoutButton;

	@FindBy(id="flash")
	WebElement successMessage;
	
	public LoginSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
