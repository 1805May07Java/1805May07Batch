package q7.comparator.hw1;

import java.util.Arrays;

public class employeeCompare extends employee{


public employeeCompare(String name, String department, int age) {
		super(name, department, age);
		
	}

//	Sort two employees based on their name, department, and age using the Comparator interface.
//	Well send our information to our employee class to hold the information. Well accept arguments 
//	to decide how the employees should be sorted. This program will use our compare method inside of employee
//	to determine which employee comes first in our sort. 
	

	public static void main(String[] args) {
		employee e1 = new employee("kyle", "hr", 24);
		employee e2 = new employee("steven", "mailroom", 42);
		employee e3 = new employee("Alex","takeout", 54);
		
		e1.printEmployee();
		e2.printEmployee();
		e3.printEmployee();
		
		employee[] employeeList = {e1, e2, e3}; 
		
		
		sortName(employeeList);
		System.out.println();
		System.out.println("Sort By Name: ");
		for(employee t: employeeList) {
			System.out.println(t.getName() +" " +t.getDepartment()+" " +t.getAge());
		}
		
		sortDepartment(employeeList);
		System.out.println();
		System.out.println("Sort By Department: ");
		for(employee t: employeeList) {
			System.out.println(t.getName() +" " +t.getDepartment()+" " +t.getAge());
		}
		sortAge(employeeList);
		System.out.println();
		System.out.println("Sort By Age: ");
		for(employee t: employeeList) {
			System.out.println(t.getName() +" " +t.getDepartment()+" " +t.getAge());
		}
		
		
		
	}
	private static employee[] sortAge(employee[] employeeList) {
		Arrays.sort(employeeList, new sortByAge());
		return employeeList;
	
	}
	
	private static employee[] sortDepartment(employee[] employeeList) {
		Arrays.sort(employeeList, new sortByDep());
		return employeeList;
	
	}

	private static employee[] sortName(employee[] employeeList) {
		Arrays.sort(employeeList, new sortByName());
		return employeeList;
	}


}
