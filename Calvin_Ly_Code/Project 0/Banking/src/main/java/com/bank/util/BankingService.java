package com.bank.util;

import com.bank.pojos.User;
import com.bank.pojos.Account;
import com.bank.dao.UserDAOImpl;
import com.bank.dao.AccountDAOImpl;
import java.util.ArrayList;

public class BankingService {
    static UserDAOImpl userdao = new UserDAOImpl();
    static AccountDAOImpl accountdao = new AccountDAOImpl();
    static{
        //testing purposes
        //usersList = new ArrayList<User>();
        //usersList.add(new User("calvin","pw","Calvin", "Ly"));
    }

    public ArrayList<User> getAllUsers(){
        return userdao.readUsers();
    }
    public boolean checkUserExists(String username){
        ArrayList<User> allUsers = userdao.getUser(username);
        if(!allUsers.isEmpty())
            return true;
        else
            return false;
    }
    public User findByUser(String username){
        ArrayList<User> allUsers = getAllUsers();
        return allUsers.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }
    public User newUser(String fname, String lname, String address, String city, String state, String country, String phone, String email, String username, String pw){
        User newUser = new User(username,pw,fname,lname,address,city,state,country,phone,email); //creates new user with the User constructor
        //IODAO implementation
        userdao.addUser(newUser); //calls IODAO class to write newUser to the DB
        return newUser;
    }
    public ArrayList<Account> checkAccounts(User user){
        return accountdao.findAccounts(user);
    }
    public void newAccount(Account account, User user){
        accountdao.newAccount(account, user);
    }
    public void withdraw(Account userAccount, double withdraw){
        userAccount.setBalance(userAccount.getBalance()-withdraw);
        accountdao.updateBalanceProc(userAccount);
    }
    public void deposit(Account userAccount, double deposit){
        userAccount.setBalance(userAccount.getBalance()+deposit);
        accountdao.updateBalanceProc(userAccount);
    }
    public double checkBalance(Account userAccount){
        return accountdao.getBalance(userAccount);
    }
}
