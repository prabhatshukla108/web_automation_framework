package com.psf.pages;

import org.openqa.selenium.By;

public class OrangeHRMHomepage extends BasePage {

	private final By dd_userdropdown = By.xpath("//li[@class='oxd-userdropdown']");
	private final By btn_logout = By.xpath("(//a[@class = 'oxd-userdropdown-link'])[4]");
	private final By title_dashboard = By.xpath("//h6[text()='Dashboard']");

	public OrangeHRMHomepage click_userdropdown() {
		explicitWaitForanElementToBeVisible(dd_userdropdown, "Userdropdown");
		click(dd_userdropdown, "Userdropdown");
//		ExtentLogger.pass("Dropdown clicked");
		return this;
	}

	public OrangeHRMLoginPage click_logout_btn() {
		explicitWaitForanElementToBeVisible(btn_logout, "Logout");
//		ExtentLogger.pass("clicked Logout button");
		click(btn_logout, "Logout");
		
		return new OrangeHRMLoginPage();
	}

	public boolean verify_dashboard_title_is_visible() {
		
		return isDisplayed(title_dashboard);
	}

}
