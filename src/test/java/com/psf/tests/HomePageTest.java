package com.psf.tests;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.psf.driver.DriverManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	/**
	 * validate the title is having google search or not validate the title is not
	 * null and length is less than 100 and greater than 15 verify the link verify
	 * the number of links displayed id exactly 10 or 15.
	 */
	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation with Prabhat", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "google search"));
		Assert.assertTrue(title.length() > 15);
		Assert.assertTrue(title.length() < 100);
		List<WebElement> links = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		Assert.assertEquals(links.size(), 10);
	}

}
