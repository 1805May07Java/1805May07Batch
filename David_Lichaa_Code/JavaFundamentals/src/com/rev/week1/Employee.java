package com.rev.week1;

public class Employee {
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	String name, department;
	int age;
	
	public String toString() {
		return "[Name: " + this.name + ", Department: " + this.department + ", Age: " + this.age + "]"; 
	}
}
