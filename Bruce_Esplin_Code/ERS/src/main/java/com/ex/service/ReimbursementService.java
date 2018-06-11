package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;

public class ReimbursementService {
	private static DaoImpl dao = new DaoImpl();

	static ArrayList<Reimbursement> rbs = new ArrayList<Reimbursement>();

	public Reimbursement insertReimbursement(Reimbursement re) {
		
		re.toString();
		return dao.insertReimbursement(re);
	}
	public static Reimbursement getReimbursement(int id) {
		
		return dao.getReimbursement(id);
	}

	public static boolean updateReimbursement(Reimbursement re) {
		return dao.updateReimbursement(re);
	}
	
	public List<Reimbursement> getUserReimbursements(int userId) {
		System.out.println("testservice");
		return dao.getUserReimbursements(userId);
	}

	public ArrayList<Reimbursement> getAllReimbursements() {
		return dao.getAllReimbursements();
	}

	public static List<Reimbursement> getAllSubmitted() {
		return dao.getAllSubmitted();
	}

	public static List<Reimbursement> getAllResolved() {
		return dao.getAllResolved();
	}

	public static List<Reimbursement> getAllSubmittedForU(User usr) {
		return dao.getAllSubmittedForU(usr);
	}

	public static List<Reimbursement> getAllResolvedForU(User usr) {
		return dao.getAllResolvedForU(usr);
	}

	public static boolean insertUser(User usr) {
		return dao.insertUser(usr);
	}

	public static boolean updateUser(User usr) {
		return dao.updateUser(usr);
	}

	public static List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	public User logIn(String username, String password) {

		// stream = sequence of elements from a source that supports aggregate ops
		Optional<User> user = getAllUsers().stream().filter(u -> u.getUsername().equalsIgnoreCase(username))
				.findFirst();
		if (user.isPresent()) {
			if (user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
	}

	public static User getUser(String username, String password) {
		return dao.getUser(username, password);
	}


}
