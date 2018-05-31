package com.rev.week1;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.name.compareTo(o2.name) == 0) { //first critera to sort is by name
			if (o1.department.compareTo(o2.department) == 0) {  //second criteria to sort is by department
				return o1.age - o2.age;  //final criteria to sort is by age
			} else {
				return o1.department.compareTo(o2.department);
			}
		} else { 
			return o1.name.compareTo(o2.name);
		}	
	}


}
