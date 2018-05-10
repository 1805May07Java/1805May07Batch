package q7.comparator.hw1;

import java.util.Comparator;

public class employee implements Comparator<employee>{

	private String name;
	private String department;
	private int age;
	
	public employee(String name, String department, int age) {
		this.name=name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department= department;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public int compare(employee o1, employee o2) {
		int first = 0;
		
		
		return 0;
	}
	
	public void printEmployee() {
		System.out.println("This is: " +name);
		System.out.println("They work in: " +department);
		System.out.println("They are: " +age +" years old.");
		System.out.println();
	}

}
