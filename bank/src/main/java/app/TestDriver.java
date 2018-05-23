package app;

import java.util.ArrayList;

import dao.BankAccountDAO;
import dao.User_BankAccount_DAO;
import pojo.BankAccount;

public class TestDriver {
	public static void main(String[] args) {

//		Service service = new Service();
//		User u = new User("noice", "password", "firstname", "lastname");
//		Service.addNewUser(u, 1);
		
		
//		User u = UserDAO.insertUser(7, "oice", "password", "firstname", "lastname");
//		System.out.println(u);
//		BankAccount b = BankAccountDAO.insertBankAccount(10, 1);
//		System.out.println(b);
		
		ArrayList<BankAccount> list = User_BankAccount_DAO.getAllAccounts("obams"); 
		BankAccount up = list.get(0);
		
		for(BankAccount b : list) {
			System.out.println(b);
		}
		BankAccountDAO.withdraw(up, 40);
		for(BankAccount b : list) {
			System.out.println(b);
		}
		
	}
}
