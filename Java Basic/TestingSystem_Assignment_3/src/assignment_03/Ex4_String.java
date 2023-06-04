package assignment_03;

import java.util.Scanner;

public class Ex4_String {
	public static Scanner sc = new Scanner(System.in);
	public static void countCharacter() {
		System.out.print("Nhap mot xau: ");
		String str = sc.nextLine();
		System.out.println("So luong ky tu chua khoang trang trong xau vua nhap la: " + str.length());
		str = str.replaceAll("\\s+", "");
		System.out.println("So luong ky tu khong chua khoang trang trong xau vua nhap la: " + str.length());
	}
	
	public static void connectString() {
		System.out.println("Nhap xau 1: ");
		String str1 = sc.nextLine();
		System.out.println("Nhap xau 2: ");
		String str2 = sc.nextLine();
		System.out.println("Noi xau 2 vao sua xau 1: " + str1.concat(str2));
	}
	
	public static void stringUperCase() {
		System.out.println("Nhap ten: ");
		String str = sc.nextLine();
		String[] tmp = str.split(" ");
		String str1 = "";

		for(int i=0; i<tmp.length; i++) {
			tmp[i] = tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1);
			str1 += tmp[i] + " ";
		}
		str1 = str1.substring(0, str1.length()-1);
		System.out.println("Ten sau khi kiem tra: " + str1);
	}
	
	public static void printNameCharacters() {
		System.out.println("Nhap ten: ");
		String str = sc.nextLine();
		for(int i=0; i<str.length(); i++) {
			System.out.println("Ky tu thu " + i + " la: " + str.charAt(i));
		}
	}
	
	public static void printFullName() {
		System.out.println("Nhap ho cua ban: ");
		String str1 = sc.nextLine();
		System.out.println("Nhap vao ten cua ban: ");
		String str2 = sc.nextLine();
		System.out.println("Ho ten cua ban la: " + str1 + " " + str2);
	}
	
	public static void splitFullName() {
		System.out.println("Nhap ho ten: ");
		String str = sc.nextLine();
		String[] tmp = str.split(" ");
		System.out.println("Ho la: " + tmp[0]);
		System.out.print("Ten dem la: ");
		for(int i=1; i<tmp.length-1; i++) {
			System.out.print(tmp[i] + " ");
		}
		System.out.println("\nTen la: " + tmp[tmp.length-1]);
	}
	
	public static void normalizeName() {
		//Cau a
		System.out.println("Nhap ho ten: ");
		String str = sc.nextLine();
		String[] tmp = str.split("\\s+");
		String str1 = "";

		for(int i=0; i<tmp.length; i++) {
			if(tmp[i] == " ") {
				System.out.println("oj");
				continue;
			}	
			str1 += tmp[i] + " ";
		}
		if(str1.indexOf(" ") == 0) {
			str1 = str1.substring(1, str1.length()-1);
		} else {
			str1 = str1.substring(0, str1.length()-1);
		}
		
		System.out.println("Ten sau khi chuan hoa: \"" + str1 + "\"");
		
		//Cau b: Đã thực hiện tại hàm stringUperCase()
	}
	
	public static void printGroupHasJava(Group[] g) {
		for(Group o:g) {
			if(o.name.indexOf("Java") != -1) {
				System.out.println("Id: " + o.id);
				System.out.println("Name: " + o.name);
				System.out.println("Creator: " + o.creatorID.fullName);
				System.out.println("CreateDate: " + o.createDate);
			}
		}
	}
	
	public static void printGroupJava(Group[] g) {
		for(Group o:g) {
			if(o.name == "Java") {
				System.out.println("Id: " + o.id);
				System.out.println("Name: " + o.name);
				System.out.println("Creator: " + o.creatorID.fullName);
				System.out.println("CreateDate: " + o.createDate);
			}
		}
	}
}
