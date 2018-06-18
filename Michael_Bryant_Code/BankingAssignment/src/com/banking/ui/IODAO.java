package com.banking.ui;

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


public class IODAO {
	
	
	final static String fileLocation = "src/com/banking/ui/accounts.txt";
	final static String sFile = "src/com/banking/ui/backup.txt";
	
	public IODAO() {
		
	}
	
	void addAccount(Account account) {
		try(BufferedWriter writer = 
				new BufferedWriter(new FileWriter(fileLocation, true))){
			
			writer.write(account.toString()+ System.lineSeparator());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	void editAccount(Account a) {

		String curLine = null;
		String oldContent = "";
		try(BufferedReader read = new BufferedReader(new FileReader(fileLocation))){
			 FileWriter fw;
	        
			while((curLine = read.readLine()) != null) {

				
				String[] tempArray = curLine.split(":");
				if(tempArray[0].equals(a.getUsername())) {
					curLine = curLine.replace(tempArray[2], Double.toString(a.getBalance()));
					oldContent = oldContent + curLine + System.lineSeparator();
					
				} else {
				oldContent = oldContent + curLine + System.lineSeparator();
				
				}
				
				
				
			}
			fw = new FileWriter(fileLocation);
			fw.write(oldContent);
			fw.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Account> readAccounts(){
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(BufferedReader read= new BufferedReader(new FileReader(fileLocation))){
			String line= null;
			while((line = read.readLine()) != null) {
				String[] a = line.split(":");
				Account temp = new Account();
				temp.setUsername(a[0]);
				temp.setPassword(a[1]);
				temp.setBalance(Double.parseDouble(a[2]));
				accounts.add(temp);
			}
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public void serializeRoster() {
		/*
		 * To serialize an object means to convert its state 
		 * to a byte stream so that the byte stream can be reverted
		 * back into a copy of the object. A Java object is 
		 * serializable if its class or any of its superclasses
		 * implements either Serializable or its subinterface
		 * Externalizable
		 */
		ArrayList<Account> roster = readAccounts();
		
	
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sFile))){
			oos.writeObject(roster);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Account> deserialize(){
		ArrayList<Account> roster = new ArrayList<Account>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sFile))) {
			roster = (ArrayList<Account>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return roster;
	
	}

}
