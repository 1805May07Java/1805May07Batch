
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
	public void verifyNewAccount() {
		p.Login(user, password);
		System.out.println("Input Email:");
		String email=new Scanner(System.in).nextLine();
		Accounts acc = new Accounts(p.Login(user, password));
		User Customer = new User();
		acc.createAccount(p.Login(user, password),Customer,email);
	 
		//Expect: AccountID 
		assertTrue("Missing Account ID",acc.getId() != -1);
		//Expect: CustID
		acc.getAccount(Customer.getAccId());
		int saved = Customer.getAccId();
		assertSame("Account ID Not Linked to Customer  Expected:"+acc.getAccount(saved).getId()+"Actual: "
		           + acc.getAccount(saved).getId(),acc.getAccount(saved).getId(),saved);
		
		
	}
	
	private Accounts createAccount() {
		//Create one or Multiple accounts
		Accounts acc = new Accounts(p.Login(user, password));
		Access outputAccessObj = p.Login(user, password);
		User Customer=new User();
		String email=new Scanner(System.in).nextLine();
		int outputAccountObj = acc.createAccount(outputAccessObj,Customer,email).getAccId();
		return acc;
	}
	public Access Login(String user, String password){
			 
		return p.Login(user,password);
		
	}
	 
 
	 
	

	 

	

}
