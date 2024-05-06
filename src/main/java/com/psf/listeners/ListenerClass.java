package com.psf.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.psf.reports.ExtentLogger;
import com.psf.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// Code to be executed before the test suite starts
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {

		try {
			ExtentReport.flushReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Code to be executed when a test starts
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Code to be executed when a test succeeds
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Code to be executed when a test fails
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
		// screenshots to be attached
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Code to be executed when a test is skipped
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skiped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Code to be executed when a test fails but within success percentage
	}

}
