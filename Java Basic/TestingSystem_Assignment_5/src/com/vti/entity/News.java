package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private List<Integer> rates;
	

	public News() {
		
	}

	
	public News(int id, String title, String publishDate, String author, String content, List<Integer> rates) {
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.rates = rates;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public List<Integer> getRates() {
		return rates;
	}


	public void setRates(List<Integer> rates) {
		this.rates = rates;
	}


	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + ", averageRate=" + Calculate() + "]";
	}


	@Override
	public void Display() {
		System.out.println("ID: " + id + "\nTitle: " + title + "\nPublishDate: " + publishDate
				+ "\nAuthor: " + author + "\nContent: " + content + "AverageRate: " + averageRate);;
	}

	@Override
	public float Calculate() {
		if(rates != null) {
			this.averageRate = (this.rates.get(0) + this.rates.get(1) + this.rates.get(2))/3;
			return this.averageRate;
		}
		
		return 0;
	}

}
