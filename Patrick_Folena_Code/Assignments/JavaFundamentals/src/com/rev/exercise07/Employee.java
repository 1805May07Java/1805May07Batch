package com.rev.exercise07;

public class Employee implements Comparable<Object>{
	
	private String firstName;
	private String lastName;
	private String dept;
	private int age;
	
	public Employee(String lastName, String firstName, String dept, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.age = age;
	}
	
	//Getter and Setter Methods for all Employee fields
	public String getLastName()
	{
		return lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setName(String lastName, String firstName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getDepartment()
	{
		return dept;
	}
	public void setDepartment(String dept)
	{
		this.dept = dept;
	}

	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}

	//Broad compareTo between two employee objects.
	//Defaults to order Name (Last first, first Last: Alphabetical), Department (Alphabetical), Age (Ascending)
	//Also used if the more precise compareTo method falls through.
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Employee))
		{
			return -2;
		}
		Employee comp = (Employee) o;
		
		int value = 0;
		value = this.lastName.compareToIgnoreCase(comp.lastName);
		
		if(value == 0)
			value = this.firstName.compareToIgnoreCase(comp.firstName);
		if(value == 0)
			value = this.dept.compareTo(comp.dept);
		if(value == 0)
			value = compareAge(this.age, comp.age);
		
		value = value / Math.abs(value);
		return value;
	}

	//Specific compareTo between two employee objects.
	//Attempts to sort based on designated string. If the same, defaults to broader compareTo function.
	public int compareTo(Employee o, String sortBy)
	{
		int value = 0;
		
		switch(sortBy)
		{
		case "LastName":
			value = this.lastName.compareToIgnoreCase(o.lastName);
			break;
		case "FirstName":
			value = this.firstName.compareToIgnoreCase(o.firstName);
			break;
		case "Department":
			value = this.dept.compareTo(o.dept);
			break;
		case "Age":
			value = compareAge(this.age, o.age);
			break;
		}
		if(value == 0)
			value = this.compareTo(o);
		
		value = value / Math.abs(value);
		
		return value;
	}
	
	//Helper function, since numbers don't get an automatic compareTo method.
	private int compareAge(int age1, int age2)
	{
		if(age1 < age2)
			return -1;
		else if (age1 > age2)
			return 1;
		else
			return 0;
	}
}
