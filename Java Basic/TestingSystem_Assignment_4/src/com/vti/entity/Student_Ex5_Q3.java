package com.vti.entity;

public abstract class Student_Ex5_Q3 extends Person {
	int id;
	public Student_Ex5_Q3(String name, int id) {
		super(name);
		this.id = id;
	}
	@Override
	public String toString() {
		return "id=" + id + ", " + super.toString() + " ";
	}
	
}
