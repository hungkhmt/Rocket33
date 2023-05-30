package assignment_01;

import java.time.LocalDate;

import assignment_01.Position.PositionName;
import assignment_01.TypeQuestion.TypeName;

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
		
		
		//Print Department
		System.out.println("Thông tin Department:");
		System.out.println("Department 1:");
		System.out.println("\tID: " + dept1.id);
		System.out.println("\tName: " + dept1.name + "\n");
		
		//Print Position
		System.out.println("Thông tin Position:");
		System.out.println("Position 1:");
		System.out.println("\tID: " + pos1.id);
		System.out.println("\tName: " + pos1.name + "\n");
		
		//Print Account
		System.out.println("Thông tin Account:");
		System.out.println("Account 1:");
		System.out.println("\tID: " + acc1.id);
		System.out.println("\tUserName: " + acc1.userName);
		System.out.println("\tFullName: " + acc1.fullName);
		System.out.println("\tDepartment: " + acc1.departmentID.name);
		System.out.println("\tPosition: " + acc1.positionID.name);
		System.out.println("\tCreateDate: " + acc1.createDate + "\n");
		
		//Print Group
		System.out.println("Thông tin Group:");
		System.out.println("Group 1:");
		System.out.println("\tID: " + group1.id);
		System.out.println("\tName: " + group1.name);
		System.out.println("\tCreator: " + group1.creatorID.fullName);
		System.out.println("\tCreateDate: " + group1.createDate);
		System.out.println("\tAccount: " + group1.accounts[0].id + ", " + group1.accounts[1].id + "\n");
		
		//Print TypeQuestion
		System.out.println("Thông tin TypeQuestion:");
		System.out.println("TypeQuestion 1:");
		System.out.println("\tID: " + type1.id);
		System.out.println("\tName: " + type1.name + "\n");
		
		//Print CategoryQuestion
		System.out.println("Thông tin CategoryQuestion:");
		System.out.println("CategoryQuestion 1:");
		System.out.println("\tID: " + cate1.id);
		System.out.println("\tName: " + cate1.name + "\n");
		
		//Print Question
		System.out.println("Thông tin Question:");
		System.out.println("Question 1:");
		System.out.println("\tID: " + q1.id);
		System.out.println("\tContent: " + q1.content);
		System.out.println("\tCategory: " + q1.categoryID.name);
		System.out.println("\tType: " + q1.typeID.name);
		System.out.println("\tCreator: " + q1.creatorID.fullName);
		System.out.println("\tCreateDate: " + q1.createDate + "\n");
		
		//Print Answer
		System.out.println("Thông tin Answer:");
		System.out.println("Answer 1:");
		System.out.println("\tID: " + ans1.id);
		System.out.println("\tContent: " + ans1.content);
		System.out.println("\tQuestion: " + ans1.questionID.content);
		System.out.println("\tIsCorrect: " + ans1.isCorrect + "\n");
		
		//Print Exam
		System.out.println("Thông tin Exam:");
		System.out.println("Exam 1:");
		System.out.println("\tID: " + ex1.id);
		System.out.println("\tCode: " + ex1.code);
		System.out.println("\tTitle: " + ex1.title);
		System.out.println("\tCategory: " + ex1.categoryID.name);
		System.out.println("\tDuration: " + ex1.duration);
		System.out.println("\tCreator: " + ex1.creatorID.fullName);
		System.out.println("\tCreateDate: " + ex1.createDate + "\n");
	}
}
