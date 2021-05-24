package com.eunjy.stockid.utiliy;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if ( str == null || str.length() == 0 || "".equals(str) ) {
			return true;
		}
		return false;
	}
	
}
