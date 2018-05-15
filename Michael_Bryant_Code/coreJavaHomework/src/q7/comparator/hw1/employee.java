package q7.comparator.hw1;

import java.util.Comparator;

public class employee{

	private String name;
	private String department;
	private int age;
	
	public employee(String name, String department, int age) {
		this.name=name;
		this.department = department;
		this.age = age;
	}
	public employee() {}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department= department;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	
	
	
	public void printEmployee() {
		System.out.println("This is: " +name);
		System.out.println("They work in: " +department);
		System.out.println("They are: " +age +" years old.");
		System.out.println();
	}

}
class sortByName implements Comparator<employee>{
	public int compare(employee e1, employee e2) {
		
		String e1Name = e1.getName().toLowerCase();
		String e2Name = e2.getName().toLowerCase();
		
		
		return e1Name.compareTo(e2Name);
	}
	
}
class sortByDep implements Comparator<employee>{
	public int compare(employee e1, employee e2) {
		
		String e1Name = e1.getDepartment().toLowerCase();
		String e2Name = e2.getDepartment().toLowerCase();
		
		
		return e1Name.compareTo(e2Name);
	}
	
}
class sortByAge implements Comparator<employee>{
	public int compare(employee e1, employee e2) {return e1.getAge() - e2.getAge();}
	
}

