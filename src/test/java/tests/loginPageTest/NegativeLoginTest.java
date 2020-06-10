package tests.loginPageTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginFailurePage;
import pages.LoginPage;
import tests.BaseTest;
 
public class NegativeLoginTest extends BaseTest {
 
	@Test(priority = 1, dataProvider = "getData")
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");
		driver.get(cr.getLoginUrl());

		LoginPage loginPage = new LoginPage(driver);
		LoginFailurePage failPage = loginPage.invalidLogin(username, password);
				
		// Verification
		String actualErrorMessage = failPage.getErrorMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	} 

	@DataProvider(name="getData") // supplying data for a test method.
	public Object[][] getData()  {
		return new Object[][] { 
			{ "wrongusername", "SuperSecretPassword!", "Your username is invalid!" }, 
			{ "tomsmith", "wronPassword", "Your password is invalid!" }  };

	}

}