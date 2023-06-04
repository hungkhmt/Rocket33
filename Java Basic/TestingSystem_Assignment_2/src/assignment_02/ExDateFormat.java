package assignment_02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExDateFormat {
	public static void printExamDateWithVNFormat(Exam e) {
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(e.createDate);
		System.out.println("\tID: " + e.id);
		System.out.println("\tCode: " + e.code);
		System.out.println("\tTitle: " + e.title);
		System.out.println("\tCategory: " + e.categoryID.name);
		System.out.println("\tDuration: " + e.duration);
		System.out.println("\tCreator: " + e.creatorID.fullName);
		System.out.println("\tCreateDate: " + date + "\n");
	}
	
	public static void printExamDateWithFormat(Exam e) {
		String pattern = "yyyy-MM-dd-hh-mm-ss";
		SimpleDateFormat simpDateFormat = new SimpleDateFormat(pattern);
		String date = simpDateFormat.format(e.createDate);
		System.out.println("\tID: " + e.id);
		System.out.println("\tCode: " + e.code);
		System.out.println("\tTitle: " + e.title);
		System.out.println("\tCategory: " + e.categoryID.name);
		System.out.println("\tDuration: " + e.duration);
		System.out.println("\tCreator: " + e.creatorID.fullName);
		System.out.println("\tCreateDate: " + date + "\n");
	}
}
