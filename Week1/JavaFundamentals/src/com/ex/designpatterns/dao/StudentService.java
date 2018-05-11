package com.ex.designpatterns.dao;

import java.util.ArrayList;

public class StudentService {
	static ArrayList<Student> students;
	static {
		students = new ArrayList<Student>();
		students.add(new Student(1, "username", "password", 3.5));
		students.add(new Student(2, "Genesis", "bonds", 4.0));
		students.add(new Student(3, "Johnny", "Bravo", 2.75));
	}
	
	ArrayList<Student> getAllStudents(){
		//until we deal w DAO, all we do here is return our static arraylist
		return students;
	}
	
	boolean exists (String username) {
		ArrayList<Student> students = getAllStudents();
		return students.stream().anyMatch(
				s -> s.getUsername().equalsIgnoreCase(username));
	}
	
	Student getByUsername(String username) {
		return getAllStudents().stream().
				filter(s -> s.getUsername().equalsIgnoreCase(username)).
					findFirst().get();
	}
	
	
	
	
	//log in -- see if username exists, then check pw
}
