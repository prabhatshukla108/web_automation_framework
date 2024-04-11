package com.psf.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.psf.driver.Driver;
import com.psf.driver.DriverManager;

public final class LoginPageTest extends BaseTest {
	// reason to keep class as final : NO ONE CAN EXTEND IT.
	// REASON TO KEEP PRIVATE CONSTRUCTOR : not allow to create object from base
	// layers.

	private LoginPageTest() {

	}

	

	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
	}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation with Prabhat", Keys.ENTER);
	}

}
