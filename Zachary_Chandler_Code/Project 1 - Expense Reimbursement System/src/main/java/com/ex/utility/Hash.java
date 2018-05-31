package com.ex.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String hash(String n) {
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		
		byte[] digest = md.digest(n.getBytes());
		
		StringBuilder result = new StringBuilder();
		
		for (byte b : digest) {
			result.append(String.format("%02x", b));
		}
		
		return result.toString();
	}
	
	public static String hash(String username, String password) {
		return hash(username + password);
	}
}
