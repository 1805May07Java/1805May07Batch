package com.rev.questions;

import java.util.Comparator;

public class Employee {
	public String  name, department;
	public int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public Employee(Employee o) {
		
		this.name =  o.name;
		this.department = o.department;
		this.age = o.age;
		
	}
	
	@Override
	public String toString() {
		return "" + age;
	}
	
	public static class EmployeeComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee arg0, Employee arg1) {
			
			int result = arg0.name.compareTo(arg1.name);

			if (result == 0) {
				result = arg0.department.compareTo(arg1.department);
			}
			
			if (result == 0) {
				result = arg0.age - arg1.age;
			}
			
			return result;
		}
	}
	
	
	
}
