package com.revature.emp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class EmpSorter {

	public static void main(String[] args) {
		ArrayList<Employee>payRoll = new ArrayList<Employee>();
		Employee sal = new Employee("Sal", "HR", 25);
		Employee sadit = new Employee("Sadit", "Sales", 35);
		payRoll.add(sal);
		payRoll.add(sadit);
		
		System.out.println(payRoll.get(0).toString());
		System.out.println(payRoll.get(1));
		
		Collections.sort(payRoll, new SortByName());
		System.out.println(payRoll.get(0));
		System.out.println(payRoll.get(1));
	}
}

class SortByName implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        return a.name.compareTo(b.name);
    }
}
