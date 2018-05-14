package com.rev.project1;

import java.util.Scanner;

public class Bank 
{
	static Scanner scan;
	static UserService service = new UserService();
	
	static final double minInitialAmount = 500f;
	static final double maxDeposit = 10_000f;
	static final double maxAmount = 1_000_000_000f;
	static final double maxWithdrawal = 100_000_000_000f;
	
	public static void main(String[] args)
	{
		scan = new Scanner(System.in);
		loginPage();
		scan.close();
	}

	static void loginPage()
	{
		System.out.println("LOGIN PAGE");
		boolean loop = true;
		
		String username;
		String password;
		
		while(loop)
		{
		System.out.println("----------------------------------------------------------");
		System.out.println("Welcome to ________ Bank! \n"
				+"Enter your username, NEW ACCOUNT, or QUIT");
		String newLine = scan.nextLine();
		newLine = newLine.toLowerCase();
		switch(newLine)
		{
		case "new account":
			newAccountPage();
			break;
		case "quit":
			loop = false;
			System.out.println("Thank you for using our service!");
			break;
		default:
			User user = null;
			if((user = attemptLogin(newLine)) != null)
			{
				System.out.println("Login Successful!\n");
				userMainPage(user);
			}
			else
			{
				System.out.println("Username/Password is not valid, please try again\n");
			}
		}
		}
	}
	
