package com.ex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.service.*;

/*
 * Main Runnable Class
 */
public class BankingApp
{
	static Scanner scan = new Scanner(System.in);
	static AccountService as = new AccountService();
	static AccountTypeService ats = new AccountTypeService();
	static TransactionService ts = new TransactionService();
	static UserService us = new UserService();
	
	private static User currentUser;
	private static Account currentAccount;
	
	
	//Minimum amount required to open up an account
	static final float minInitialAmount = 50;
	//Maximum amount that can be deposited at once
	static final float maxDeposit = Float.MAX_VALUE;
	//Maximum amount that the account can hold
	static final float maxAmount = Float.MAX_VALUE;
	//Maximum amount that can be withdrawn at once;
	static final float maxWithdrawal = Float.MAX_VALUE;
	
	public static void main(String[] args) {
		loginPage();
		scan.close();
	}
	
	static void loginPage() {
		boolean loop = true;
		
		while(loop) {
			System.out.println("============================================================");
			System.out.println("LOGIN PAGE");
			System.out.println("============================================================");
			System.out.println("Welcome to Revature Banking Services. \n"
					+"Please enter your username, 'register' to create a new account, \n"
					+"or 'quit' to exit the application.");
			
			String newLine = scan.nextLine().toLowerCase();
			switch(newLine) {
			case "register":
				newUserPage();
				break;
			case "quit":
				System.out.println("------------------------------------------------------------");
				loop = false;
				System.out.println("Thank you for using our service!");
				break;
			default:
				currentUser = us.findUserByName(newLine);
				
				if(attemptLogin())
				{
					System.out.println("------------------------------------------------------------");
					System.out.println("Login Succesful! Welcome, " + currentUser.getFirstname());
					userMainPage();
				}
				else
				{
					System.out.println("------------------------------------------------------------");
					System.out.println("Username/Password is not valid, please try again");
				}
			}
		}
	}
	
	static boolean attemptLogin()
	{
		System.out.println("------------------------------------------------------------");
		System.out.println("Enter your password");
		String password = scan.nextLine();
		
		return(currentUser != null && currentUser.getPassword().equals(password));
	}
	
