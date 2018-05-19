
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
//import com.bk.dao;
import org.junit.Test;

import com.bk.pojos.Access;
import com.bk.pojos.Account;
 

public class DAOTest {
  Access a =new Access();
  String user = "werr";
  String password = "12fe";
   
	@Test
	public void verifyLogin() {
	    Access outputAccessObj = a.Login(user, password);
        assertTrue(outputAccessObj.status);
		 
	     
		
	}
	@Test
	public void verifyVarInt() {
		Access outputAccessObj = a.Login(user, password);
		assertTrue(outputAccessObj.getId() != -1);
	    
	    
		
	}
	
	@Test
	public void verifyNewAccount() {
		a.Login(user, password);
		
		Account acc = createAccount();
		 
		//Expect: AccountID 
		assertTrue(acc.getId() != -1);
		
	}
	private Account createAccount() {
		// TODO Auto-generated method stub
		Account acc = new Account();
		return acc;
	}
	public Access Login(String user, String password){
			 
		return a.Login(user,password);
		
	}
	 
 
	 
	

	 

	

}
