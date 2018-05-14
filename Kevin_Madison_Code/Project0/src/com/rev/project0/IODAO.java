package com.rev.project0;

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

	final static String fileLocation = "src/com/rev/project0/Accounts.txt";

	void addAccount(Account s) {
		// write Account file to text
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {
			writer.write(s.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Account> readAccounts() {
		ArrayList<Account> Accounts = new ArrayList<Account>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(":");
				Account temp = new Account();
				temp.setFn(data[0]);
				temp.setLn(data[1]);
				temp.setUsername(data[2]);
				temp.setPassword(data[3]);
				temp.setBalance(Double.parseDouble(data[4]));
				Accounts.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Accounts;
	}

	public void updateAccount(ArrayList<Account> accountsList) {
		// write Account file to text
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false))) {
			for (int i = 0; i < accountsList.size(); i++) {
				writer.write(accountsList.get(i).toString());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void serializeRoster() {
		/*
		 * To serialize an object means to convert its state to a byte stream so that
		 * the byte stream can be reverted back into a copy of the object. A Java object
		 * is serializable if its class or any of its superclasses implements either
		 * Serializable or its subinterface Externalizable
		 */
		ArrayList<Account> roster = readAccounts();

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileLocation))) {
			oos.writeObject(roster);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serializeRoster(ArrayList<Account> accounts) {
		/*
		 * To serialize an object means to convert its state to a byte stream so that
		 * the byte stream can be reverted back into a copy of the object. A Java object
		 * is serializable if its class or any of its superclasses implements either
		 * Serializable or its subinterface Externalizable
		 */
		ArrayList<Account> roster = accounts;

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileLocation))) {
			oos.writeObject(roster);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Account> deserialize() {
		ArrayList<Account> roster = new ArrayList<Account>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileLocation))) {
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