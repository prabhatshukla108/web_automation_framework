package com.psf.driver;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.psf.constants.FrameWorkConstants;
import com.psf.utils.ReadPropertyFile;

public class Driver {

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}
