package com.psf.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.psf.constants.FrameWorkConstants;

public final class ExtentReport {
	private ExtentReport() {
	}

	private static ExtentReports extent;
	public static ExtentTest test;

	// initialize extent report
	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentreportpath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Test Report");
			spark.config().setReportName("OrangeHRM");
		}
	}

	// create report
	public static void flushReports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentreportpath()).toURI());
	}

	// create the tests
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
//		test = extent.createTest(testcasename);

	}
}