package assignment_02;

public class FlowControl {
	public static void checkDeptNull(Account a) {
		if(a.departmentID == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			System.out.println("Phong ban cua nhan vien nay la: " + a.departmentID.name);
		}
	}
	
	public static void checkGroup(Group[] g) {
		int dem=0;
		for(Group t:g) {
			if(t.accounts[0].id == 2 || t.accounts[1].id == 2) {
				dem++;
			}
		}
		if(dem==0) {
			System.out.println("Nhan vien nay chua co Group");
		} else if(dem==1 || dem==2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if(dem == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if(dem==4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
	}
	
	public static void checkDeptNullTernary(Account a) {
		System.out.println((a.departmentID == null) ? ("Nhan vien nay chua co phong ban") : ("Phong ban cua nhan vien nay la: " + a.departmentID.name));
	}
	
	public static void checkPosAccTernary(Account a) {
		System.out.println((a.positionID.name.equals("DEV")) ? ("Day la Developer") : ("Nguoi nay khong phai Developer"));
	}
	
	public static void getAccInGroup(Group g) {
		int dem=g.accounts.length;
		switch(dem) {
		case 1:
			System.out.println("Nhom co 1 thanh vien");
			break;
		case 2:
			System.out.println("Nhom co 2 thanh vien");
			break;
		case 3:
			System.out.println("Nhom co 3 thanh vien");
			break;
		default:
			System.out.println("Nhom co nhieu thanh vien");
			break;
		}		
	}
	
	public static void checkGroupSwitchCase(Group[] g) {
		int dem=0;
		for(Group t:g) {
			if(t.accounts[0].id == 2 || t.accounts[1].id == 2) {
				dem++;
			}
		}
		switch(dem) {
		case 0:
			System.out.println("Nhan vien nay chua co Group");
			break;
		case 1, 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		case 4:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}		
	}
	
	public static void checkPosAccSwitchCase(Account a) {
		switch(a.positionID.name.toString()) {
		case "DEV":
			System.out.println("Day la Developer");
			break;
		default:
			System.out.println("Nguoi nay khong phai Developer");
			break;
		}
	}
	
	public static void printAccountForE(Account[] a) {
		for(Account o:a) {
			System.out.println("Email: " + o.email);
			System.out.println("Full name: " + o.fullName);
			System.out.println("Department: " + o.departmentID.name);
		}
	}
	
	public static void printDeptForE(Department[] d) {
		for(Department o:d) {
			System.out.println("ID: " + o.id);
			System.out.println("Name: " + o.name);
		}
	}
	
	public static void printAccFor(Account[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.println("Thong tin account thu " + (i+1) + " la: ");
			System.out.println("Email: " + a[i].email);
			System.out.println("Full name: " + a[i].fullName);
			System.out.println("Phong ban: " + a[i].departmentID.name);
		}
	}
	
	public static void printDeptFor(Department[] d) {
		for(int i=0; i<d.length; i++) {
			System.out.println("Thong tin department thu " + (i+1) + " la:");
			System.out.println("Id: " + d[i].id);
			System.out.println("Name: " + d[i].name);
		}
	}
	
	public static void printTwoDept(Department[] d) {
		for(int i=0; i<=1; i++) {
			System.out.println("Thong tin department thu " + (i+1) + " la:");
			System.out.println("Id: " + d[i].id);
			System.out.println("Name: " + d[i].name);
		}
	}
	
	public static void notPrintSecondAcc(Account[] a) {
		for(int i=0; i<a.length; i++) {
			if(i!=1) {
				System.out.println("Thong tin account thu " + (i+1) + " la: ");
				System.out.println("Email: " + a[i].email);
				System.out.println("Full name: " + a[i].fullName);
				System.out.println("Phong ban: " + a[i].departmentID.name);
			}
		}
	}
	
	public static void printAccIdLessThan4(Account[] a) {
		for(int i=0; i<a.length; i++) {
			if(a[i].id<4) {
				System.out.println("Thong tin account thu " + (i+1) + " la: ");
				System.out.println("Email: " + a[i].email);
				System.out.println("Full name: " + a[i].fullName);
				System.out.println("Phong ban: " + a[i].departmentID.name);
			}
		}
	}
	
	public static void printEvenLessThan20() {
		for(int i=1; i<=20; i++) {
			if(i%2==0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void printTwoDeptWhile(Department[] d) {
		int i=0;
		while(i>=0) {
			System.out.println("Thong tin department thu " + (i+1) + " la:");
			System.out.println("Id: " + d[i].id);
			System.out.println("Name: " + d[i].name);
			i++;
			if(i==2) {
				break;
			}
		}
	}
	
	public static void printEvenLessThan20DoWhile() {
		int i=1;
		do {
			if(i%2==0) {
				System.out.print(i + " ");
			}
			i++;
		} while(i<=20);
	}
	

}
