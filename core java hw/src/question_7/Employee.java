package question_7;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	/*
	 * We must implement the compare method, so given two Employee objects
	 * We compare who's name comes first alphabetically,
	 * followed by the department, then finally the age.
	 */
	public int compare(Employee e1, Employee e2) {
		if(e1.name.toLowerCase().compareTo(e2.name.toLowerCase()) < 0) 
			return -1;
		else if(e1.name.toLowerCase().compareTo(e2.name.toLowerCase()) > 0) 
			return 1;

		if(e1.department.toLowerCase().compareTo(e2.department.toLowerCase()) < 0) 
			return -1;
		else if(e1.department.toLowerCase().compareTo(e2.department.toLowerCase()) > 0)
			return 1;
		
		if(e1.age < e2.age)
			return -1;
		else if(e1.age > e1.age) 
			return 1;
		
		return 0;
	}
	
	public String toString() {
		return "name: " + name + "\n" +
				"deparment: " + department + "\n" + 
				"age: " + age;
	}
	
	
}
