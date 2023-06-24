package com.vti.entity;

public class Account_Ex4 {
	private String id;
	private String name;
	private int balance;
	public Account_Ex4(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	
	public int credit(int amount) {
		return this.balance += amount;
	}

	public int debit(int amount) {
		return this.balance -= amount;
	}

	public void tranferTo(Account_Ex4 accEx4, int amount) {
		this.balance -= amount;
		accEx4.balance += amount;
	}
	
	
}
