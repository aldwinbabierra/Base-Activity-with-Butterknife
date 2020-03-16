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
	
	@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
	protected static String trimChars (String string, Integer numOfChars) {
		try {
			if (isNullOrEmpty(string)) {
				return null;
			} else if (string.length() > numOfChars) {
				return string.substring(0, numOfChars);
			} else if (numOfChars == 0 || string.length() <= numOfChars) {
				return string;
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return string;
	}
	
}