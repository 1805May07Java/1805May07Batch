package com.designpatterns.dao;

import java.util.ArrayList;

public class StudentServer 
{
	
	//needed to compile
	static ArrayList<Student> students;
	static 
	{
		students = new ArrayList<Student>();
		students.add(new Student(20057, "MSpike", "Sharon Spikes", 3.2, "Engineering", "StarScream12", true));
		students.add(new Student(23456, "NameTaken", "Stol Sykes", 3.1, "Computer Science", "W_H_Y_B_O_T_H_E_R?", true));
		students.add(new Student(10002, "LastOne", "Helen Mild", 3.95, "Medicine", "SoonToEnd", false));
		students.add(new Student(25779, "CF1034", "Charlie Folds", 3.6, "Biology", "CFstudent", true));
		students.add(new Student(00023, "Founder", "Sam Brown", 3.5, "History", "IdesOfMarch", false));
		students.add(new Student(24458, "MAvar", "Mort Avar", 3.8, "Math", "MrReaper", true));
	}
	
	ArrayList<Student> getAllStudents()
	{
		return students;
	}
	
	
	
	
	//method to add user to the ArrayList
	public boolean addUser(int id, String userName, String name, double gpa, String major, 
			String passcode, boolean isEnrolled) 
	{
		if(searchUser(userName) == null) 
		{
		getAllStudents().add(new Student(id, userName, name, gpa, major, passcode, isEnrolled));
		return true;
		}
		return false;
	}
	
	//method to delete user
	public boolean delUser(String input) 
	{
		//checks to make sure user exists
		if(searchUser(input) != null)
		{
			//removes user
			getAllStudents().remove(searchUser(input));
			return true;
			
		}
		return false;
	}
	
	//method to search for a user by their name, returns a null if not present 
	public Student searchUser(String input) 
	{
		
		
		for(Student i : getAllStudents())
		{
			if(input.equalsIgnoreCase(i.getUserName())) 
			{
				return i;
			}
		}
		
		return null;
	}
	
	//password validation method
	public boolean validate(String name, String pass) 
	{
		//check if user exists
		if(searchUser(name) != null)
		{
			//check if the passCodes match
			if (searchUser(name).getPassCode().equals(pass)) 
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	
	
}
