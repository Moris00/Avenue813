package it.avenue813.utils;

import java.util.Base64;

public class Utility {
	public static void print(String... messages) {
		String message="";
		
		for(String s: messages) {
			message += s+ "\n";
		}
		
		System.out.printf("%s", message);
	}
	
	public static void print(Exception exception) {
		Utility.print("EXCEPTION: "+ exception.getMessage());
		exception.printStackTrace();
	}
	
	public static String encode(String stringa) { 
		byte[] encodeBytes = Base64.getEncoder().encode(stringa.getBytes());
		return new String(encodeBytes);
	}
	
	public static String decode(String stringa) {
		byte[] decodeBytes = Base64.getDecoder().decode(stringa.getBytes());
		return new String(decodeBytes);
	}
}
