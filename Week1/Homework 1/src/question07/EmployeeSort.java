package question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>{
	  String name;
	  String department;
	  int age;
	  
	  Employee(String inName, String inDepartment, int inAge){
		  name = inName;
		  department = inDepartment;
		  age = inAge;
	  }
	  
	  @Override
	  public int compareTo(Employee other) {
	    return this.age - other.age;
	  }
	  
	  public void printEmployeeName() {
		  System.out.print(name + ", ");
	  }
}
	
class EmployeeNameComparator implements Comparator<Employee> {
	  @Override
	  public int compare(Employee one, Employee two) {
	    return one.name.compareTo(two.name);
	  }
}

class EmployeeDeptComparator implements Comparator<Employee> {
	  @Override
	  public int compare(Employee one, Employee two) {
	    return one.department.compareTo(two.department);
	  }
}
	
public class EmployeeSort {
	

	  public static void main(String[] args) {
	    List<Employee> list = new ArrayList<>();
	    list.add(new Employee("john", "chemistry", 28));
	    list.add(new Employee("amy", "chemistry", 25));
	    list.add(new Employee("austin", "physics", 33));

	    for (Employee i : list) {
	    	i.printEmployeeName();
	    }
	    System.out.println("");

	    Collections.sort(list, new EmployeeNameComparator());

	    for (Employee i : list) {
	    	i.printEmployeeName();
	    }
	    System.out.println("");

	  }

}
