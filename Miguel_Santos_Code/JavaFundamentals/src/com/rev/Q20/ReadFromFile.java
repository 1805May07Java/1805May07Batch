package com.rev.Q20;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFromFile {

	public static void organize(String fileN) {				//organize method takes in parameter of the file name
		try {													//used to handle case of exception
			Scanner s = new Scanner(new File(fileN));			//Import desired text file 
			String[] inf = new String [4];							//Create string array of four elements
			String x;												//Create a temp string variable
			while(s.hasNextLine()) {								//While there's still content in the file,
				x = s.nextLine();									//store an entire line into temp variable
				inf = x.split(":");									//Separate text into different array elements
				System.out.println("Name: " + inf[0] + " " + inf[1]);	//Print parsed info into desired ___
				System.out.println("Age: " + inf[2] + " years");
				System.out.println("State: " + inf[3] + " state");
				System.out.println("  ");
			}
		}
		catch(IOException e) {									//in case exception is caught,
			System.out.println(e);								//print exception.
		}
	}



}
