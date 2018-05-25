package banking;

import java.util.ArrayList;

public class BankingService {
    static ArrayList<User> usersList = new ArrayList<User>();
    static IODAO dao = new IODAO();
    static{
        //testing purposes
        //usersList = new ArrayList<User>();
        //usersList.add(new User("calvin","pw","Calvin", "Ly"));

    }

    ArrayList<User> getAllUsers(){
        //IODAO implementation
        usersList = dao.readUsers();
        return usersList;
    }
    boolean checkUserExists(String username){
        ArrayList<User> allUsers = getAllUsers();
//        if(allUsers.contains(username))
//            return true;
//        else
//            return false;
        return allUsers.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username));

    }
    User findByUser(String username){
        ArrayList<User> allUsers = getAllUsers();
//        User a=null;
//        for(a : allUsers) {
//            if (a.getUsername().equalsIgnoreCase(username))
//                return a;
//            else
//                return null;
//        }
//        return a;
        return allUsers.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }
    User newUser(String username, String pw, String fname, String lname, Double deposit){
        User newUser = new User(username,pw,fname,lname,deposit); //creates new user with the User constructor
        usersList.add(newUser); //adds new user to the arraylist
        //IODAO implementation
        dao.addUser(newUser); //calls IODAO class to write newUser to the accounts.txt file
        return newUser;
    }

    void withdraw(User validUser, double withdraw){
        validUser.setBalance(validUser.getBalance()-withdraw);
    }
    void deposit(User validUser, double deposit){
        validUser.setBalance(validUser.getBalance()+deposit);
    }
    double checkBalance(User validUser){
        return validUser.getBalance();
    }
    void finalizing(User user){
        dao.overwrite(user);
    }
}
