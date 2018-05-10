package q7.comparator.hw1;


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
		
		e1.printEmployee();
		e2.printEmployee();
		
		
	}
	
	public employee[] sort(employee[] employeeList) {
		
		
		return employeeList;
	}


}
