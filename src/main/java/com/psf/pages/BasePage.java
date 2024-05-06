package com.psf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.psf.driver.DriverManager;
import com.psf.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, String element) {
		DriverManager.getDriver().findElement(by).click();
		ExtentLogger.pass(element+ " clicked.");
	}

	protected void sendKeys(By by, String value, String element) throws Exception {
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(value);
		ExtentLogger.pass("Send keys : "+value+" to the element: "+element);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected boolean isDisplayed(By by) {
		ExtentLogger.pass("Is element displayed : "+DriverManager.getDriver().findElement(by).isDisplayed());
		return DriverManager.getDriver().findElement(by).isDisplayed();
	}

	protected void explicitWaitForanElementToBeVisible(By by, String ele) {
		new WebDriverWait(DriverManager.getDriver(), 20)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
		ExtentLogger.pass("Waiting for "+ele+ " to be visible");
	}
}
