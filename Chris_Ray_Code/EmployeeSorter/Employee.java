package com.revature.emp;

//import java.util.Comparator;

public class Employee{
	public String name;
	public String department;
	public Integer age;
	
	public Employee() {
		this.name = "NAME";
		this.department = "DEPARTMENT";
		this.age = 0;
	}
	
	public Employee(String name) {
		this.name = name;
		
	}
	
	public Employee(String name, String dept) {
		this.name = name;
		this.department = dept;
	}
	
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.department = dept;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}

}
