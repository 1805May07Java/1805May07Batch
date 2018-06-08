package reimburse.service;

import java.util.ArrayList;

import reimburse.dao.UserDAOImpl;
import reimburse.pojo.Reimbursement;
import reimburse.pojo.User;

public class Service {
	UserDAOImpl userdao = new UserDAOImpl();
	ArrayList<User> userlist = getAll();
	ArrayList<Reimbursement> reimblist;
	
	
	private ArrayList<User> getAll() {
		return userdao.getAll();
	}
	
	/**
	 * 
	 * 
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param role
	 * @return 0 for good, 1 for bad username, 2 for bad email, 3 for bad both
	 */
	public int register(String username, String password, String firstname, String lastname, String email, String role) {
		for(User u : userlist) {
			if(u.getUsername().equals(username) && u.getEmail().equals(email)) {
				return 3;
			}
			else if(u.getEmail().equals(email)) {
				return 2;
			}
			else if(u.getUsername().equals(username)) {
				return 1;
			}
		}
		
		User newguy = userdao.insertUser(username, password, firstname, lastname, email, role);
		userlist.add(newguy);
		return 0;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 0 for good, 1 for bad 
	 */
	public int login(String username, String password) {
		for(User u : userlist) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return 0;
			}			
		}
		return 1;
	}
}