	static void newUserPage()
	{
		System.out.println("============================================================");
		System.out.println("SETUP NEW ACCOUNT");
		System.out.println("============================================================");
		
		User user = new User();
		Account acct = new Account();
		
		Boolean dataFilled = false;
		Boolean finished = false;
		String[] data = new String[9];
		for(int i = 0; i < data.length; i++) {
			data[i] = "";
		}
		acct.setAccountAmount(minInitialAmount);
		acct.setJoint(false);
		data[7] = moneyToString(minInitialAmount);
		
		while(!finished) {
			System.out.println("------------------------------------------------------------");
			dataFilled = true;
			
			for(int i = 0; i < data.length; i++) {
				if(data[i].isEmpty()) {
					dataFilled = false;
					break;
				}
			}
			
			System.out.println("11 - Username : [" + data[0] + "]\n"
					+ "12 - Password : [" + data[1].replaceAll(".", "*") + "]\n"
					+ "13 - Confirm Password : [" + data[2].replaceAll(".",  "*") + "]\n\n"
					+ "21 - First Name : [" + data[3] + "]\n"
					+ "22 - Last Name : [" + data[4] + "]\n"
					+ "23 - Email Address : [" + data[5] + "]\n\n"
					+ "31 - Primary Account Type : [" + data[6] + "]\n"
					+ "32 - Initial Deposit : [" + data[7] + "]\n"
					+ "33 - Primary Account Nickname : [" + data[8] + "]\n");
			if(dataFilled) {
				System.out.println("9 - Register Account");
			}
			System.out.println("0 - Return to Main Menu\n\n"
					+ "Enter a Field Number.");
			
			int op = 0;
			String readLine = "";
			
			try {
				op = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again");
				continue;
			}

			System.out.println("------------------------------------------------------------");
			switch(op) {
			case 0:
				System.out.println("Returning to Main Menu");
				finished = true;
				break;
			case 11:	//readLine = username
				System.out.println("Please enter a Username");
				readLine = scan.nextLine().toLowerCase();
			
				if(!readLine.matches("[a-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Username must be alphanumeric");
				}
				else if (readLine.equals("register") || readLine.equals("quit")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid Username. Please choose a different one");
				}
				else if(us.findUserByName(readLine) != null) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Username is not Unique. Please choose a different one.");
				}
				else
				{
					user.setUsername(readLine);
					data[0] = readLine;
				}
				break;
			case 12:	//readLine = password
				System.out.println("Please enter a Password");
				readLine = scan.nextLine();
				if(!readLine.matches("[A-Za-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Password must be alphanumeric.");
				}
				else 
				{
					user.setPassword(readLine);
					data[1] = readLine;
					data[2] = "";
				}
				break;
			case 13: //readLine = password
				System.out.println("Please confirm your Password");
				readLine = scan.nextLine();
				if(data[1].length() != 0 && readLine.equals(data[1]))
					data[2] = data[1];
				else
				{
					System.out.println("------------------------------------------------------------");
					System.out.println("Passwords do not match.");
				}
				break;
			case 21: //readline = first name
				System.out.println("Please enter your first name");
				readLine = scan.nextLine();
				if(readLine.matches("[A-Za-z]+"))
				{
					user.setFirstname(readLine);
					data[3] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid: Name should only contain letters.");
				}
				break;
			case 22: //readline = last name
				System.out.println("Please enter your last name");
				readLine = scan.nextLine();
				if(readLine.matches("[A-Za-z]+"))
				{
					user.setLastname(readLine);
					data[4] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid: Name should only contain letters.");
				}
				break;
			case 23: //readline = email
				System.out.println("Please enter a valid email address");
				readLine = scan.nextLine();
				//Searched online for email regex
				if(readLine.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
				{
					user.setEmail(readLine);
					data[5] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid Email Format.");
				}
				break;
			case 31: //readLine = account type
				//Use a statement to retrieve the data from "ACCOUNT TYPES"
				List<AccountType> service = new ArrayList<AccountType>();
				service = ats.getAll();
				for(int i = 0; i < service.size(); i++)
				{
					System.out.println((i+1) + " - " + service.get(i).getName() + 
							"\n\nDESC: " + service.get(i).getDescription() + "\n");
					System.out.println("------------------------------------------------------------");
				}
				System.out.println("Please enter the number for the account you would like to open.");
				int opAcc = 0;
				try {
				opAcc = Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid input. Please try again");
					continue;
				}
				if(opAcc > service.size() || opAcc <= 0) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Not a valid selection.");
					break;
				}
				acct.setAccountType(opAcc--);
				data[6] = service.get(opAcc).getName();
				break;
			case 32:	//readLine = initial deposit
				System.out.println("Please enter an initial deposit [minimum " + moneyToString(minInitialAmount) + "]");
				readLine = scan.nextLine();
				float money = 0;
				try{
					money = Float.parseFloat(readLine);
				}
				catch(NumberFormatException e){
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid entry. Please enter full dollar amounts without commas");
					break;
				}
				
				if(money < minInitialAmount) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Initial deposit must be greater than " + moneyToString(minInitialAmount));
				}
				else if (money > maxAmount) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Initial deposit exceeds account capacity");
				}
				else {
					acct.setAccountAmount(money);
					data[7] = moneyToString(money);
				}
				break;
			case 33:
				System.out.println("Please enter a Nickname for the Account");
				readLine = scan.nextLine();
			
