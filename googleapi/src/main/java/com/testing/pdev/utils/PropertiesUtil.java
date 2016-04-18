package com.testing.pdev.utils;

import java.io.IOException;
import java.util.Properties;

import com.testing.pdev.exceptions.GoogleApiUtilException;

public class PropertiesUtil {
	
	private static Properties properties;
	
	private PropertiesUtil(){}
	
	public static String getProperty(String key) throws GoogleApiUtilException{
		String value = ConstantPool.BLANK;
		if(properties != null){
			value = properties.getProperty(key);
		}else{
			loadProperties();
			value = properties.getProperty(key);
		}
		return value;
	}

	private static void loadProperties() throws GoogleApiUtilException{
		// load property file
		try {
			properties = new Properties();
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(ConstantPool.APPLICATION_PROPERTIES));
		} catch (IOException e) {
			String error = new StringBuffer("Exception while loading properties file").toString();
			throw new GoogleApiUtilException(error, e.getCause());
		}
	}

}
