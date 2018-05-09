/*
 * DataReader.java
 * Author: Cole Vikupitz
 * 
 * Exercise 20: Program that reads data from a file, and displays each
 * entry's full name, age, and location.
 */


package com.revature.exercise20;

// Imports
import java.io.BufferedReader;
import java.io.FileReader;

public class DataReader {
	
	/**
	 * Reads from the file 'file' and parses its data. Displays each
	 * entry's full name, age, and location.
	 * 
	 * @param file - The data file to read from.
	 */
	public static void parseDataFile(String file) {
		
		try {
			
			// Opens up the specified file, create a reader for that file
			FileReader fReader = new FileReader(file);
			BufferedReader bfReader = new BufferedReader(fReader);
			String dataLine = null;
			
			// Loop until no more lines can be read in the file
			while ((dataLine = bfReader.readLine()) != null) {
				try {
					// Parses the data; splits entries up by ':'
					// Displays the full name on one line, age another, and location on another
					String[] entries = dataLine.split(":");
					System.out.printf("Name: %s %s\n", entries[0], entries[1]);
					System.out.printf("Age: %s\n", entries[2]);
					System.out.printf("Location: %s\n\n", entries[3]);
				} catch(Exception e) {
					// Skip illegal lines (lines that can't be parsed)
				}
			}
			
			// Close up the reader connection(s)
			bfReader.close();
			fReader.close();
			
		} catch (Exception e) {
			// If file could not open for some reason, display error
			System.out.printf("Failed to open: %s\n", file);
		}
	}

	public static void main(String[] args) {
		
		// Read from the specified data file, parse and display data
		final String FILE = "Data.txt";
		parseDataFile(FILE);
	}

}
