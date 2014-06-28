package com.util;

public class FormUtil {
	public static boolean isEmailForm(String targetString){
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String email1 = targetString;
		return email1.matches(EMAIL_REGEX);
	}


}
