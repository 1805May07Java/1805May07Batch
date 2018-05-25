package banking;

import java.util.Scanner;

public class BankingApp {
    static BankingService b_service = new BankingService();
    public static void main(String[] args){
        System.out.println("Welcome to the Bank Application.");
        startApp();
    }
    static void startApp(){
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
    static void newuser(){
        Double newDeposit=0.0;
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
        System.out.print("\nWhat is your initial deposit? ");
        try {
            newDeposit = Double.parseDouble(input.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Bad input. Try again,");
            newuser();
        }
        b_service.newUser(newUserName,newPass,newFname,newLname,newDeposit);

        User validUser = b_service.findByUser(newUserName);
        System.out.println("Sign up successful. Your balance is $" +checkBalance(validUser));
        menu(validUser);

    }
    static void login(){
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
                System.out.println("Incorrect password.");
                login();
            }
        }
        input.close();

    }
    static void logout(User validUser){
        b_service.finalizing(validUser);
        System.out.println("Logged out.");
        System.exit(0);
    }
    static void menu(User validUser){
        Scanner input = new Scanner(System.in);
        System.out.print("\nWhat would you like to do?"
                        + "\n1: Withdraw"
                        + "\n2: Deposit"
                        + "\n3: Check balance"
                        + "\n4: Log Out\n");
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
                System.out.println("Your current balance is $"+checkBalance(validUser));
                menu(validUser);
                break;
            case 4:
                logout(validUser);
                break;
            default:
                System.out.println("Bad input. Try again.");
                menu(validUser);
        }
        input.close();
    }
    static void withdraw(User validUser){
        Scanner input = new Scanner(System.in);
        System.out.print("\nHow much would you like to withdraw? ");
        double withdraw_amount = 0;
        try{
            withdraw_amount = Double.parseDouble(input.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        if(checkBalance(validUser)-withdraw_amount<0)
            System.out.println("Cannot withdraw more than your current balance. ($"+checkBalance(validUser)+")");
        else {
            b_service.withdraw(validUser, withdraw_amount);
            System.out.println("Your current balance is $"+ checkBalance(validUser));
        }
        menu(validUser);
    }
    static void deposit(User validUser){
        Scanner input = new Scanner(System.in);
        System.out.print("\nHow much would you like to deposit? ");
        double deposit_amount = 0;
        try{
            deposit_amount = Double.parseDouble(input.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        b_service.deposit(validUser, deposit_amount);
        System.out.println("Your current balance is $"+checkBalance(validUser));
        menu(validUser);
    }
    static double checkBalance(User validUser){
        return b_service.checkBalance(validUser);
    }
}
