package com.vti.entity;

public abstract class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name=" + name + " ";
	}	
}
