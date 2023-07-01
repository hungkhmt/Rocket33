package com.vti.TestingSystem_Assigment_10.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\main\\resource\\database.properties"));
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("username");
			final String PASSWORD = properties.getProperty("password");

			// Bước 1: Đăng ký driver class với DriverManager
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Bước 2: Đăng ký một Connection(kết nối) đến gia
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return connection;

	}
}
