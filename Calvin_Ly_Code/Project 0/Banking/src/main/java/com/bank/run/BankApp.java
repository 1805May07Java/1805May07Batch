package com.bank.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.BankingService;

public class BankApp {
    private static BankingService b_service = new BankingService();
    public static void main(String[] args){
        System.out.println("Welcome to the Bank Application.");
        startApp();
    }
    private static void startApp(){
        System.out.println("What would you like to do?"
                +"\n1: Log In"
                +"\n2: Sign Up");
        Scanner input = new Scanner(System.in);
        int entered=0;
        try {
            //checking if input is a number.
            entered = Integer.parseInt(input.nextLine());
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
            System.out.println("Bad input. Try again.");
            startApp();
        }
        switch(entered){
            case 1:login();
                break;
            case 2:newuser();
                break;
            default:
                System.out.println("Bad input. Try again.");
                startApp();
        }
        input.close();
    }
    private static void newuser(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter desired username: ");
        String newUserName = input.nextLine();
        if(b_service.checkUserExists(newUserName)){
            System.out.println("Sorry, that username already exists.");
            newuser();
        }
        System.out.print("\nPlease enter desired password: ");
        String newPass = input.nextLine();
        System.out.print("\nPlease enter your first name: ");
        String newFname = input.nextLine();
        System.out.print("\nPlease enter your last name: ");
        String newLname = input.nextLine();
        System.out.print("\nPlease enter your street address: ");
        String newAddress = input.nextLine();
        System.out.print("\nPlease enter your city: ");
        String newCity = input.nextLine();
        System.out.print("\nPlease enter your state: ");
        String newState = input.nextLine();
        System.out.print("\nPlease enter your country of residence: ");
        String newCountry = input.nextLine();
        System.out.print("\nPlease enter your phone number (xxx-xxx-xxxx): ");
        String newPhone = input.nextLine();
        System.out.print("\nPlease enter your email address: ");
        String newEmail = input.nextLine();

        b_service.newUser(newFname, newLname, newAddress, newCity, newState, newCountry, newPhone,newEmail, newUserName, newPass);

        User validUser = b_service.findByUser(newUserName);
        System.out.println("Sign up successful.");
        menu(validUser);

    }
    private static void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter username: ");
        String username = input.nextLine();
        if(!b_service.checkUserExists(username)){
            System.out.println("Entered username does not exist.");
            login();
        }
        else{
            User validUser = b_service.findByUser(username);
            System.out.print("\nPlease enter password: ");
            String password = input.nextLine();
            if(validUser.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome.");
                menu(validUser);
            }
            else{
                System.out.println("Incorrect password. ");
                login();
            }
        }
        input.close();

    }
    private static void logout(){
        System.out.println("Logged out.");
        System.exit(0);
    }
    private static void menu(User validUser){
        Scanner input = new Scanner(System.in);
        System.out.print("\nWhat would you like to do?"
                + "\n1: Withdraw"
                + "\n2: Deposit"
                + "\n3: Check balance"
                + "\n4: Create new account"
                + "\n5: Log out\n");
        int in = 0;
        try{
            //checking if input is a number
            in = Integer.parseInt(input.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Bad input. Try again.");
            menu(validUser);
        }

        switch (in) {
            case 1:
                withdraw(validUser);
                menu(validUser);
                break;
            case 2:
                deposit(validUser);
                menu(validUser);
                break;
            case 3:
                checkingBalance(validUser);
                menu(validUser);
                break;
            case 4:
                newAccount(validUser);
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Bad input. Try again.");
                menu(validUser);
        }
        input.close();
    }
    private static void withdraw(User validUser){
        ArrayList<Account> accounts = getAccounts(validUser);
        Account withdrawAccount = null, checkingAccount = null, savingsAccount = null, creditAccount = null;
        boolean checkingBool = false, savingsBool = false, creditBool = false;
        Scanner input = new Scanner(System.in);
        if(!accounts.isEmpty()) {
            for (Account account : accounts) {
                if (account.getAccountType() == 1) {
                    checkingAccount = account;
                    checkingBool = true;
                }
                else if (account.getAccountType() == 2) {
                    savingsAccount = account;
                    savingsBool = true;
                }
                else if (account.getAccountType() == 3) {
                    creditAccount = account;
                    creditBool = true;
                }
                else
                    System.out.println("something wrong");
            }
            int entered = 0;
            System.out.print("\nWhich account would you like to withdraw from?" +
                    "\n1: Checking" +
                    "\n2: Savings" +
                    "\n3: Credit\n");
            try {
                entered = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Bad input. Try again.");
                withdraw(validUser);
            }
            switch (entered) {
                case 1:
                    if (!checkingBool) {
                        System.out.println("You do not have a checking account.");
                        withdraw(validUser);
                        break;
                    } else
                        withdrawAccount = checkingAccount;
                        break;
                case 2:
                    if (!savingsBool) {
                        System.out.println("You do not have a savings account.");
                        withdraw(validUser);
                        break;
                    } else
                        withdrawAccount = savingsAccount;
                    break;
                case 3:
                    if (!creditBool) {
                        System.out.println("You do not have a credit account.");
                        withdraw(validUser);
                        break;
                    } else
                        withdrawAccount = creditAccount;
                    break;
                default:
                    System.out.println("Bad input. Try again.");
                    menu(validUser);
                    break;
            }
            System.out.print("\nHow much would you like to withdraw? ");
            double withdraw_amount = 0;
            try {
                withdraw_amount = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (b_service.checkBalance(withdrawAccount) - withdraw_amount < 0)
                System.out.println("Cannot withdraw more than your current balance. ($" + b_service.checkBalance(withdrawAccount) + ")");
            else {
                b_service.withdraw(withdrawAccount, withdraw_amount);
                System.out.println("Your current balance is $" + b_service.checkBalance(withdrawAccount));
            }
        }
        else
            System.out.println("You currently do not have any accounts.");
        menu(validUser);
    }
    private static void deposit(User validUser){
        ArrayList<Account> accounts = getAccounts(validUser);
        Account depositAccount = null, checkingAccount = null, savingsAccount = null, creditAccount = null;
        boolean checkingBool = false, savingsBool = false, creditBool = false;
        Scanner input = new Scanner(System.in);
        if(!accounts.isEmpty()) {
            for (Account account : accounts) {
                if (account.getAccountType() == 1) {
                    checkingAccount = account;
                    checkingBool = true;
                }
                if (account.getAccountType() == 2) {
                    savingsAccount = account;
                    savingsBool = true;
                }
                if (account.getAccountType() == 3) {
                    creditAccount = account;
                    creditBool = true;
                }
            }
            int entered = 0;
            System.out.print("\nWhich account would you like to deposit into? "
                        +  "\n1: Checking"
                        +  "\n2: Savings"
                        +  "\n3: Credit\n");
            try {
                entered = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("Bad input. Try again.");
                deposit(validUser);
            }
            switch (entered){
                case 1:
                    if (!checkingBool) {
                        System.out.println("You do not have a checking account.");
                        deposit(validUser);
                        break;
                    } else
                        depositAccount = checkingAccount;
                    break;
                case 2:
                    if (!savingsBool) {
                        System.out.println("You do not have a savings account.");
                        deposit(validUser);
                        break;
                    } else
                        depositAccount = savingsAccount;
                    break;
                case 3:
                    if (!creditBool) {
                        System.out.println("You do not have a credit account.");
                        deposit(validUser);
                        break;
                    } else
                        depositAccount = creditAccount;
                    break;
                default:
                    System.out.println("Bad input. Try again.");
                    menu(validUser);
                    break;
            }
            System.out.print("\nHow much would you like to deposit? ");
            double deposit_amount = 0;
            try {
                deposit_amount = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            b_service.deposit(depositAccount, deposit_amount);
            System.out.println("Your current balance is $" + b_service.checkBalance(depositAccount));
        }
        else
            System.out.println("You currently do not have any accounts.");
        menu(validUser);
    }
    private static void newAccount(User validUser){
        System.out.println("Which account would you like to create? "
                        +   "\n1. Checking"
                        +   "\n2. Savings"
                        +   "\n3. Credit\n");
        Scanner input = new Scanner(System.in);
        int entered=0;
        try{
            entered = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Bad input. Try Again.");
            newAccount(validUser);
        }
        switch (entered){
            case 1:
                Account checking = new Account();
                checking.setAccountType(1);
                b_service.newAccount(checking,validUser);
                System.out.println("Checking account created.");
                menu(validUser);
                break;
            case 2:
                Account savings = new Account();
                savings.setAccountType(2);
                b_service.newAccount(savings,validUser);
                System.out.println("Savings account created.");
                menu(validUser);
                break;
            case 3:
                Account credit = new Account();
                credit.setAccountType(3);
                b_service.newAccount(credit,validUser);
                System.out.println("Credit account created.");
                menu(validUser);
                break;

                default :
                    System.out.println("Bad input. Try again.");
                    menu(validUser);
        }
    }
    private static ArrayList<Account> getAccounts(User validUser){
        ArrayList<Account> accounts = b_service.checkAccounts(validUser);
        if(accounts==null)
            return null;
        else
            return accounts;
    }
    private static void checkingBalance(User validUser){
        ArrayList<Account> accounts = b_service.checkAccounts(validUser);//getAccounts(validUser);
        Account checkingAccount=null, savingsAccount=null, creditAccount=null;
        boolean checkingBool = false, savingsBool = false, creditBool = false;
        if(!accounts.isEmpty()){
            for (Account account : accounts) {
                if (account.getAccountType() == 1) {
                    checkingAccount = account;
                    checkingBool = true;
                }
                else if (account.getAccountType() == 2) {
                    savingsAccount = account;
                    savingsBool = true;
                }
                else if (account.getAccountType() == 3) {
                    creditAccount = account;
                    creditBool = true;
                }
                else
                    System.out.println("something wrong");
            }
            Scanner input = new Scanner(System.in);
            int entered = 0;
            System.out.print("\nWhich account do you want to check? " +
                    "\n1: Checking" +
                    "\n2: Savings" +
                    "\n3: Credit\n");
            try {
                entered = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Bad input. Try again.");
                checkingBalance(validUser);
            }
            switch (entered) {
                case 1:
                    if (!checkingBool) {
                        System.out.println("You do not have a checking account.");
                        menu(validUser);
                        break;
                    } else {
                        System.out.println("Your checking account's balance is: $"+b_service.checkBalance(checkingAccount));
                        break;
                    }
                case 2:
                    if (!savingsBool) {
                        System.out.println("You do not have a savings account.");
                        menu(validUser);
                        break;
                    } else {
                        System.out.println("Your savings account's balance is: $"+b_service.checkBalance(savingsAccount));
                        break;
                    }
                case 3:
                    if (!creditBool) {
                        System.out.println("You do not have a credit account.");
                        menu(validUser);
                        break;
                    } else {
                        System.out.println("Your checking account's balance is: $"+ b_service.checkBalance(creditAccount));
                        break;
                    }
                default:
                    System.out.println("Bad input. Try again.");
                    menu(validUser);
                    break;
            }
        }
        else
            System.out.println("You currently do not have any accounts.");
        menu(validUser);
    }
}