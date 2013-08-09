package ru.buildmgr.web.common.utils;

public class StringUtils {

	public static boolean isNull(String value) {
		return value == null || value.trim().length() == 0;
	}

	public static boolean isNotNull(String value) {
		return !isNull(value);
	}
}
