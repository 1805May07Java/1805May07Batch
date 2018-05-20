
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
//import com.bk.dao;
import org.junit.Test;

import com.bk.pojos.Access;
import com.bk.service.Accounts;
import com.bk.service.Portal; 
 

public class FeatureTest {
  Portal p =new Portal();
  Access a = new Access();
  String user = "werr";
  String password = "12fe";
   
	@Test
	public void verifyLogin() {
		//*Login
	    Access outputAccessObj = p.Login(user, password);
        assertTrue(outputAccessObj.status);
		 
	     
		
	}
	@Test
	public void verifyVarInt() {
		Access outputAccessObj = p.Login(user, password);
		assertTrue(outputAccessObj.getId() != -1);
	    
	    
		
	}
	
	@Test
	public void verifyNewAccount() {
		p.Login(user, password);
		
		Accounts acc = createAccount();
		 
		//Expect: AccountID 
		assertTrue(acc.getId() != -1);
		
	}
	private Accounts createAccount() {
		//Create one or Multiple accounts
		Accounts acc = new Accounts();
		Access outputAccessObj = p.Login(user, password);
		int outputAccountObj = acc.createAccount(outputAccessObj);
		return acc;
	}
	public Access Login(String user, String password){
			 
		return p.Login(user,password);
		
	}
	 
 
	 
	

	 

	

}
