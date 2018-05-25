package com.ex.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Dao {

	final static  String fileLocation = "src/com/ex/bank/users.txt";
	
	public ArrayList<User> getData() {
		ArrayList<User> temp = new ArrayList<User>();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileLocation))) {
			temp = (ArrayList<User>)ois.readObject();		// deserialize Array List from .txt file
			ois.close();
			return temp;				
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("There are no users yet.");
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void writeData(ArrayList<User> users) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileLocation))){
			oos.writeObject(users);
			oos.flush();
			oos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
}
