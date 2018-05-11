package com.revature.dao;

import java.util.ArrayList;

public class StudentService {

	private static ArrayList<Student> students;

	static {
		students = new ArrayList<Student>();

	}

	ArrayList<Student> getAllStudents() {
		return students;
	}
}
