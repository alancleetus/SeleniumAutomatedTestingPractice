package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id="username")
	WebElement usernameBox;

	@FindBy(id="password")
	WebElement passwordBox;

	@FindBy(tagName="button")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String username) {
		usernameBox.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}
	
	public LoginSuccessPage validLogin(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLogin();
		
		return new LoginSuccessPage(driver);
	}

}
