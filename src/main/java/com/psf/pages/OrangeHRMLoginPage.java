package com.psf.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.psf.reports.ExtentManager;
import com.psf.reports.ExtentReport;
import com.psf.reports.ExtentLogger;

public final class OrangeHRMLoginPage extends BasePage {

	private final By txt_username = By.name("username");
	private final By txt_password = By.xpath("//input[@type='password' and @name='password']");
	private final By btn_submit = By.xpath("//button[@type='submit']");
	private final By title_error_msg = By.xpath("//p[text()='Invalid credentials']");

	public OrangeHRMLoginPage enterUsername(String username) throws Exception {
		explicitWaitForanElementToBeVisible(txt_username, "Username");
		sendKeys(txt_username, username, "Username");
		ExtentLogger.pass("send keys username");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) throws Exception {
		explicitWaitForanElementToBeVisible(txt_password, "Password");
		sendKeys(txt_password, password, "Password");
//		ExtentReport.test.pass("entered password");
//		ExtentManager.getExtentTest().pass("send keys password");
		return this;
	}

	public OrangeHRMHomepage click_submit() {
		explicitWaitForanElementToBeVisible(btn_submit, "Submit");
		click(btn_submit, "Submit");
//		ExtentManager.getExtentTest().pass("submit clicked");
//		ExtentReport.test.pass("clicked submit button");
//		ExtentLogger.pass("clicked submit button");
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
