package tests.loginPageTest;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LoginSuccessPage;
import tests.BaseTest;
import org.testng.Assert; 

public class LoginPageTest extends BaseTest {

	@Test
	public void testLogin() {

		log.info("starting login page test");
		driver.get(cr.getLoginUrl());

		LoginPage loginPage = new LoginPage(driver);

		LoginSuccessPage successPage = loginPage.validLogin("tomsmith", "SuperSecretPassword!");

		// Verifications:
		//		url is correct
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

		// 		log out button is visible
		Assert.assertTrue(successPage.getLogoutButton().isDisplayed(), "logOutButton is not visible.");

		// 		Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		Assert.assertTrue(successPage.getSuccessMessage().contains(expectedSuccessMessage));
	}
}
