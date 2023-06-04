package assignment_02;

import java.util.Date;
import java.util.Scanner;


import assignment_02.Position.PositionName;

public class InputFromConsole {
	public static Scanner sc = new Scanner(System.in);
	public static void inputThreeNum() {
		int a,b,c;
		System.out.print("Nhap a = ");
		a = sc.nextInt();
		System.out.println("Ban vua nhap a = " + a);
		System.out.print("Nhap b = ");
		b = sc.nextInt();
		System.out.println("Ban vua nhap b = " + b);
		System.out.print("Nhap c = ");	
		c = sc.nextInt();
		System.out.println("Ban vua nhap c = " + c);
	}
	
	public static void inputFullName() {
		System.out.print("Nhap ho ten: ");
		String name = sc.nextLine();
		System.out.println("Ten cua ban la: " + name);
	}
	
	public static void createAcc() {
//		Account a = new Account();
//		System.out.println("Nhap thong tin account");
//		System.out.print("ID: ");
//		byte accId = sc.nextByte();
//		System.out.print("Email: ");
//		String accEmail = sc.next();
//		System.out.println("Full name: ");
//		String accFullName = sc.nextLine();
//		System.out.println("Department ID: ");
//		byte deptId = sc.nextByte();
//		System.out.println("Position ID: ");
//		byte posId = sc.nextByte();
//		System.out.println("CreateDate: ");
//		Date accCreateDate = new Date();
		
		
		System.out.println("Tạo account");
		System.out.println(" Nhập vào Id: ");
		byte id = sc.nextByte();

		System.out.println("Mời bạn nhập email: ");
		String email = sc.next();

		System.out.println("Mời bạn nhập username: ");
		String username = sc.next();
		
		sc.nextLine();
		
		System.out.println("Mời bạn nhập fullname: ");
		String fullname = sc.nextLine();

		System.out.println("Mời bạn nhập tên phòng ban: ");
		String departmentName = sc.nextLine();
		
		PositionName posName = Position.PositionName.DEV;
		boolean isCheck = false;
		while(isCheck == false) {
			System.out.println("Nhap ma position: ");
			int postId = sc.nextInt();
			switch(postId) {
			case 1:
				posName = Position.PositionName.DEV;
				isCheck = true;
				break;
			case 2:
				posName = Position.PositionName.TEST;
				isCheck = true;
				break;
			case 3:
				posName = Position.PositionName.PM;
				isCheck = true;
				break;
			case 4:
				posName = Position.PositionName.SCRUM_MASTER;
				isCheck = true;
				break;
			default:
				isCheck = false;
				break;
			}
		}
		
		
		Account account = new Account();
		account.id = id;
		account.email = email;
		account.userName = username;
		account.fullName = fullname;

		Department department = new Department();
		department.id = 1;
		department.name = departmentName;
		
		account.departmentID = department;

		Position position = new Position();
		position.id = 1;
		position.name = posName;
		
		account.positionID = position;

		System.out.println("Account của bạn đã được tạo ");
		System.out.println("email: " + email);
		System.out.println("username: " + username);
		System.out.println("fullname: " + fullname);
		System.out.println("departmentName: " + departmentName);
		System.out.println("positionName: " + posName);
		
		
		
	}
}
