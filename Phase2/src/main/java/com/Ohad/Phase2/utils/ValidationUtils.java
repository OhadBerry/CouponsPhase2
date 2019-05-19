package com.Ohad.Phase2.utils;

import com.Ohad.Phase2.exceptions.ApplicationException;

public class ValidationUtils {
	
	public static boolean isValidString (String string) throws ApplicationException {
		if (string == null) {
			return false;
		}
		if (string.length() <2) {
			return false;
		}
		return true;
		
	}
}
