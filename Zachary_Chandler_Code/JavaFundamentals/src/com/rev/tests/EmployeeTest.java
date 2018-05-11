package com.rev.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.rev.questions.Employee;
import com.rev.questions.Employee.EmployeeComparator;

class EmployeeTest {

	private static Employee e1;
	private static Employee e2;

	@Before
	public void setupEmployees() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
	}

	@Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

	@Test
	public void testAgeSortingForwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e2.age = 31;
		
		Employee[] emps = {e1, e2};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e2);
		assertEquals(emps[1], e1);
	}
	
	@Test
	public void testAgeSortingBackwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e2.age = 33;
		
		Employee[] emps = {e2, e1};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e1);
		assertEquals(emps[1], e2);
	}

	@Test
	public void testDepartmentSortingForwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e1.department = e1.department + "z";
		
		Employee[] emps = {e1, e2};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e2);
		assertEquals(emps[1], e1);
	}
	
	@Test
	public void testDepartmentSortingBackwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e2.department = e2.department.substring(e2.department.length() - 1);
		
		Employee[] emps = {e2, e1};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e1);
		assertEquals(emps[1], e2);
	}
	
	@Test
	public void testNameSortingForwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e1.name = e1.name + "z";
		
		Employee[] emps = {e1, e2};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e2);
		assertEquals(emps[1], e1);
	}
	
	@Test
	public void testNameSortingBackwardsRequirements() {
		e1 = new Employee("adam", "hr", 32);
		e2 = new Employee("adam", "hr", 32);
		
		e2.name = e2.name.substring(e2.name.length() - 1);
		
		Employee[] emps = {e2, e1};
		Arrays.sort(emps, new EmployeeComparator());
		
		assertEquals(emps[0], e1);
		assertEquals(emps[1], e2);
	}

}
