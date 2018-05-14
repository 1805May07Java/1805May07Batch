package com.ex.designpatterns.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class IODAO {

	final static String fileLocation = "src/com/ex/designpatterns/dao/students.txt";
	
	void addStudent(Student s) {
		//write student file to text
		//try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true)))
		{
			//writer.write(s.toString());
		}
	}
}