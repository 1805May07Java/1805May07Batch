
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
//import com.bk.dao;
import org.junit.Test;

import com.bk.dao.DAO;
import com.bk.pojos.Access;
import com.bk.pojos.Account;
import com.bk.pojos.User;
import com.bk.service.Accounts;
import com.bk.service.Portal;
import com.bk.service.Users; 
 

public class FeatureTest {
  Portal p =new Portal();
  Access a = new Access();
  String user = "werr";
  String password = "12fe";
   
	@Test
	public void verifyLogin() {
		//*Login
		Access outputAccessObj =new Access();
		assertFalse("User Status: Should be intialize to False",outputAccessObj.status);
	    Access outputAccessObj1= p.Login(user, password);
        assertTrue("User Status: False",outputAccessObj1.status);
		 
	     
		
	}
	private void outputAccessObj() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void test() throws SQLException 
	{
		DAO d = new DAO();
		d.getNewAccountId();
	}
	@Test
	public void verifyVarInt() {
		
		Access outputAccessObj = p.Login(user, password);
		assertTrue("User Not Logged IN",outputAccessObj.getId() != -1);
	    
	    
		
	}
	@Test
	public void TransDeposit() {
	 
		int accid=100000267;
		
		System.out.println("Please Enter the Deposit Amount:");
		Scanner s = new Scanner(System.in);
	
		double deposit = Math.abs(Double.parseDouble(s.nextLine()));
		
		Accounts acc= new Accounts(p.Login(user,password),accid);
		double oldbalance = acc.getAccount(accid).getBalance();
		acc.Deposit(deposit);
		acc.confirm(acc);
	     double newbalance = acc.getAccount(accid).getBalance();
	 	assertTrue("Balance is not correct",newbalance != oldbalance);   	
	
		
		

	}
	@Test public void TransWithrawal() {
		int accid=100000267;
		System.out.println("Please Enter the Withdrawal Amount:");
		Scanner s = new Scanner(System.in);
	 	double withdraw = -1*Math.abs(Double.parseDouble(s.nextLine()));
		Accounts acc= new Accounts(p.Login(user,password),accid);
		double oldbalance = acc.getAccount(accid).getBalance();
		acc=acc.Deposit(withdraw);
		acc.confirm(acc);
	     double newbalance = acc.getAccount(accid).getBalance();
	 	assertTrue("Balance is not correct",newbalance != oldbalance);
	};
 
	@Test
	public void verifyNewAccount() {
		//* create an account with a unique email and/or username
		p.Login(user, password);
		System.out.println("Input Email:");
		String email=new Scanner(System.in).nextLine();
		Accounts acc = new Accounts(p.Login(user, password));
		User Customer = new User();
		Customer=acc.createAccount(p.Login(user, password),Customer,email,500.00,500);
	 
		//Expect: AccountID 
		assertTrue("Missing Account ID",acc.getId() != -1);
		//Expect: CustID
		acc.getAccount(Customer.getAccId());
		int saved = Customer.getAccId();
		assertTrue("Account ID Not Linked to Customer",acc.getAccount(saved).getId() == Customer.getAccId());
		
		
	}
	
	private Accounts createAccount() {
		//Create one or Multiple accounts
		Accounts acc = new Accounts(p.Login(user, password));
		Access outputAccessObj = p.Login(user, password);
		User Customer=new User();
		String email=new Scanner(System.in).nextLine();
		int outputAccountObj = acc.createAccount(outputAccessObj,Customer,email,500.00,500).getAccId();
		return acc;
	}
	public Access Login(String user, String password){
			 
		return p.Login(user,password);
		
	}
	 
 
	 
	

	 

	

}
