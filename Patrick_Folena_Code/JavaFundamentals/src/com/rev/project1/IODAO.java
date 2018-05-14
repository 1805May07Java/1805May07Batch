package com.rev.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IODAO 
{
	final static String fileLocation = "src/com/rev/project1/UserList.txt";
	
	void addUser(User newUser)
	{
		try(BufferedWriter writer = 
				new BufferedWriter(new FileWriter(fileLocation, true))){
			writer.write(newUser.toString());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void changeUser(String oldUser, String newUser)
	{
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
			String oldFile = "";
			String line;
			while((line=br.readLine()) != null) {
				oldFile = oldFile + line + System.lineSeparator();
			}
			String newFile = oldFile.replace(oldUser, newUser);
			FileWriter writer = new FileWriter(fileLocation, false);
			writer.write(newFile);
			br.close();
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> readUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
			String line = null;
			while((line=br.readLine()) != null) {
				String[] data = line.split(":");
				User temp = new User(); 
				temp.setUserName(data[0]);
				temp.setPassWord(data[1]);
				temp.setFirstName(data[2]);
				temp.setLastName(data[3]);
				temp.setEmail(data[4]);
				temp.setCashAmount(Double.parseDouble(data[5]));
				users.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
}
