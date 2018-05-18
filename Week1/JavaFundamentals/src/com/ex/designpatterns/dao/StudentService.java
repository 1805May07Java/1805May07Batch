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
		
		IODAO dao = new IODAO();
		return dao.readStudents();
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
	
	
	Student addStudent(String username, String password, double gpa) {
		int id = (int)( Math.random()*10000);
		
		Student s = new Student(id, username, password, gpa); 
		IODAO dao = new IODAO();
		dao.addStudent(s);
		return s;
	}
	
	
	
	//log in -- see if username exists, then check pw
}
