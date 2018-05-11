package com.rev.questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProccessData {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("Data.txt"));
		
		while (s.hasNextLine()) {
			String[] line = s.nextLine().split(":");

			System.out.println("Name: " + line[0] + " " + line[1]);
			System.out.println("Age: " + line[2] + " years");
			System.out.println("State: " + line[3] + " state");
			System.out.println();
		}
		
		s.close();
	}

}
