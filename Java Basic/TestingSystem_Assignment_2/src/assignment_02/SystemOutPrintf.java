package assignment_02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SystemOutPrintf {
	public static void prinfInt() {
		int n=5;
		System.out.printf("%d", n);
	}
	
	public static void printfInt2() {
		int n = 100000000;
		System.out.printf(Locale.US, "%,d", n);
	}
	
	public static void printfFloat() {
		double n = 5.567098;
		System.out.printf("%.4f", n);
	}
	
	public static void printText() {
		String n = "Nguyen Van A";
		System.out.printf("%60s","Ten toi la \"" + n + "\" va toi dang doc than.");
	}
	
	public static void printFormatTime() {
		String pattern = "dd-MM-yyyy hh'h':mm'p':ss's'";
		SimpleDateFormat simpDateFormat = new SimpleDateFormat(pattern);
		String date = simpDateFormat.format(new Date());
		System.out.println(date);
	}
	
	public static void printAccLikeSql(Account[] a) {
		System.out.printf("%-25s %-25s %-15s %n", "Email", "Full name", "Department");
		for(Account o:a) {			
			System.out.printf("%-25s %-25s %-15s %n", o.email, o.fullName, o.departmentID.name);
		}
	}
}