				if(!readLine.matches("[A-Za-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Nickname must be alphanumeric");
				}
				else {
					acct.setNickname(readLine);
					data[8] = readLine;
				}
				break;
			case 9:
				if(dataFilled)
				{
					user = us.addUser(user);
					acct = as.addAccount(acct);
					acct.setJointPassword(getRandomString());
					
					us.addUserAccount(user, acct);
					
					System.out.println("Succesfully registered new user '" + data[0] + "'");
					finished = true;
					break;
				}
			default:
				System.out.println("Invalid Field Number.");
			}
		}
	}
	
	private static String getRandomString()
	{
		Random random = new Random();
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 16;
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for(int i = 0; i < targetStringLength; i++) {
			int randomInt = leftLimit + (int)(random.nextFloat() * (rightLimit-leftLimit+11));
			if(randomInt > 122)
			{
				buffer.append((char)('0' + (randomInt-123)));
			}
			else
			{
				buffer.append((char)(randomInt));
			}
		}
		return buffer.toString();
	}
	
	static void userMainPage()
	{
		boolean loop = true;
		while(loop)
		{
			System.out.println("============================================================");
			System.out.println("MAIN MENU (" + currentUser.getUsername() + ")");
			System.out.println("============================================================");
			System.out.println(
					  "1 - Access Accounts\n"
					+ "2 - Create a New Banking Account\n"
					+ "3 - Transaction History\n"
					+ "4 - Change User Settings\n\n"
					+ "0 - Logoff\n\n"
					+ "Please choose from the following options...");
			
			int op;
			try {
				op = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again\n");
				continue;
			}

			switch(op)
			{
			case 1:
				userAccountBrowserPage();
				break;
			case 2:
				newAccountPage();
				break;
			case 3:
				userTransactionsPage();
				break;
			case 4:
				updateUserPage();
				break;
			case 0:
				System.out.println("------------------------------------------------------------");
				System.out.println("Logging off");
				currentUser = null;
				loop = false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid Option Number.");
			}
		}
	}
	
	static void newAccountPage()
	{
		System.out.println("============================================================");
		System.out.println("New Account Creation");
		System.out.println("============================================================");
		
		boolean loop = true;
		boolean finished = false;
		
		String[] data = new String[4];

		for(int i = 0; i < data.length; i++)
		{
			data[i] = "";
		}
		data[2] = moneyToString(minInitialAmount);
		
		Account acct = new Account();
		acct.setAccountAmount(minInitialAmount);
		
		while(loop)
		{	
			finished = true;
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length() == 0) finished = false;
			}
			
			System.out.println("----------------------------------------------------------");
			System.out.println("1 - Account Nickname [" + data[0] + "]\n"
					+ "2 - Account Type [" + data[1] + "]\n"
					+ "3 - Initial Deposit Amount [" + data[2] + "]\n"
					+ "4 - Allow Joint Account Connections [" + data[3] + "]\n");
			if(finished) System.out.println("9 - Submit\n");
			System.out.println("0 - Return to User Menu\n");
			System.out.println("Please choose from the following options...");
			
			int op;
			String readLine;
			
			try {
				op = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again\n");
				continue;
			}
			
			System.out.println("------------------------------------------------------------");
			switch(op) {
			case 0:
				System.out.println("Returning to Login Page");
				loop = false;
				break;
			case 1:
				System.out.println("Please enter a Nickname for the Account");
				readLine = scan.nextLine();
			
				if(!readLine.matches("[A-Za-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Nickname must be alphanumeric");
				}
				else {
					acct.setNickname(readLine);
					data[0] = readLine;
				}
				break;
			case 2:
				List<AccountType> service = new ArrayList<AccountType>();
				service = ats.getAll();
				for(int i = 0; i < service.size(); i++)
				{
					System.out.println((i+1) + " - " + service.get(i).getName() + 
							"\n\nDESC: " + service.get(i).getDescription() + "\n");
					System.out.println("------------------------------------------------------------");
				}
				System.out.println("Please enter the number for the account you would like to open.");
				int opAcc;
				try {
				opAcc = Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid input. Please try again");
					continue;
				}
				if(opAcc > service.size() || opAcc < 1) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Not a valid selection.");
					break;
				}
				acct.setAccountType(opAcc--);
				data[1] = service.get(opAcc).getName();
				break;
			case 3:
				System.out.println("Please enter an initial deposit [minimum " + moneyToString(minInitialAmount) + "]");
				readLine = scan.nextLine();
				float money = 0;
				try{
					money = Float.parseFloat(readLine);
				}
				catch(NumberFormatException e){
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid entry. Please enter full dollar amounts without commas");
					break;
				}
				
				if(money < minInitialAmount) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Initial deposit must be greater than " + moneyToString(minInitialAmount));
				}
				else if (money > maxAmount) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Initial deposit exceeds account capacity");
				}
				else {
					acct.setAccountAmount(money);
					data[2] = moneyToString(money);
				}
				break;
			case 4:
				System.out.println("Would you like to allow joint account access for this account? [Y/N]");
				readLine = scan.nextLine().toLowerCase();
				if(readLine.equals("y") || readLine.equals("n"))
				{
					acct.setJoint(readLine.equals("y"));
					data[3] = readLine.equals("y") ? "Y" : "N";
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Not a valid option.");
				}
				break;
			case 9:
				if(finished)
				{
					acct.setJointPassword(getRandomString());
					acct = as.addAccount(acct);
					
					us.addUserAccount(currentUser, acct);
					
					//Create Account
					System.out.println("New Account <" + acct.getNickname() + "> has been created.");
					loop = false;
					break;
				}
			default: System.out.println("Invalid Field Number.");
			}
		}
	}
	
	static void userAccountBrowserPage()
	{
		boolean loop = true;
		
		while(loop)
		{
			List<Account> acctList = new ArrayList<Account>();
			acctList = as.getUserAccountList(currentUser);
			
			System.out.println("============================================================");
			System.out.println("USER ACCOUNT BROWSER");
			System.out.println("============================================================");
		
			System.out.printf("%-5s %-20s %-16s %16s\n", "ID", "Nickname", "Account Type", "Amount");
			System.out.println("------------------------------------------------------------");
		
			int x = 1;
			for(Account acct:acctList)
			{
				System.out.printf("%-5d %-20s %-16s %16s\n", x, acct.getNickname(), 
					ats.getName(acct.getAccountType()), moneyToString(acct.getAccountAmount()));
				x++;
			}
		
			System.out.println("------------------------------------------------------------");
			System.out.println("Please type in the ID number for the account you would like to access, \n"
				+ "or 0 to return to the main menu.");
		
			int opAcc = 0;
			try 
			{
				opAcc = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again");
				continue;
			}
			
			if(opAcc > acctList.size() || opAcc < 0)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid Account ID. Please try again");
			}
			else if(opAcc == 0)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Returning to Main Menu");
				loop = false;
				continue;
			}
			else
			{
				currentAccount = acctList.get(opAcc-1);
				userAccountPage();
				currentAccount = null;
			}
		}
	}
	
	static void userAccountPage()
	{
		boolean loop = true;
		while(loop)
		{
			System.out.println("============================================================");
			System.out.printf("%s account \"%s\" %18s\n", ats.getName(currentAccount.getAccountType()),
					currentAccount.getNickname(), moneyToString(currentAccount.getAccountAmount()));
			System.out.println("============================================================");
			System.out.println("What would you like to do today?\n\n"
							+ "1 - Withdraw Funds\n"
							+ "2 - Deposit Funds\n"
							+ "3 - Transfer Funds\n"
							+ "4 - View Account Summary\n"
							+ "5 - Update Account Settings\n\n"
							+ "0 - Return to Accounts Screen\n");
		
			int opAcc = 0;
			try 
			{
				opAcc = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again");
				continue;
			}
			
			switch(opAcc) {
			case 0:
				System.out.println("------------------------------------------------------------");
				System.out.println("Returning to Accounts Screen");
				loop = false;
				break;
			case 1:
				withdrawPage();
				break;
			case 2:
				depositPage();
				break;
			case 3:
				transferPage();
				break;
			case 4:
				userAccountSummaryPage();
				break;
			case 5:
				updateAccountPage();
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid option. Please try again");
			}
		}
	}
	
	static void updateUserPage()
	{
		System.out.println("------------------------------------------------------------");
		System.out.println("UPDATE USER PAGE");
		User update = new User();
		update.copy(currentUser);
		
		String[] data = {currentUser.getUsername(), 
				currentUser.getPassword(),
				currentUser.getPassword(),
				currentUser.getFirstname(), 
				currentUser.getLastname(), 
				currentUser.getEmail()};
		
		boolean finished = false;
		boolean dataFilled;
		
		while(!finished) {
			dataFilled = true;
			
			for(int i = 0; i < data.length; i++) {
				if(data[i].isEmpty()) {
					dataFilled = false;
					break;
				}
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("1 - Username : [" + data[0] + "]\n"
					+ "2 - Password : [" + data[1].replaceAll(".", "*") + "]\n"
					+ "3 - Confirm Password : [" + data[2].replaceAll(".",  "*") + "]\n\n"
					+ "4 - First Name : [" + data[3] + "]\n"
					+ "5 - Last Name : [" + data[4] + "]\n"
					+ "6 - Email Address : [" + data[5] + "]\n");
			if(dataFilled) {
				System.out.println("9 - Update Account\n");
			}
			System.out.println("0 - Return to Main Menu\n\n"
					+ "Enter a Field Number.");
			
			int op = 0;
			String readLine = "";
			
			try {
				op = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input. Please try again");
				continue;
			}
			
			System.out.println("------------------------------------------------------------");
			switch(op) {
			case 0:
				System.out.println("Returning to Main Menu");
				finished = true;
				break;
			case 1:	//readLine = username
				System.out.println("Please enter a Username");
				readLine = scan.nextLine().toLowerCase();
			
				if(!readLine.matches("[a-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Username must be alphanumeric");
				}
				else if (readLine.equals("register") || readLine.equals("quit")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid Username. Please choose a different one");
				}
				else if(!readLine.equals(update.getUsername()) && us.findUserByName(readLine) != null) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Username is not Unique. Please choose a different one.");
				}
				else
				{
					update.setUsername(readLine);
					data[0] = readLine;
				}
				break;
			case 2:	//readLine = password
				System.out.println("Please enter a Password");
				readLine = scan.nextLine();
				if(!readLine.matches("[A-Za-z0-9!@#$%^&*()_]+")) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Password must be alphanumeric.");
				}
				else 
				{
					update.setPassword(readLine);
					data[1] = readLine;
					data[2] = "";
				}
				break;
			case 3: //readLine = password
				System.out.println("Please confirm your Password");
				readLine = scan.nextLine();
				if(data[1].length() != 0 && readLine.equals(data[1]))
					data[2] = data[1];
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Passwords do not match.");
				}
				break;
			case 4: //readline = first name
				System.out.println("Please enter your first name");
				readLine = scan.nextLine();
				if(readLine.matches("[A-Za-z]+"))
				{
					update.setFirstname(readLine);
					data[3] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid: Name should only contain letters.");
				}
				break;
			case 5: //readline = last name
				System.out.println("Please enter your last name");
				readLine = scan.nextLine();
				if(readLine.matches("[A-Za-z]+"))
				{
					update.setLastname(readLine);
					data[4] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid: Name should only contain letters.");
				}
				break;
			case 6: //readline = email
				System.out.println("Please enter a valid email address");
				readLine = scan.nextLine();
				//Searched online for email regex
				if(readLine.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
				{
					update.setEmail(readLine);
					data[5] = readLine;
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Invalid Email Format.");
				}
				break;
			case 9:
				if(dataFilled)
				{
					currentUser = us.updateUser(update);
					
					System.out.println("Succesfully updated to user '" + data[0] + "'");
					finished = true;
					break;
				}
			default:
				System.out.println("Invalid Field Number.");
			}
		}
	}
	
	static void updateAccountPage()
	{
		
	}
	
	static void withdrawPage()
	{
		System.out.println("============================================================");
		System.out.println("WITHDRAW FUNDS");
		System.out.println("============================================================");
		
		System.out.println("Current Balance = " + moneyToString(currentAccount.getAccountAmount()));
		System.out.print("Withdraw : ");
		
		float deltaFund = 0;
		try 
		{
			deltaFund = Float.parseFloat(scan.nextLine());
		}
		catch(NumberFormatException e) 
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Invalid input.");
			return;
		}
		
		System.out.println("------------------------------------------------------------");
		if(deltaFund > maxWithdrawal)
		{
			System.out.println("Exceeds max withdrawal allowance (" + moneyToString(maxWithdrawal) + ")");
		}
		else if (currentAccount.getAccountAmount() - deltaFund < 0)
		{
			System.out.println("Error: Insufficient funds");
		}
		else if (deltaFund < 0)
		{
			System.out.println("Error: Positive Amounts Only");
		}
		else
		{
			currentAccount = as.transferFunds(currentAccount, -deltaFund);
			System.out.println("Withdrew " + moneyToString(deltaFund));
		}
	}
	
	static void depositPage()
	{
		System.out.println("============================================================");
		System.out.println("DEPOSIT FUNDS");
		System.out.println("============================================================");
		
		System.out.println("Current Balance = " + moneyToString(currentAccount.getAccountAmount()));
		
		float deltaFund = 0;
		try 
		{
			deltaFund = Float.parseFloat(scan.nextLine());
		}
		catch(NumberFormatException e) 
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Invalid input.");
			return;
		}
		
		System.out.println("------------------------------------------------------------");
		if(deltaFund > maxDeposit)
		{
			System.out.println("Exceeds max deposit allowance (" + moneyToString(maxWithdrawal) + ")");
		}
		else if (currentAccount.getAccountAmount() + deltaFund > maxDeposit)
		{
			System.out.println("Error: Exceeds Account Capacity");
		}
		else if (deltaFund < 0)
		{
			System.out.println("Error: Positive Amounts Only");
		}
		else
		{
			currentAccount = as.transferFunds(currentAccount, deltaFund);
			System.out.println("Deposited " + moneyToString(deltaFund));
		}
	}
	
	static void transferPage()
	{
		System.out.println("============================================================");
		System.out.println("TRANSFER FUNDS");
		System.out.println("============================================================");
		
		System.out.println("Current Balance = " + moneyToString(currentAccount.getAccountAmount()));
		System.out.print("Transfer Account Number : ");
		
		int accountNumber = 0;
		try 
		{
			accountNumber = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e) 
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Invalid input.");
			return;
		}
		
		Account transferUser = as.findAccountByNumber(accountNumber);
		
		if(transferUser != null)
		{
			System.out.println("Transfer Amount");
			float transferFunds = 0;
			try 
			{
				transferFunds = Float.parseFloat(scan.nextLine());
			}
			catch(NumberFormatException e) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Invalid input.");
				return;
			}
			
			if(currentAccount.getAccountAmount() - transferFunds < 0)
			{
				System.out.println("Insufficient funds for transfer");
				return;
			}
			currentAccount = as.transferFunds(currentAccount, -transferFunds);
			as.transferFunds(transferUser, transferFunds);
			System.out.println("Transferred " + moneyToString(transferFunds) + "\n"
					+ "FROM ACCOUNT: " + currentAccount.getAccountNumber() + "\n"
					+ "TO ACCOUNT: " + transferUser.getAccountNumber());
		}
		else
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Unable to find designated account.");
		}
		//currentAccount = as.transferFunds(currentAccount.getID(), -deltaFund);
	}
	
	static void userTransactionsPage()
	{
		System.out.println("============================================================");
		System.out.println("ACCOUNT TRANSACTION HISTORY");
		System.out.println("============================================================");
	}
	
	static void userAccountSummaryPage()
	{
		System.out.println("============================================================");
		System.out.println("ACCOUNT SUMMARY PAGE");
		System.out.println("============================================================");
	}
	
	static void createJointAccountPage()
	{
		System.out.println("============================================================");
		System.out.println("ESTABLISH CONNECTION TO A JOINT ACCOUNT");
		System.out.println("============================================================");
	}
	
	static String moneyToString(float amount)
	{
		String value;
		if(amount >= 1000) {
			value = String.format("%06.2f", amount%1000);
		}
		else {
			return String.format("$%.2f", amount);
		}
		
		int dropMoney = (int) amount;
		
		while(dropMoney >= 1000) {
			dropMoney = dropMoney / 1000;
			if(dropMoney >= 1000)
				value = String.format("%03d", dropMoney%1000) + "," + value;
			else
				value = dropMoney + "," + value;
		}
		return "$" + value;
	}
}
