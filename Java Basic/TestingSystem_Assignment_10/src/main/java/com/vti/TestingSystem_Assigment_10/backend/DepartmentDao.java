package com.vti.TestingSystem_Assigment_10.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.TestingSystem_Assigment_10.entity.Department;
import com.vti.TestingSystem_Assigment_10.utils.JDBCUtils;

public class DepartmentDao {
	static Connection connection = JDBCUtils.getConnection();
	
	public static List<Department> getDepartments() throws SQLException {
		List<Department> listDept = new ArrayList<Department>();
		
		Statement statement = connection.createStatement();
		
		String sql = "select * from department";

		// Bước 5: thực hiện câu lệnh truy vấn
		ResultSet resultSet = statement.executeQuery(sql);

		// Bước 6: duyệt và hiển thị dữ liệu từ db
		while (resultSet.next()) {
			Byte id = resultSet.getByte("department_id");
			String name = resultSet.getString("department_name");
			Department department = new Department(id, name);
			listDept.add(department);
		}

		return listDept;
	}
	
	public static Department getDepartmentById(byte id) throws SQLException, Exception {
		Department department = null;
		
		Statement statement = connection.createStatement();
		
		String sql = "select * from department where `department_id` = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setByte(1, id);

		// Bước 5: thực hiện câu lệnh truy vấn
		ResultSet resultSet = preparedStatement.executeQuery();
		
		int count = 0;

		// Bước 6: duyệt và hiển thị dữ liệu từ db
		while (resultSet.next()) {
			String name = resultSet.getString("department_name");
			department = new Department(id, name);
			count++;
		}
		
		if(count == 0) {
			throw new Exception("Cannot find department which has id: " + id);
		}
		return department;
		
	}
	
	public static boolean isDepartmentNameExists(String name) throws SQLException, Exception {		
		Statement statement = connection.createStatement();
		
		String sql = "select * from department";

		// Bước 5: thực hiện câu lệnh truy vấn
		ResultSet resultSet = statement.executeQuery(sql);

		boolean check = false;
		// Bước 6: duyệt và hiển thị dữ liệu từ db
		while (resultSet.next()) {
			String nameDB = resultSet.getString("department_name");
			if(name.equals(nameDB)) {
				check = true;
			}
		}
		return check;
	}
	
	public static void createDepartment(String name) throws SQLException, Exception {
		Statement statement = connection.createStatement();
		
		String sql = "INSERT INTO `Department` (`department_name`)"
					+ "VALUES		(?)";
		
		PreparedStatement preStatement = connection.prepareStatement(sql);
		
		try {
			if(isDepartmentNameExists(name)) {
				throw new Exception("Department Name is Exists!");
			} else {
				try {
					preStatement.setString(1, name);
					int effectedRecordAmount = preStatement.executeUpdate();
					System.out.println("Effect Record Amount: " + effectedRecordAmount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean isDepartmentIdExists(byte id) throws Exception {
		Statement statement = connection.createStatement();
		
		String sql = "select * from department";

		ResultSet resultSet = statement.executeQuery(sql);

		boolean check = false;

		while (resultSet.next()) {
			byte idDB = resultSet.getByte("department_id");
			if(id == idDB) {
				check = true;
			}
		}
		if(check == false) {
			throw new Exception("Cannot find department which has id: " + id);
		}
		return check;
	}
	
	public static void updateDepartment(byte id, String name) throws Exception {
		Statement statement = connection.createStatement();
		
		String sql = "UPDATE `Department`" +
					"SET	`department_name` = ? " +
					"WHERE department_id = ?";
		
		PreparedStatement preStatement = connection.prepareStatement(sql);
		
		if(isDepartmentIdExists(id)) {
			if(isDepartmentNameExists(name) == false) {
				preStatement.setByte(2, id);
				preStatement.setString(1, name);
				int effectedRecordAmount = preStatement.executeUpdate();
				System.out.println("Effect Record Amount: " + effectedRecordAmount);
			} else {
				throw new Exception("Department name is Exists!");
			}
		} else {
			throw new Exception("Department Id is Exists!");
		}
	}
	
	public static void deleteDepartment(byte id) throws Exception {
		Statement statement = connection.createStatement();
		
		String sql = "DELETE FROM `Department`" +
					"WHERE department_id = ?";
		
		PreparedStatement preStatement = connection.prepareStatement(sql);
		
		if(isDepartmentIdExists(id)) {
			preStatement.setByte(1, id);
			int effectedRecordAmount = preStatement.executeUpdate();
			System.out.println("Effect Record Amount: " + effectedRecordAmount);
			
		} else {
			
			throw new Exception("Cannot find department which has id: " + id);
		}
	}
}
