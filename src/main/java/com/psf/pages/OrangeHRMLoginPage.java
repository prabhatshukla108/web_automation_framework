package com.psf.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.psf.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage{

	private final By txt_username = By.name("username");
	private final By txt_password = By.xpath("//input[@type='password' and @name='password']");
	private final By btn_submit = By.xpath("//button[@type='submit']");
	private final By title_error_msg = By.xpath("//p[text()='Invalid credentials']");

	public OrangeHRMLoginPage enterUsername(String username) {
		explicitWaitForanElementToBeVisible(txt_username);
		sendKeys(txt_username, username);
		System.out.println("Entered username : " + username);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		explicitWaitForanElementToBeVisible(txt_password);
		sendKeys(txt_password,password);
		System.out.println("Entered password : " + password);
		return this;
	}

	public OrangeHRMHomepage click_submit() {
		explicitWaitForanElementToBeVisible(btn_submit);
		click(btn_submit);
		System.out.println("Clicked Submit button");
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
		return new OrangeHRMHomepage();
	}

	public boolean verify_error_msg() {
		return isDisplayed(title_error_msg);
	}

	public String get_title() {
		return getPageTitle();
	}
}
