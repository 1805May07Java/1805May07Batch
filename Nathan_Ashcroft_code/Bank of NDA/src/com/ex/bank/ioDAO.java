package com.ex.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ioDAO {
	//location for my file of users
	final static String fileLocation = "src/com/ex/bank/users.txt";

	//add a user to my file
	void addUser(User u) {
		try(BufferedWriter writter = new BufferedWriter(new FileWriter(fileLocation, true))){
			writter.write(u.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	//get all users
	ArrayList<User> getAllUsers(){
		ArrayList<User> list = new ArrayList<User>();

		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				String[] tmp = currLine.split(":");

				User u = new User();

				u.setfName(tmp[0]);
				u.setlName(tmp[1]);
				u.setUserName(tmp[2]);
				u.setPassword(tmp[3]);
				u.setBalance(Double.parseDouble(tmp[4]));
				list.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

		return list;
	}

	void addAllUsers(ArrayList<User> u){
		try {
			BufferedWriter writter = new BufferedWriter(new FileWriter(fileLocation, false));
			for(int i = 0; i < u.size(); i++) {
				writter.write(u.get(i).toString());
			}
			writter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
