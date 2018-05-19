package com.bk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.pojos.Access;
import com.bk.pojos.Account;

public interface DataSys {
	//CONSTANT refers to field in the Database
	public int ID=1;
	public int USER=3;
	public int PASSWORD=4;
	//Accounts table Fields
	public int USERID =2; 
	public int BALANCE= 3;
	public int NAME=4;
	public Access getById(int id); 
	public Access getAccessByPass(String usr, String psswrd);
}

