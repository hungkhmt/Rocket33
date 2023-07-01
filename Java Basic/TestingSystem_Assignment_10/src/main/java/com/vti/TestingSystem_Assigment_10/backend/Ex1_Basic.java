package com.vti.TestingSystem_Assigment_10.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vti.TestingSystem_Assigment_10.utils.JDBCUtils;
import com.vti.TestingSystem_Assigment_10.utils.ScannerUtils;

public class Ex1_Basic {
	static Connection connection = JDBCUtils.getConnection();
	public static void connectDB() {
		if(connection != null) {
			System.out.println("Connect succes !!!");
		} else {
			System.out.println("Connect fail !!!");
		}
	}
	
	public static void viewDB() {
		try {
			Statement statement = connection.createStatement();
			
			String sql = "SELECT * FROM Positionn";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("positionn_id") + "\t");
				System.out.println(resultSet.getString("positionn_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertDB() {
		try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO Positionn(positionn_name)"
					+ "VALUE	(?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Nhap ten Position (Dev, Test, Scrum Master, PM): ");
			String name = ScannerUtils.inputString();
			preparedStatement.setString(1, name);
			int effectedRecordAmount = preparedStatement.executeUpdate();


			System.out.println("Effect Record Amount: " + effectedRecordAmount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static void updateDB() {
		try {
			Statement statement = connection.createStatement();
			String sql = "UPDATE Positionn"
					+ "SET positionn_name = ?"
					+ "WHERE positionn_id = 5";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Nhap ten Position (Dev, Test, Scrum Master, PM): ");
			String name = "Dev";
			preparedStatement.setString(1, name);
			int effectedRecordAmount = preparedStatement.executeUpdate();


			System.out.println("Effect Record Amount: " + effectedRecordAmount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void delDB() {
		try {
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM Positionn WHERE positionn_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Nhap id can xoa: ");
			byte id = ScannerUtils.inputByte("Nhap so nguyen");
			preparedStatement.setByte(1, id);
			int effectedRecordAmount = preparedStatement.executeUpdate();


			System.out.println("Effect Record Amount: " + effectedRecordAmount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
