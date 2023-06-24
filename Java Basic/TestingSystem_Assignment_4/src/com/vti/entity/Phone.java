package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
	private List<Contacts> phoneList = new ArrayList<>();

	public Phone() {
		Contacts contact1 = new Contacts("Anh Thảo", "08039062410");
		phoneList.add(contact1);
	}
	
	public abstract void insertContact(String name, String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newPhone);
	public abstract void searchContact(String name);

	public List<Contacts> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Contacts> phoneList) {
		this.phoneList = phoneList;
	}
	
	
}
