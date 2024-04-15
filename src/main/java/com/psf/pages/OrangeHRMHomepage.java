package com.psf.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.psf.driver.DriverManager;

public class OrangeHRMHomepage extends BasePage {

	private final By dd_userdropdown = By.xpath("//li[@class='oxd-userdropdown']");
	private final By btn_logout = By.xpath("//a[@class='oxd-userdropdown-link' and text()='Logout']");
	private final By title_dashboard = By.xpath("//h6[text()='Dashboard']");

	public OrangeHRMHomepage click_userdropdown() {
		explicitWaitForanElementToBeVisible(dd_userdropdown);
		DriverManager.getDriver().findElement(dd_userdropdown).click();
		return this;
	}

	public OrangeHRMLoginPage click_logout_btn() {
		explicitWaitForanElementToBeVisible(btn_logout);
		click(btn_logout);
		return new OrangeHRMLoginPage();
	}

	public boolean verify_dashboard_title_is_visible() {
		return isDisplayed(title_dashboard);
	}

}
