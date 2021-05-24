package com.eunjy.stockid.utiliy;

import org.apache.tomcat.util.codec.binary.Base64;

public class StringUtil {

	// null 또는 빈값 체크
	public static boolean isEmpty(String str) {
		if ( str == null || str.length() == 0 || "".equals(str) ) {
			return true;
		}
		return false;
	}
	
	// javascript 상에서 Base64 인코딩 된 문자열 디코딩
	public static String decode(String str) {
		if ( isEmpty(str) ) {
			return "";
		}
		return new String(Base64.decodeBase64(Base64.decodeBase64(str)));
	}
	
}
