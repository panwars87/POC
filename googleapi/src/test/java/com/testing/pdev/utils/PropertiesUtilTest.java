package com.testing.pdev.utils;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

import com.testing.pdev.exceptions.GoogleApiUtilException;

public class PropertiesUtilTest {
	
	@Test
	public void testGetProperty() {
		try {
			assertEquals("root",PropertiesUtil.getProperty(ConstantPool.DB_USERNAME));
		} catch (GoogleApiUtilException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
