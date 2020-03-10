package com.ibayad.aldwin.baseactivitywithbk;

/**
 * Created and Coded by:
 * Aldwin and Josef
 * iBayad Online Ventures Inc.
 * (c) 2020
 */

class StringUtil {
	
	private static Boolean isNullOrEmpty (String string) {
		return string.trim().length() == 0 || string.equalsIgnoreCase("");
	}
	
	@SuppressWarnings("SameParameterValue")
	static String trimChars (String string, Integer numOfChars) throws Exception {
		if (isNullOrEmpty(string)) {
			throw new Exception("String can not be empty.");
		} else if (string.length() > numOfChars) {
			return string.substring(0, numOfChars);
		} else if (numOfChars == 0 || string.length() <= numOfChars) {
			return string;
		} else {
			return "";
		}
	}
	
}