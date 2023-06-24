package com.vti.entity;

public class HighSchoolStudent extends Student_Ex5_Q3 {

	String clazz;
	String desiredUniversity;
	
	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return "HighSchoolStudent [clazz=" + clazz + ", desiredUniversity=" + desiredUniversity + ", "
				+ super.toString() + "]";
	}
	
	
}
