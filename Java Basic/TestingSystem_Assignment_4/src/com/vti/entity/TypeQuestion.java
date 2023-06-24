package com.vti.entity;

public class TypeQuestion {
	private byte id;
	private TypeName name;
	enum TypeName {
		ESSAY, MULTIPLE_CHOICE
	}
	public TypeQuestion() {
		
	}
	public TypeQuestion(TypeName name) {
		this.name = name;
	}
	public TypeQuestion(byte id, TypeName name) {
		this.id = id;
		this.name = name;
	}
	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
	public TypeName getName() {
		return name;
	}
	public void setName(TypeName name) {
		this.name = name;
	}
}
