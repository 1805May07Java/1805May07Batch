package com.ex.run;

import java.util.ArrayList;

import com.ex.beans.AccountType;
import com.ex.data.AccountRepository;
import com.ex.data.AccountTypeRepository;
import com.ex.data.Repository;
import com.ex.data.UserRepository;

public class App {
	
	public static void main(String[] args) {
		/*
		 * using this method solely to test dao methods
		 * before using them in Servlets. 
		 * this can (and likely should) be done in a junit
		 * test using a testing db like mockito or an h2
		 * DB (in-memory DB -- disappears after app stops 
		 * running) but for now I will do this here. 
		 */
		
		Repository accRepo = new AccountRepository();
		Repository userRepo = new UserRepository();
		Repository typeRepo = new AccountTypeRepository();
		
		ArrayList<AccountType> types = new ArrayList<AccountType>();
		types.add(new AccountType("Credit"));
		types.add(new AccountType("Checking"));
		types.add(new AccountType("Savings"));
		types.add(new AccountType("Other"));
		
		for(AccountType at : types) {
			typeRepo.save(at);
		}
		
		
		
		
	}

}
