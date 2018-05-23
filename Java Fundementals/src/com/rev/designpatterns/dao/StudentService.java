package com.rev.designpatterns.dao;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;

public class StudentService {

	static ArrayList<Student> students;
	static {
		students = new ArrayList<Student>();
		students.add(new Student(1, "username", "password", 3.5));
		students.add(new Student(2, "Genisis", "bonds", 4.0));
		students.add(new Student(3, "johnny", "Bravo", 2.75));
		
	}
	
	ArrayList<Student> getAllStudents(){
		ioDAO dao = new ioDAO();
		return dao.getAllStudents();
	}
	
	boolean exists (String username) {
		ArrayList<Student> students = getAllStudents();
		
		return students.stream().anyMatch(s -> s.getUserName().equalsIgnoreCase(username));
	}
	
	Student getByUsername(String username) {
		
		return getAllStudents().stream().
				filter(s -> s.getUserName().equalsIgnoreCase(username)).
				findFirst().get();
	}
	
	void addStudent(String name, String pass, double gpa) {
		int id = (int) (Math.random() * 1000);
		Student s = new Student(id, name, pass, gpa);
		ioDAO dao = new ioDAO();
		dao.addStudent(s);
		students.add(s);
	}
}
