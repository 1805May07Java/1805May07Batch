package app;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "EMP_DATA")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="employee")
public class Employee {

	
	@Id
	private int id;
	private String name;
	private int age;
	private Double salary;
	
	public Employee(){}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String toString(){
		return "ID = " + id + ", Name = " + name + ", Age = " + age + ", Salary = " + salary;
	}
	
}
