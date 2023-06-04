package assignment_02;

import java.util.Random;
import java.time.LocalDate;

public class RandomNumber {
	public static void printIntRand() {
		Random rand = new Random();
		
		int x = rand.nextInt();
		System.out.println("So ngau nhien: " + x);
	}
	
	public static void printFloatRandom() {
		Random rand = new Random();
		
		float x = rand.nextFloat();
		System.out.println("So ngau nhien: " + x);
	}
	
	public static void printRandName() {
		String[] name = {"Yen", "Dung", "Son", "Hoang", "Mai", "Duc"};
		
		Random rand = new Random();
		
		int x = rand.nextInt(name.length);
		System.out.println("So ngau nhien: " + name[x]);
	}
	
	public static void randTime() {
		Random rand = new Random();
		
		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		
		long randInt = minDay + rand.nextInt(maxDay-minDay);
		
		LocalDate randDay = LocalDate.ofEpochDay(randInt);
		
		System.out.println(randDay);
	}
	
	public static void randThreeDigitNum() {
		Random rand = new Random();
		
		//100->999
		int randInt = rand.nextInt(999-100+1) + 100;
		System.out.println(randInt);
	}
}
