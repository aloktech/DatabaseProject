package com.imos.hb.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class DPLogger {
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");
	
	@SuppressWarnings("rawtypes")
	public static final void info(Class cls, String key, String ... msg) {
		Logger.getLogger(cls.getSimpleName()).info(MessageFormat.format(RESOURCE_BUNDLE.getString(key), cls.getName(), msg));
	}
	
	@SuppressWarnings("rawtypes")
	public static final void warning(Class cls, String key, String ... msg) {
		Logger.getLogger(cls.getSimpleName()).warning(MessageFormat.format(RESOURCE_BUNDLE.getString(key), cls.getName(), msg));
	}
}
