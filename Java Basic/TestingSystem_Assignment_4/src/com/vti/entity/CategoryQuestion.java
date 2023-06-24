package com.vti.entity;

public class CategoryQuestion {
	private byte id;
	private String name;
	
	public CategoryQuestion() {
		
	}

	public CategoryQuestion(byte id, String name) {
		this.id = id;
		this.name = name;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
