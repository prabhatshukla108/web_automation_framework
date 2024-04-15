package com.psf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.psf.driver.DriverManager;

public class BasePage {

	protected void click(By by) {
		DriverManager.getDriver().findElement(by).click();
	}

	protected void sendKeys(By by, String value) {
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected boolean isDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();
	}

	protected void explicitWaitForanElementToBeClickable(By by) {
		new WebDriverWait(DriverManager.getDriver(), 20)
		.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected void explicitWaitForanElementToBeVisible(By by) {
		new WebDriverWait(DriverManager.getDriver(), 20)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
