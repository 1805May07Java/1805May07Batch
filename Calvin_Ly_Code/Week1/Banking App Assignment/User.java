package banking;

public class User {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private double balance;

    public User(String username, String password, String fname, String lname) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.balance = 0.00;
    }

    public User(String username, String password, String fname, String lname, double balance) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + fname + "," + lname + "," + balance+"\n";
    }
    public User getUser(){
        return this;
    }
}
