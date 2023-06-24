package com.vti.entity;

import java.util.Date;

import com.vti.entity.Position.PositionName;
import com.vti.entity.TypeQuestion.TypeName;

public class Program {
	public static void main(String[] args) {
		//Tạo Department
		Department dept1 = new Department((byte) 1, "Sale");
		Department dept2 = new Department((byte) 2, "Development");
		Department dept3 = new Department((byte) 3, "Marketing");
		
		//Tao Position
		Position pos1 = new Position((byte) 1, PositionName.DEV);
		Position pos2 = new Position((byte) 2, PositionName.SCRUM_MASTER);
		Position pos3 = new Position((byte) 3, PositionName.TEST);
		
		//Tao Account
		Account acc1 = new Account(1, "hung11812@gmail.com", "hungkhmt", "Nguyễn Thế Hưng", dept1, pos3, new Date());
		
		Account acc2 = new Account(2, "dongkisot@gmail.com", "dongkave", "Bùi Huy Đông", dept2, pos2, new Date());
		
		Account acc3 = new Account(3, "haiyen@gmail.com", "yenkngu", "Nguyễn Thị Hải Yến", dept3, pos3, new Date());
		
		//Tao Group
		Group group1 = new Group((byte) 1, "Testing System", acc2, new Date(), new Account[] {acc1, acc2});		
		Group group2 = new Group((byte) 2, "Manager", acc3, new Date(), new Account[] {acc1, acc3});
		Group group3 = new Group((byte) 3, "Finance", acc1, new Date(), new Account[] {acc1, acc2});

		
		//Khoi tao groups cho Account
		acc1.setGroups(new Group[] {group1, group2});
		acc2.setGroups(new Group[] {group1, group3});
		acc3.setGroups(new Group[] {group2, group3});
		
		
		//Tao TypeQuestion
		TypeQuestion type1 = new TypeQuestion((byte) 1, TypeName.ESSAY);	
		TypeQuestion type2 = new TypeQuestion((byte) 2, TypeName.MULTIPLE_CHOICE);
		
		//Tao CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion((byte) 1, "Java");
		CategoryQuestion cate2 = new CategoryQuestion((byte) 2, "Python");
		CategoryQuestion cate3 = new CategoryQuestion((byte) 3, "C++");
		
		//Tao Question
		Question q1 = new Question((byte) 1, "Cac cau hoi lien quan Java", cate1, type1, acc1, new Date());
		Question q2 = new Question((byte) 2, "Cac cau hoi lien quan C++", cate3, type2, acc2, new Date());
		Question q3 = new Question((byte) 3, "Cac cau hoi lien quan Python", cate2, type1, acc3, new Date());
		
		//Tao Answer
		Answer ans1 = new Answer((byte) 1, "Cau tra loi 1", q2, true);	
		Answer ans2 = new Answer((byte) 2, "Cau tra loi 2", q1, true);
		Answer ans3 = new Answer((byte) 3, "Cau tra loi 3", q3, false);
		
		//Tao Exam
		Exam ex1 = new Exam((byte) 1, "DT01", "Bai test Python", cate2, 60, acc1, new Date());		
		Exam ex2 = new Exam((byte) 2, "DT02", "Bai test Java", cate1, 80, acc1, new Date());	
		Exam ex3 = new Exam((byte) 3, "DT03", "Bai test C++", cate3, 60, acc2, new Date());
		
		
		//Print Department
		System.out.println("Thông tin Department:");
		System.out.println("Department 1:");
		System.out.println("\tID: " + dept1.getId());
		System.out.println("\tName: " + dept1.getName() + "\n");
		
		//Print Position
		System.out.println("Thông tin Position:");
		System.out.println("Position 1:");
		System.out.println("\tID: " + pos3.getId());
		System.out.println("\tName: " + pos3.getName() + "\n");
		
		//Print Account
		System.out.println("Thông tin Account:");
		System.out.println("Account 1:");
		System.out.println("\tID: " + acc1.getId());
		System.out.println("\tUserName: " + acc1.getUserName());
		System.out.println("\tFullName: " + acc1.getFullName());
		System.out.println("\tDepartment: " + acc1.getDepartment().getName());
		System.out.println("\tPosition: " + acc1.getPosition().getName());
		System.out.println("\tCreateDate: " + acc1.getCreateDate());
		System.out.println("\tGroup: " + acc1.getGroups()[0].getName() + ", " + acc1.getGroups()[1].getName() + "\n");
		
		//Print Group
		System.out.println("Thông tin Group:");
		System.out.println("Group 1:");
		System.out.println("\tID: " + group1.getId());
		System.out.println("\tName: " + group1.getName());
		System.out.println("\tCreator: " + group1.getCreatorID().getFullName());
		System.out.println("\tCreateDate: " + group1.getCreateDate());
		System.out.println("\tAccount: " + group1.getAccounts()[0].getId() + ", " + group1.getAccounts()[1].getId() + "\n");
		
		//Print TypeQuestion
		System.out.println("Thông tin TypeQuestion:");
		System.out.println("TypeQuestion 1:");
		System.out.println("\tID: " + type1.getId());
		System.out.println("\tName: " + type1.getName() + "\n");
		
		//Print CategoryQuestion
		System.out.println("Thông tin CategoryQuestion:");
		System.out.println("CategoryQuestion 1:");
		System.out.println("\tID: " + cate1.getId());
		System.out.println("\tName: " + cate1.getName() + "\n");
		
		//Print Question
		System.out.println("Thông tin Question:");
		System.out.println("Question 1:");
		System.out.println("\tID: " + q1.getId());
		System.out.println("\tContent: " + q1.getContent());
		System.out.println("\tCategory: " + q1.getCategory().getName());
		System.out.println("\tType: " + q1.getType().getName());
		System.out.println("\tCreator: " + q1.getCreator().getFullName());
		System.out.println("\tCreateDate: " + q1.getCreateDate() + "\n");
		
		//Print Answer
		System.out.println("Thông tin Answer:");
		System.out.println("Answer 1:");
		System.out.println("\tID: " + ans1.getId());
		System.out.println("\tContent: " + ans1.getContent());
		System.out.println("\tQuestion: " + ans1.getQuestionID().getContent());
		System.out.println("\tIsCorrect: " + ans1.isCorrect() + "\n");
		
		//Print Exam
		System.out.println("Thông tin Exam:");
		System.out.println("Exam 1:");
		System.out.println("\tID: " + ex1.getId());
		System.out.println("\tCode: " + ex1.getCode());
		System.out.println("\tTitle: " + ex1.getTitle());
		System.out.println("\tCategory: " + ex1.getCategory().getName());
		System.out.println("\tDuration: " + ex1.getDuration());
		System.out.println("\tCreator: " + ex1.getCreator().getFullName());
		System.out.println("\tCreateDate: " + ex1.getCreateDate() + "\n");
	}
}
