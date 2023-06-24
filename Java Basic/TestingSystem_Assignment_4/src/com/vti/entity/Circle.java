package com.vti.entity;

public class Circle {
	final static double RADIUS = 1.0;
	final static String COLOR = "red";
	
	private double radius;
	private String color;
	public Circle() {
		this(RADIUS, COLOR);
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return 2*radius*3.14;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + ", Area=" + getArea() + "]";
	}
	
	
	
}
