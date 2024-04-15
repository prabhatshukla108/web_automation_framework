package com.psf.constants;

public final class FrameWorkConstants {
	// reason to keep class as final : NO ONE CAN EXTEND IT.
	// REASON TO KEEP PRIVATE CONSTRUCTOR : not allow to create object from base
	// layers.

	private FrameWorkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";
	private static final String CHROMEDRIVEPATH = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe";

	public static String getChromeDriverPath() {
		return CHROMEDRIVEPATH;
	}
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

}
