/**
 * 
 */
package com.psf.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.psf.constants.FrameWorkConstants;

/**
 * @author prabh
 *
 */
public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigfilepath());
			property.load(file);
			property.entrySet()
			.forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) throws Exception {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
			throw new Exception("Property name " + key + " is not found.");
		}
		return CONFIGMAP.get(key);

	}

}
