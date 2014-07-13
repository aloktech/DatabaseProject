package com.imos.hb.util;

import java.util.logging.Logger;

public class DPLogger {
	
	@SuppressWarnings("rawtypes")
	public static final void info(Logger logger, Class cls, String message) {
		logger.info(cls.getClass().getSimpleName()+ " "+message);
	}
	
	@SuppressWarnings("rawtypes")
	public static final void warning(Logger logger, Class cls, String message) {
		logger.warning(cls.getClass().getSimpleName()+ " "+message);
	}
}
