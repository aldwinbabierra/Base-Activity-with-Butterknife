package com.ibayad.aldwin.baseactivitywithbk;

class StringUtil {
	
	private static Boolean isNullOrEmpty (String string) {
		return string.trim().length() == 0 || string == null;
	}
	
	static String trimChars (String string, Integer numOfChars) {
		if (isNullOrEmpty(string)) {
			throw new RuntimeException("String can not be empty!");
		} else if (numOfChars == 0) {
			return "";
		} else if (numOfChars < string.length()) {
			return string.substring(0, numOfChars);
		} else if (numOfChars > string.length()) {
			throw new RuntimeException("String is too short!");
		} else if (string.length() == numOfChars) {
			return string;
		} else {
			return "";
		}
	}
	
}