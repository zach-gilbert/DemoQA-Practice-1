/*
 * DemoQATest1 - Test to verify the title of the homepage.
 */

package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DemoQATest1 {
	private WebDriver driver;

	@BeforeTest
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void verifyHomepageTitle() {
		/*
		 * Checks the homepage title
		 * Expected: pass
		 */
		
		String expectedTitle = "ToolsQA";
		String foundTitle;
		
		driver.get("https://demoqa.com");
		foundTitle = driver.getTitle();
		
		Assert.assertEquals(foundTitle, expectedTitle);
	}
	
	@Test
	public void verifyHomepageTitle2() {
		/*
		 * Checks the homepage title
		 * Expected: fail
		 */
		
		String expectedTitle = "QaStuff";
		String foundTitle;
		
		driver.get("https://demoqa.com");
		foundTitle = driver.getTitle();
		
		Assert.assertEquals(foundTitle, expectedTitle);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
