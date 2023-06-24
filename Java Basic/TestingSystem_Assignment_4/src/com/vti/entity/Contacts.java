package com.vti.entity;

public class Contacts {
	private String name;
	private String number;
	
	
	public Contacts(String name, String number) {
		this.name = name;
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "name=" + name + ", number=" + number;
	}
	
	
	
}
