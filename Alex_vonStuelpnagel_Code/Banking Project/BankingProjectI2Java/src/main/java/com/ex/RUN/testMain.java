package com.ex.RUN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.DAO.AccountDAO;
import com.ex.DAO.AccountDAOimp;
import com.ex.DAO.UserDAO;
import com.ex.DAO.UserDAOimp;
import com.ex.POJO.Account;
import com.ex.POJO.User;

public class testMain {

	public static void main( String[] args ) throws IOException {
    	//User loggedOn = null;
    	UserDAO userDAO = new UserDAOimp();
    	//AccountDAO accountDAO = new AccountDAOimp();
    	Scanner scanner = new Scanner(System.in);
    	
    	User user = userDAO.getById(0);
		System.out.println(user.toString());

	}
}
