package com.bank.pojos;

public class Account {
    private int accountId;
    private int accountType;
    private double balance;

    public Account() {
        this.balance=0;
    }

//    public Account(int accountId, int accountType, double balance) {
//        this.accountId = accountId;
//        this.accountType = accountType;
//        this.balance = balance;
//    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}
