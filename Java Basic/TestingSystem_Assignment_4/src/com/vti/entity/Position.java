package com.vti.entity;

public class Position {
	private byte id;
	private PositionName name;
		
	enum PositionName {
		DEV, TEST, SCRUM_MASTER, PM
	}
	
	public Position() {
		
	}
	
	Position(PositionName name) {
		this.name = name;
	}
	
	Position(byte id, PositionName name) {
		this.id = id;
		this.name = name;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}
}
