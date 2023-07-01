package com.vti.TestingSystem_Assigment_10.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.TestingSystem_Assigment_10.backend.DepartmentDao;
import com.vti.TestingSystem_Assigment_10.entity.Department;
import com.vti.TestingSystem_Assigment_10.utils.ScannerUtils;

public class Program2 {
	public static void main(String[] args) {
		//question1();
		//question2();
		//question5();
		//question6();
		question7();
	}
	
	public static void question1() {
		List<Department> listDept = new ArrayList<Department>();
		try {
			listDept = DepartmentDao.getDepartments();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Department o:listDept) {
			System.out.println(o);
		}
	}
	
	public static void question2() {
		try {
			System.out.println("Nhap id can tim: ");
			byte id = ScannerUtils.inputByte("Yeu cau nhap so");
			Department dept = DepartmentDao.getDepartmentById(id);
			System.out.println(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void question5() {
		System.out.println("Nhap name can create: ");
		String name = ScannerUtils.inputString();
		try {
			DepartmentDao.createDepartment(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void question6() {
		System.out.println("Nhap id: ");
		byte id = ScannerUtils.inputByte("Yeu cau nhap so");
		System.out.println("Nhap name: ");
		String name = ScannerUtils.inputString();
		
		try {
			DepartmentDao.updateDepartment(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void question7() {
		System.out.println("Nhap id: ");
		byte id = ScannerUtils.inputByte("Yeu cau nhap so");
		try {
			DepartmentDao.deleteDepartment(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