	static User attemptLogin(String checkUserName)
	{	
		User user = null;
		String userName = checkUserName;
		
		System.out.println("Enter your password");
		String passWord = scan.nextLine();
		
		if(service.exists(userName))
		{
			user = service.getByUsername(userName);
			if(user == null || !user.getPassWord().equals(passWord))
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		return user;
	}
	
	static void newAccountPage()
	{
		System.out.println("SETUP NEW ACCOUNT");
		Boolean dataFilled = false;
		Boolean finished = false;
		String[] data = new String[6];
		for(int i = 0; i < 5; i++)
		{
			data[i] = "";
		}
		data[5] = "500";
		
		while(!finished)
		{
		
			System.out.println("----------------------------------------------------------");
			dataFilled = true;
			for(int i = 0; i < data.length; i++) {
				if(data[i].isEmpty()) {
					dataFilled = false;
					break;
				}
			}
			
			System.out.println("Please type a field number to update...\n"
					+ "[1] Username : " + data[0] + "\n"
					+ "[2] Password : " + data[1] + "\n"
					+ "[3] First Name : " + data[2] + "\n"
					+ "[4] Last Name : " + data[3] + "\n"
					+ "[5] Email : " + data[4] + "\n"
					+ "[6] Initial Cash Deposit : $" + data[5]);
			if(dataFilled)
			{
				System.out.println("[7] Register Account\n");
			}
			
			int op = 0;
			try {
				op = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e)
			{
				//e.printStackTrace();
				System.out.println("Invalid input. Please try again\n");
			}
			
			switch(op)
			{
			case 1:
				System.out.println("Please enter a Username");
				String username = scan.nextLine().toLowerCase();
				if(service.exists(username))
					System.out.println("Username is not Unique. Please choose a different one.");
				else
					data[0] = username;
				break;
			case 2:
				System.out.println("Please enter a Password");
				data[1] = scan.nextLine();
				break;
			case 3:
				System.out.println("Please enter your first name");
				String firstName = scan.nextLine();
				if(firstName.matches("[A-Za-z]+"))
					data[2] = firstName;
				else
					System.out.println("Invalid: Name should only contain letters.\n");
				break;
			case 4:
				System.out.println("Please enter your last name");
				String lastName = scan.nextLine();
				if(lastName.matches("[A-Za-z]+"))
					data[3] = lastName;
				else
					System.out.println("Invalid: Name should only contain letters.\n");
				break;
			case 5:
				System.out.println("Please enter a valid email address");
				String email = scan.nextLine();
				//Searched online for email regex
				if(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
					data[4] = email;
				else
					System.out.println("Invalid Email Format.\n");
				break;
			case 6:
				System.out.println("Please enter an initial deposit [minimum $" + moneyToString(minInitialAmount) + "]");
				String moneyLine = scan.nextLine();
				double money = 0;
				try{
					money = Double.parseDouble(moneyLine);
				}
				catch(NumberFormatException e){
					System.out.println("Invalid entry. Please enter full dollar amounts without commas");
					break;
				}
				if(money < 500)
				{
					System.out.println("Initial deposit must be greater than $" + moneyToString(minInitialAmount));
				}
				else if (money > maxAmount)
				{
					System.out.println("Initial deposit exceeds account capacity");
				}
				else
				{
					data[5] = moneyToString(money);
				}
				break;
			case 7:
				if(dataFilled)
				{
					data[5] = data[5].replaceAll("[,]", "");
					service.addNewUser(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
					System.out.println("Succesfully registered new user '" + data[0] + "'");
					finished = true;
					break;
				}
			default:
				System.out.println("Sorry, that's not a valid option. Please select another.");
			}
		}	
	}
	
	static void updateAccountPage()
	{
		
	}
	
	static void userMainPage(User user)
	{
		boolean inMainPage = true;
		boolean validChoice;
		
		System.out.println("MAIN PAGE");
		System.out.println("----------------------------------------------------------");
		System.out.println("Welcome, " + user.getFirstName());
		String oldUser = user.toString();
		
		while(inMainPage)
		{
			System.out.println("----------------------------------------------------------");
			validChoice = false;
			System.out.println("What would you like to do today?\n\n"
					+ "[1] Check Account Balance\n"
					+ "[2] Withdrawal\n"
					+ "[3] Deposit\n"
					+ "[4] Settings\n"
					+ "[5] Log Out");
		
			int op = 0;
			while(!validChoice)
				{
				try {
					op = Integer.parseInt(scan.nextLine());
				}
				catch(NumberFormatException e)
				{
					//e.printStackTrace();
					System.out.println("Invalid input. Please try again\n");
					continue;
				}
				
				validChoice = true;
				
				switch(op)
				{
				case 1:
					System.out.println("Your account currently has $" + moneyToString(user.getCashAmount()) + "\n");
					break;
				case 2:
					System.out.println("How much would you like to withdraw?");
					double amountWithdraw = 0;
					try{
						amountWithdraw = Double.parseDouble(scan.nextLine());
					}
					catch(NumberFormatException e)
					{
						System.out.println("Invalid input. Returning to main menu.");
						break;
					}
					
					if(amountWithdraw > maxWithdrawal)
					{
						System.out.println("Withdrawal exceeds maximum allowable amount.");
					}
					else if (user.getCashAmount() - amountWithdraw < 0)
					{
						System.out.println("Insufficient funds.");
					}
					else
					{
						user.updateCashAmount(-amountWithdraw);
						service.changeUser(oldUser, user.toString());
						oldUser = user.toString();
						System.out.println("Withdrawal successful, "
								+ "Account balance is now $" + moneyToString(user.getCashAmount()));
					}
					break;
				case 3:
					System.out.println("How much would you like to deposit?");
					double amountDeposit = 0;
					try{
						amountDeposit = Double.parseDouble(scan.nextLine());
					}
					catch(NumberFormatException e)
					{
						System.out.println("Invalid input. Returning to main menu.");
						break;
					}
					
					if(amountDeposit > maxDeposit)
					{
						System.out.println("Deposit exceeds maximum allowable amount.");
					}
					else if (amountDeposit + user.getCashAmount() > maxAmount)
					{
						System.out.println("Deposit would exceed the capacity of your account.");
					}
					else
					{
						user.updateCashAmount(amountDeposit);
						service.changeUser(oldUser, user.toString());
						oldUser = user.toString();
						System.out.println("Deposit successful, "
								+ "Account balance is now $" + moneyToString(user.getCashAmount()));
					}
					break;
				case 4:
					updateAccountPage();
					break;
				case 5:
					System.out.println("Successfully logged out");
					inMainPage = false;
					break;
				default:
					System.out.println("Sorry, that's not a valid option. Please select another.");
					validChoice = false;
				}
			}
		}
	}
	
	static String moneyToString(double amount)
	{
		String value;
		
		if(amount >= 1000)
		{
			value = String.format("%06.2f", amount%1000);
		}
		else
		{
			return String.format("%.2f", amount);
		}
		
		int dropMoney = (int) amount;
		
		while(dropMoney >= 1000)
		{
			dropMoney = dropMoney / 1000;
			if(dropMoney >= 1000)
				value = String.format("%03d", dropMoney%1000) + "," + value;
			else
				value = dropMoney + "," + value;
		}
		return value;
	}
}
