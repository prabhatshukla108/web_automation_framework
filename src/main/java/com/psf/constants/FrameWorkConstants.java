package com.psf.constants;

import com.psf.enums.ConfigProperties;
import com.psf.utils.PropertyFileUtils;

public final class FrameWorkConstants {
	// reason to keep class as final : NO ONE CAN EXTEND IT.
	// REASON TO KEEP PRIVATE CONSTRUCTOR : not allow to create object from base
	// layers.

	private FrameWorkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";
	private static final String CHROMEDRIVEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/executables/chromedriver.exe";
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output";

	public static String getChromeDriverPath() {
		return CHROMEDRIVEPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getExtentreportpath() throws Exception {
//		if (PropertyFileUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
//			return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "index.html";
//		} else {
			return EXTENTREPORTPATH + "/" + "index.html";
//		}
	}

}
