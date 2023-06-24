package com.vti.entity;

import java.util.Date;

public class Exam {
	private byte id;
	private String code;
	private String title;
	private CategoryQuestion category;
	private int duration;
	private Account creator;
	private Date createDate;
	
	public Exam() {
		
	}

	public Exam(byte id, String code, String title, CategoryQuestion category, int duration, Account creator,
			Date createDate) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.category = category;
		this.duration = duration;
		this.creator = creator;
		this.createDate = createDate;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryQuestion getCategory() {
		return category;
	}

	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
