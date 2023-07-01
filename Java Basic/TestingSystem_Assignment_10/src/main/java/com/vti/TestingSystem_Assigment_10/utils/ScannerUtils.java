package com.vti.TestingSystem_Assigment_10.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		int output = 0; 
		while (true) {
			try {
				String iput = sc.nextLine();
				output = Integer.valueOf(iput).intValue();
				return output;
			} catch (NumberFormatException e) { 
				System.out.println(errorMessage);				
			}
		} 
	}
	
	public static float inputFloat(String errorMessage) {
		float output = 0;
		while (true) {
			try {
				String iput = sc.nextLine();
				output = Float.valueOf(iput).floatValue();
				return output;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);				
			}
		}
	}
	
	public static double inputDouble(String errorMessage) {
		double output = 0;
		while (true) {
			try { 
				String iput = sc.nextLine();
				output = Double.valueOf(iput).doubleValue();
				return output;
			} catch (NumberFormatException e) { 
				System.out.println(errorMessage);				
			}
		} 
	}
	
	public static byte inputByte(String errorMessage) {
		byte output = 0; 
		while (true) {
			try {
				String iput = sc.nextLine();
				output = Byte.valueOf(iput).byteValue();
				return output;
			} catch (NumberFormatException e) { 
				System.out.println(errorMessage);				
			}
		} 
	}
	
	public static String inputString() {
		return sc.nextLine();
	}

}
