package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float score;
	
	public Student(String name, String hometown) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public void sumSocre(float score) {
		this.score = this.score + score;
	}

	@Override
	public String toString() {
		if(score < 4.0) {
			return "Name: " + name + "\n" + "Hoc luc: Yeu";
		} else if (score >= 4.0 && score < 6.0) {
			return "Name: " + name + "\n" + "Hoc luc: Trung Binh";
		} else if (score >= 6.0 && score < 8.0) {
			return "Name: " + name + "\n" + "Hoc luc: Kha";
		} else {
			return "Name: " + name + "\n" + "Hoc luc: Gioi";
		}
	}
	
	
}
