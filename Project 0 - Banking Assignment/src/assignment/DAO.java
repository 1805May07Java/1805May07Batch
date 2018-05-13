package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DAO {
	private final static String fileLocation = "src/assignment/users.txt";
	
	// Creates an empty users.txt file if it isn't already there.
	static {
		File file = new File(fileLocation);
		boolean fileExists = file.exists();
		if(!file.exists()) {
			try {
				fileExists = file.createNewFile();
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
		if(fileExists) System.out.println("Empty users.txt exists");
		else System.out.println("Did NOT create users.txt");
	}
	
	/**
	 * Add a single 'User' to the users.txt file
	 * 
	 * @param u	This is the 'User' object we're going to add
	 */
	static void addUser(User u) {
		try(BufferedWriter w = new BufferedWriter(new FileWriter(fileLocation, true))) {
			w.write(u.toString());
			w.newLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Read off of the users.txt file and return an ArrayList containing each 'User'.
	 * 
	 * @return The ArrayList will all 'User' from the user.txt file
	 */
	static public ArrayList<User> readAllUsers() {
		ArrayList<User> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
			String line = null;
			while((line=br.readLine()) != null) {
				String[] data = line.split(":");
				User temp = new User(data);
				list.add(temp);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * I tried other ways first and found this to be the simplest.
	 * This function will clear the contents of the users.txt file, then refill it with the updated list.
	 * 
	 * @param list The list of Users
	 */
	static void syncUsers(ArrayList<User> list) {
		cleanUp();
		for(User u : list) {
			addUser(u);
		}
	}
	
	/**
	 * A helper function to clear the contents of users.txt 
	 */
	static void cleanUp() {
		try {
			PrintWriter pw = new PrintWriter(fileLocation);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
