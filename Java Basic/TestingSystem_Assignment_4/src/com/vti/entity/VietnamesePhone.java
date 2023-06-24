package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class VietnamesePhone extends Phone {
	private List<Contacts> contactList = new ArrayList<Contacts>();


	public VietnamesePhone() {
		contactList = super.getPhoneList();
	}

	@Override
	public void insertContact(String name, String phone) {
		// TODO Auto-generated method stub
		Contacts addContact = new Contacts(name, phone);
		contactList.add(addContact);
	}

	@Override
	public void removeContact(String name) {
		List<Contacts> toRemove = new ArrayList<>();
	    for(Contacts contact : contactList) {
	        if(contact.getName().equalsIgnoreCase(name)) {
	            toRemove.add(contact);
	        }
	    }
	    contactList.removeAll(toRemove);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
		for(Contacts o:contactList) {
			if(o.getName().equals(name)) {
				o.setNumber(newPhone);
			}
		}
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		for(Contacts o:contactList) {
			if(o.getName().equals(name)) {
				System.out.println(o);
			}
		}
	}

	public void showContact() {
		for(Contacts o:contactList) {
			System.out.println(o);
		}
	}
}
