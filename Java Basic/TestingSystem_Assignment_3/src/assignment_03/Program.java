package assignment_03;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import assignment_03.Position.PositionName;
import assignment_03.TypeQuestion.TypeName;

public class Program {
	public static void main(String[] args) {
		//Tạo Department
		Department dept1 = new Department();
		dept1.id = 1;
		dept1.name = "Sale";
		Department dept2 = new Department();
		dept2.id = 2;
		dept2.name = "Development";
		Department dept3 = new Department();
		dept3.id = 3;
		dept3.name = "Marketing";
		
		//Tao Position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.SCRUM_MASTER;
		
		//Tao Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "hung11812@gmail.com";
		acc1.userName = "hungkhmt";
		acc1.fullName = "Nguyễn Thế Hưng";
		acc1.departmentID = dept1;
		acc1.positionID = pos1;
		acc1.createDate = LocalDate.now();
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "dongkisot@gmail.com";
		acc2.userName = "dongkave";
		acc2.fullName = "Bùi Huy Đông";
		acc2.departmentID = dept2;
		acc2.positionID = pos2;
		acc2.createDate = LocalDate.of(2023, 03, 17);
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "haiyen@gmail.com";
		acc3.userName = "yenkngu";
		acc3.fullName = "Nguyễn Thị Hải Yến";
		acc3.departmentID = dept3;
		acc3.positionID = pos3;
		acc3.createDate = LocalDate.now();
		
		//Tao Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.creatorID = acc2;
		group1.createDate = LocalDate.of(2023, 03, 25);
		group1.accounts = new Account[] {acc1, acc2};
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Manager";
		group2.creatorID = acc3;
		group2.createDate = LocalDate.of(2023, 03, 28);
		group2.accounts = new Account[] {acc1, acc3};
		
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Finance";
		group3.creatorID = acc1;
		group3.createDate = LocalDate.of(2023, 03, 23);
		group3.accounts = new Account[] {acc1, acc2};
		
		//Tao TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.ESSAY;
		
		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;
		
		//Tao CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";
		
		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.name = "Python";
		
		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 3;
		cate3.name = "C++";
		
		//Tao Question
		Question q1 = new Question();
		q1.id = 1;
		q1.content = "Cac cau hoi lien quan Java";
		q1.categoryID = cate1;
		q1.typeID = type1;
		q1.creatorID = acc1;
		q1.createDate = LocalDate.now();
		
		Question q2 = new Question();
		q2.id = 2;
		q2.content = "Cac cau hoi lien quan C++";
		q2.categoryID = cate3;
		q2.typeID = type2;
		q2.creatorID = acc2;
		q2.createDate = LocalDate.now();
		
		Question q3 = new Question();
		q3.id = 3;
		q3.content = "Cac cau hoi lien quan Python";
		q3.categoryID = cate2;
		q3.typeID = type1;
		q3.creatorID = acc3;
		q3.createDate = LocalDate.now();
		
		//Tao Answer
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "Cau tra loi 1";
		ans1.isCorrect = true;
		ans1.questionID = q2;
		
		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "Cau tra loi 2";
		ans2.isCorrect = true;
		ans2.questionID = q1;
		
		Answer ans3 = new Answer();
		ans3.id = 3;
		ans3.content = "Cau tra loi 3";
		ans3.isCorrect = false;
		ans3.questionID = q3;
		
		//Tao Exam
		Exam ex1 = new Exam();
		ex1.id = 1;
		ex1.code = "DT01";
		ex1.title = "Bai test Python";
		ex1.categoryID = cate2;
		ex1.duration = 60;
		ex1.creatorID = acc1;
		ex1.createDate = LocalDate.now();
		
		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "DT02";
		ex2.title = "Bai test Java";
		ex2.categoryID = cate1;
		ex2.duration = 80;
		ex2.creatorID = acc1;
		ex2.createDate = LocalDate.now();
		
		Exam ex3 = new Exam();
		ex3.id = 3;
		ex3.code = "DT03";
		ex3.title = "Bai test C++";
		ex3.categoryID = cate3;
		ex3.duration = 60;
		ex3.creatorID = acc2;
		ex3.createDate = LocalDate.now();
		
		
		Group[] g = {group1, group2, group3};
		Account[] a = {acc1, acc2, acc3};
		
		Department dept4 = new Department();
		dept4.id = 4;
		dept4.name = "Waiting room";
		
		Department dept5 = new Department();
		dept5.id = 5;
		dept5.name = "Boss of director";
		
		Department dept6 = new Department();
		dept6.id = 6;
		dept6.name = "Accounting";
		
		Department[] d = {dept1, dept2, dept3, dept4, dept5, dept6};
		//Ex4
//		Question 1:
//			Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//			thể cách nhau bằng nhiều khoảng trắng );
		Ex4_String.countCharacter();
//		Question 2:
//			Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		Ex4_String.connectString();
//		Question 3:
//			Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//			viết hoa chữ cái đầu thì viết hoa lên
		Ex4_String.stringUperCase();
//		Question 4:
//			Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//			của người dùng ra
//			VD:
//			Người dùng nhập vào "Nam", hệ thống sẽ in ra
//			"Ký tự thứ 1 là: N"
//			"Ký tự thứ 1 là: A"
//			"Ký tự thứ 1 là: M"
		Ex4_String.printNameCharacters();
//		Question 5:
//			Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//			dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
		Ex4_String.printFullName();
//		Question 6:
//			Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//			sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//			VD:
//			Người dùng nhập vào "Nguyễn Văn Nam"
//			Hệ thống sẽ in ra
//			"Họ là: Nguyễn"
//			"Tên đệm là: Văn"
//			"Tên là: Nam"
		Ex4_String.splitFullName();
//		Question 7:
//			Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//			chuẩn hóa họ và tên của họ như sau:
		Ex4_String.normalizeName();
//		Question 8:
//			In ra tất cả các group có chứa chữ "Java"
		Ex4_String.printGroupHasJava(g);
//			Question 9:
//			In ra tất cả các group "Java"
		Ex4_String.printGroupJava(g);
		
		//Ex5
//		Question 1:
//			In ra thông tin của phòng ban thứ 1 (sử dụng toString())
		System.out.println(dept1);
//		Question 2:
//			In ra thông tin của tất cả phòng ban (sử dụng toString())
		for(Department o:d) {
			System.out.println(o);
		}
//		Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
		if(dept1.name.equalsIgnoreCase("Phong A")) {
			System.out.println("Phong ban 1 co ten la: Phong A");
		} else {
			System.out.println("Phong ban 1 khong co ten la: Phong A");
		}
//		Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//		không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
		if(dept1.equals(dept2)) {
			System.out.println("Phong ban 1 va 2 bang nhau");
		} else {
			System.out.println("Phong ban 1 va 2 khac nhau");
		}
		
//		Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//		sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
		Collections.sort(Arrays.asList(d), new sortByFirstName());
		for(Department o:d) {
			System.out.println(o);
		}
		
//		Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
//		sách phòng ban được sắp xếp theo tên
		Collections.sort(Arrays.asList(d), new sortByLastName());
		for(Department o:d) {
			System.out.println(o);
		}
	}
}
