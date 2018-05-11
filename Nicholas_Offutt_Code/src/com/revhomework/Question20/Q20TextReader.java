package com.revhomework.Question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Q20TextReader 
{

	
	//main method
	public static void main(String[] args) 
	{
		//file path of our read file 
		String path = "src\\com\\revhomework\\Question20\\Data.txt";
		//where we are sticking each line of the file
		String line = "";
		
	
		
			//set up the try catch block for file reading
			try 
			{
				//attempt to load the file 
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				//holder strings for the data
				String firstName;
				String lastName;
				String age;
				String state;
				
				
				//read each whole line from the file, and print out it's separated contents 
				while((line = reader.readLine()) != null) 
				{
					//the array of strings we are splitting each line into
					String[] data = line.split(":");
					
					/*print out the value of each part of String [] data, we know how many
					 *pieces the data is in we know how big array passed back will be. 
					 *we could have not bothered with loading them into  holders but this 
					 *is easier to read.
					 **/
					firstName = data[0];
					lastName = data[1];
					age = data[2];
					state = data[3];
					
					//actual print statements
					System.out.println("Name: " + firstName + " " + lastName);
					System.out.println("Age: " + age + " years");
					System.out.println("State: " + state + " state");
					
				}
				
				//close reader
				reader.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
			
			
			
	}
}
