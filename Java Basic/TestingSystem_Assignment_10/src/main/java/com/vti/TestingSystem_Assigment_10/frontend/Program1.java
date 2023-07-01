package com.vti.TestingSystem_Assigment_10.frontend;

import com.vti.TestingSystem_Assigment_10.backend.Ex1_Basic;

public class Program1 {
	public static void main(String[] args) {
		Ex1_Basic.connectDB();
		Ex1_Basic.viewDB();
		Ex1_Basic.insertDB();
		Ex1_Basic.updateDB();
		Ex1_Basic.delDB();
	}
}
