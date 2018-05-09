/*
 * Employee.java
 * Author: Cole Vikupitz
 * 
 * Exercise 7: A class representing an employee that implements
 * the Comparator interface, which allows us to compare 2 instances
 * of Employee.
 */

package com.revature.exercise7;

// Imports
import java.util.Comparator;

public class Employee implements Comparator<Employee> {

	private String name, dept;
	private int age;
	
	public Employee(String name, String dept, int age) {
		
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	///////////////////////////////////////////////////////////////
	// Getters and Setters
	///////////////////////////////////////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	////////////////////////////////////////////////////////////////
	// End Getters and Setters
	////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		
		return String.format("Name: %s\nAge: %d\nDept: %s\n",
				this.name, this.age, this.dept);
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		
		/*
		 * If names are not the same, return the difference in the
		 * lexicographical ordering of the employees' names.
		 */
		if (!e1.name.equals(e2))
			return e1.name.compareToIgnoreCase(e2.name);

		/*
		 * If ages are different, return the difference between
		 * the two.
		 */
		if (e1.age != e2.age)
			return (e1.age - e2.age);

		/*
		 * Finally, return lexicographical difference between the
		 * department names if all else is equal.
		 */
		return e1.dept.compareToIgnoreCase(e2.dept);
	}
	
}
