package com.bank.dao;

import com.bank.pojos.User;

import java.util.ArrayList;

public interface UserDAO {
    ArrayList<User> readUsers();
    ArrayList<User> getUser(String username);
    void addUser(User newUser);
}
