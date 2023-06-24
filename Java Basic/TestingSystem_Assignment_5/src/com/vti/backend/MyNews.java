package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.News;

public class MyNews {
	private Scanner sc = new Scanner(System.in);
	private List<News> newsList = new ArrayList<>();
	
	public void quest1() {
		while(true) {
			System.out.println("Nhap lua chon cua ban: ");
			System.out.println("1. Insert News");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("0. Exit");
			
			int x = sc.nextInt();
			switch(x) {
			case 1:
				insertNews();
				break;
			case 2:
				viewNews();
				break;
			case 3:
				averageRate();
				break;
			case 0:
				return;
			default:
				System.out.println("Vui long nhap dung chuc nang");
				break;
			
			}
		}
	}
	
	public void insertNews() {
		sc.nextLine();
		System.out.println("Nhap Title: ");
		String title = sc.nextLine();
		System.out.println("Nhap PublishDate: ");
		String publishDate = sc.nextLine();
		System.out.println("Nhap Author:");
		String author = sc.nextLine();
		System.out.println("Nhap Content: ");
		String content = sc.nextLine();
		
		System.out.println("Nhap danh gia cua ban (Nhap gia tri tu 1-10): ");
		System.out.println("Nhập vào đánh giá 1");
		int rate1 = sc.nextInt();
		System.out.println("Nhập vào đánh giá 2");
		int rate2 = sc.nextInt();
		System.out.println("Nhập vào đánh giá 3");
		int rate3 = sc.nextInt();
		
		List<Integer> rate = new ArrayList<>();
//		rate.add(Integer.valueOf(rate1));
//		rate.add(Integer.valueOf(rate2));
//		rate.add(Integer.valueOf(rate3));
		rate.add(rate1);
		rate.add(rate2);
		rate.add(rate3);
		
		News n = new News(newsList.size() + 1, title, publishDate, author, content, rate);
		newsList.add(n);
		System.out.println(n);
	}
	
	public void viewNews() {
		if(newsList.isEmpty()) {
			System.out.println("Chua co bai viet nao");
		} else {
			for(News o:newsList) {
				o.Display();
				System.out.println();
			}
		}
	}
	
	public void averageRate() {
		if(newsList.isEmpty()) {
			System.out.println("Chua co bai viet nao");
		} else {
			for(News o:newsList) {
				System.out.print("Average Rate cua " + o.getTitle() + ": ");
				o.Calculate();
				System.out.println(o.getAverageRate());
			}
		}
		
	}
}
