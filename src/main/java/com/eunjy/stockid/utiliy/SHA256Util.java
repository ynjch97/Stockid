package com.eunjy.stockid.utiliy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.Data;

@Data
public class SHA256Util {
	
	/*
	 * 
	 * */
	public static String getEncrypt(String source) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(source.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}