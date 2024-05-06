package com.psf.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.psf.enums.ConfigProperties;
import com.psf.utils.PropertyFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			//			System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath());
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.getDriver().get(PropertyFileUtils.getValue(ConfigProperties.URL));
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
