package com.ex.designpatterns.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IODAO {
	
	final static String fileLocation = "src/com/ex/designpatterns/dao/students.txt";
	final static String sFile = "src/com/ex/designpatterns/dao/backup.txt";
	
	void addStudent(Student s) {
		//write student file to text
		try(BufferedWriter writer = 
				new BufferedWriter(new FileWriter(fileLocation, true))){
			writer.write(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> readStudents(){
		ArrayList<Student> students = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
			String line = null;
			while((line=br.readLine()) != null) {
				String[] data = line.split(":");
				Student temp = new Student(); 
				temp.setId(Integer.parseInt(data[0]));
				temp.setUsername(data[1]);
				temp.setPassword(data[2]);
				temp.setGpa(Double.parseDouble(data[3]));
				students.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	
	public void serializeRoster() {
		/*
		 * To serialize an object means to convert its state 
		 * to a byte stream so that the byte stream can be reverted
		 * back into a copy of the object. A Java object is 
		 * serializable if its class or any of its superclasses
		 * implements either Serializable or its subinterface
		 * Externalizable
		 */
		ArrayList<Student> roster = readStudents();
		
	
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sFile))){
			oos.writeObject(roster);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> deserialize(){
		ArrayList<Student> roster = new ArrayList<Student>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sFile))) {
			roster = (ArrayList<Student>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return roster;
	
	}


}
