package assignment_02;

import java.time.LocalDate;
import java.util.Date;

import assignment_02.Position.PositionName;
import assignment_02.TypeQuestion.TypeName;
import assignment_02.FlowControl;

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
		acc1.createDate = new Date();
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "dongkisot@gmail.com";
		acc2.userName = "dongkave";
		acc2.fullName = "Bùi Huy Đông";
		acc2.departmentID = dept2;
		acc2.positionID = pos2;
		acc2.createDate = new Date();
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "haiyen@gmail.com";
		acc3.userName = "yenkngu";
		acc3.fullName = "Nguyễn Thị Hải Yến";
		acc3.departmentID = dept3;
		acc3.positionID = pos3;
		acc3.createDate = new Date();
		
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
		ex1.createDate = new Date();
		
		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "DT02";
		ex2.title = "Bai test Java";
		ex2.categoryID = cate1;
		ex2.duration = 80;
		ex2.creatorID = acc1;
		ex2.createDate = new Date();
		
		Exam ex3 = new Exam();
		ex3.id = 3;
		ex3.code = "DT03";
		ex3.title = "Bai test C++";
		ex3.categoryID = cate3;
		ex3.duration = 60;
		ex3.creatorID = acc2;
		ex3.createDate = new Date();
		
		
		//Exercise 1
//		FlowControl.checkDeptNull(acc2);
		Group[] g = {group1, group2, group3};
//		FlowControl.checkGroup(g);		
//		FlowControl.checkDeptNullTernary(acc2);		
//		FlowControl.checkPosAccTernary(acc1);	
//		FlowControl.getAccInGroup(group1);	
//		FlowControl.checkGroupSwitchCase(g);	
//		FlowControl.checkPosAccSwitchCase(acc1);
		
		Account[] a = {acc1, acc2, acc3};
		Department[] d = {dept1, dept2, dept3};
		
//		FlowControl.printAccountForE(a);
//		FlowControl.printDeptForE(d);
//		FlowControl.printAccFor(a);
//		FlowControl.printDeptFor(d);
//		FlowControl.printTwoDept(d);
//		FlowControl.notPrintSecondAcc(a);
//		FlowControl.printAccIdLessThan4(a);
//		FlowControl.printEvenLessThan20();
		
//		FlowControl.printTwoDeptWhile(d);
//		FlowControl.printEvenLessThan20DoWhile();
		
		
		//Exercise 2
//		SystemOutPrintf.prinfInt();
//		SystemOutPrintf.printfInt2();
//		SystemOutPrintf.printfFloat();
//		SystemOutPrintf.printFormatTime();
//		SystemOutPrintf.printAccLikeSql(a);
		
		//Exercise 3
//		ExDateFormat.printExamDateWithVNFormat(ex1);
//		ExDateFormat.printExamDateWithFormat(ex1);
		
		//Exercise 4
//		RandomNumber.printIntRand();
//		RandomNumber.printFloatRandom();
//		RandomNumber.printRandName();
//		RandomNumber.randTime();
//		RandomNumber.randThreeDigitNum();
		
		//Exercise 5
//		InputFromConsole.inputThreeNum();
//		InputFromConsole.inputFullName();
		
	}
}
