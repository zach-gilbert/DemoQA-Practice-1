/*
 * DemoQATest2 - Manipulating and comparing text box elements.
 */

package Selenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DemoQATest2 {
	private WebDriver driver;
	private WebElement name, email, currentAddress, permanentAddress;

	@BeforeClass
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Method 1: Fill data into elements (pass).
	@Test (priority = 1)
	public void fillBoxes() {
		/* Access Text Box webpage */
		driver.get("https://demoqa.com/elements");
		driver.findElement(By.xpath("//*[@id=\"item-0\"]")).click(); // Clicks text box button.
		
		/* Identify elements */
		name = driver.findElement(By.xpath("//input[@id='userName']"));
		email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		
		/* Enter data into elements */
		name.sendKeys("John Smith");
		email.sendKeys("myemail@gmail.com");
		currentAddress.sendKeys("12345 Banana St.");
		permanentAddress.sendKeys("12345 Banana St.");
	}
	
	// Method 2: Retrieve data from elements and compare (pass). 
	@Test (priority = 2)
	public void compareData1() {
		/* Expected Data */
		String expectedName = "John Smith",
		expectedEmail = "myemail@gmail.com",
		expectedCurrentAddress = "12345 Banana St.",
		expectedPermanentAddress = "12345 Banana St.";
		
		/* Compare data */
		Assert.assertEquals(name.getAttribute("value"), expectedName);
		Assert.assertEquals(email.getAttribute("value"), expectedEmail);
		Assert.assertEquals(currentAddress.getAttribute("value"), expectedCurrentAddress);
		Assert.assertEquals(permanentAddress.getAttribute("value"), expectedPermanentAddress);
	}
	
	// Method 3: Retrieve data from elements and compare (fail).
	@Test (priority = 3)
	public void compareData2() {
		/* Expected Data */
		String expectedName = "John Smith",
		expectedEmail = "myemail@gmail.com",
		expectedCurrentAddress = "12345 Apple St.", // Incorrect Street
		expectedPermanentAddress = "12345 Apple St."; // Incorrect Street
		
		/* Compare data */
		Assert.assertEquals(name.getAttribute("value"), expectedName);
		Assert.assertEquals(email.getAttribute("value"), expectedEmail);
		Assert.assertEquals(currentAddress.getAttribute("value"), expectedCurrentAddress);
		Assert.assertEquals(permanentAddress.getAttribute("value"), expectedPermanentAddress);
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

}
