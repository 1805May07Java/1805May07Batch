package com.rev.datareader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class DataReader {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\vde43\\Documents\\revature-warmups\\DataReader\\data.txt.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {
		    String[]data = st.split(":");
		    String fname = data[0];
		    String lname = data[1];
		    String age = data[2];
		    String state = data[3];
		    
		    System.out.println("Name: " + fname + lname);
		    System.out.println("Age: " + age + " years");
		    System.out.println("State: " + state);
		    System.out.println();
		}
		
		br.close();
	}

}
