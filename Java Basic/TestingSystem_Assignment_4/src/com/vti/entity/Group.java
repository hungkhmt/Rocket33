package com.vti.entity;

import java.util.Arrays;
import java.util.Date;

public class Group {
	private byte id;
	private String name;
	private Account creatorID;
	private Date createDate;
	private Account[] accounts;
	
	public Group() {
		
	}

	public Group(String name, Account creatorID, Date createDate, Account[] accounts) {
		this.name = name;
		this.creatorID = creatorID;
		this.createDate = createDate;
		this.accounts = accounts;
	}
	
	public Group(String groupName, Account creator, String[] usernames, Date createDate) {
		Account[] accounts = new Account[usernames.length];
		if(usernames != null) {
			for(int i = 0; i < usernames.length; i++) {
				Account acc = new Account();
				acc.setUserName(usernames[i]);
				accounts[i] = acc;
			}
		}
		this.name = groupName;
		this.creatorID = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}

	public Group(byte id, String name, Account creatorID, Date createDate, Account[] accounts) {
		this.id = id;
		this.name = name;
		this.creatorID = creatorID;
		this.createDate = createDate;
		this.accounts = accounts;
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

	public Account getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Account creatorID) {
		this.creatorID = creatorID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	
}
