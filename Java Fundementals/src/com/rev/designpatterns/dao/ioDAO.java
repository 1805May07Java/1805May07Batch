package com.rev.designpatterns.dao;

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

public class ioDAO {
	final static String fileLocation = "src/com/rev/designpatterns/dao/students.txt";
	final static String sFile = "src/com/rev/designpatterns/dao/backup.txt";
	
	void addStudent(Student s) {
		try(BufferedWriter writter = new BufferedWriter(new FileWriter(fileLocation, true))){
			writter.write(s.toString());
		} catch(IOException e) {
			
		}
	}
	
	
	ArrayList<Student> getAllStudents(){
		ArrayList<Student> list= new ArrayList<Student>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				String[] tmp = currLine.split(":");
			
				int id = Integer.parseInt(tmp[0]);
				String username = tmp[1];
				String password = tmp[2];
				double gpa = Double.parseDouble(tmp[3]);
				
				Student s = new Student();
				s.setId(id);
				s.setUserName(username);
				s.setGpa(gpa);
				s.setPassword(password);
				list.add(s);
				System.out.println(s.getUserName());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
	
	public void serializeRoster() {
		ArrayList<Student> roster = new ArrayList<Student>();
		
		String sFile = "src/com/rev/designpatterns/dao/backup.txt";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sFile))){
			oos.writeObject(roster);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> deserialize(){
		//ArrayList<Student> roster = new ArrayList<Student>();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sFile))){
		//	roster = (ArrayList<Student>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//} //catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
