package com.psf.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.psf.driver.DriverManager;
import com.psf.enums.ConfigProperties;
import com.psf.utils.PropertyFileUtils;

// inorder to not allow engineers to use the methods in ExtentManager, we are creating this. 
public final class ExtentLogger {

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);

	}

//	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
//		if (PropertyFileUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//			ExtentManager.getExtentTest().pass(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
//		}
//		else {
//			pass(message);
//		}
//	}
//	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
//		if (PropertyFileUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//			ExtentManager.getExtentTest().pass(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
//		}else {
//			fail(message);
//		}
//	}
//	
//	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
//		if (PropertyFileUtils.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//			ExtentManager.getExtentTest().pass(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
//		}else {
//			skip(message);
//		}
//	}
// 
//	public static String getBase64Image() {
//		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
//	}

}
