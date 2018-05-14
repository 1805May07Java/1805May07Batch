package com.ex.designpatterns.dao;

import java.util.ArrayList;

public class StudentService {
	static ArrayList<Student> students;
	static int lastNumber = 1;
	
	static {
		students = new ArrayList<Student>();
	}
	
	public void addNewStudent(String username, String password, double gpa)
	{
		students.add(new Student(genID(), username, password, gpa));
	}
	
	private static int genID()
	{
		return lastNumber++;	
	}
	
	ArrayList<Student> getAllStudents(){
		//until we deal w DAO, all we do here is return our static arraylist
		return students;
	}
	
	public boolean exists (String username) 
	{
		ArrayList<Student> students = getAllStudents();
		return students.stream().anyMatch(name->name.getUsername().equalsIgnoreCase(username));
	}

	public Student getByUsername(String username) {
        return getAllStudents().stream().
                filter(s -> s.getUsername().equalsIgnoreCase(username)).
                    findFirst().get();
    }
}