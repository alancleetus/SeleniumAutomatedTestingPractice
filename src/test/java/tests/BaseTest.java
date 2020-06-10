package tests;

import org.testng.annotations.Test;

import tests.utilities.ConfigReader;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;
	protected Logger log;
	protected ConfigReader cr;

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {

		log = LogManager.getLogger(ctx.getCurrentXmlTest().getName());
		
		log.info("running setUp()");
		cr = new ConfigReader();

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", cr.getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", cr.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.chrome.driver", cr.getEdgePath());
			driver = new EdgeDriver();
		} else {
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", cr.getChromePath());
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		log.info("running tearDown()");
		driver.quit();
	}

}
