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
import com.psf.enums.ConfigProperties;

/**
 * @author prabh
 *
 */
public final class PropertyFileUtils {

	private PropertyFileUtils() {

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

	public static String getValue(ConfigProperties key) throws Exception {

		if (Objects.isNull(key.name().toLowerCase()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());

	}

}
