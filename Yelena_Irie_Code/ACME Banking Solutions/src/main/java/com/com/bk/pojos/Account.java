package com.bk.pojos;

import com.bk.dao.DAO;
import com.bk.service.Accounts;

public class Account{
     private static int id=-1;
     private static int userid= -1;
     private static double balance=0.0;
     private static String name="";
     private static int typeid=500;
  
	public static int getUserid() {
		return userid;
	}
	public static void setUserid(int userid) {
		Account.userid = userid;
	}
  
	public static double getBalance() {
		return balance;
	}
	public static void setBalance(double s) {
		Account.balance = s;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Account.name = name;
	}
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Account.id = id;
	}
	public static int getTypeid() {
		return typeid;
	}
	public static void setTypeid(int typeid) {
		Account.typeid = typeid;
	}
 
     



	 

 

	 

}
