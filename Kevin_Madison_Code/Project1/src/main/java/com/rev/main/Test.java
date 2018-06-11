package com.rev.main;


import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Reimbursement;
import com.rev.pojo.User;
import com.rev.service.ReimbursementService;
import com.rev.service.UserService;

public class Test {
	static UserService us = new UserService();
	static ReimbursementService rs = new ReimbursementService();
	
	public static void main(String[] args) {
		System.out.println("Testing... ");
		
		//testAddReimbursement();
		//resolveReimbursement();
		//printAllReimbursementsById(62);
		//printAllReimbursements();
		printAllUsers();
	}

	private static void testAddReimbursement() {
		rs.addReimbursement(120, 2, "testing addReimbursement", 85);		
	}

	private static void resolveReimbursement() {
		Reimbursement temp = new Reimbursement();
		
		System.out.println("before change: " + rs.getById(99));
		System.out.println("changing = "+rs.resolveReimbursement(99, 61, 3));
		System.out.println("after change: " + rs.getById(99));
		
	}

	private static void printAllReimbursementsById(int id) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		reimbList = rs.getAllReimbById(id);
		
		for(Reimbursement r: reimbList) {
			System.out.println(r.toString());
		}
		
	}

	private static void printAllUsers() {
		List<User> userList = new ArrayList<User>();
		userList = us.getAll();
		
		for(User u: userList) {
			System.out.println(u.toString());
		}
		
	}

	private static void printAllReimbursements() {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		reimbList = rs.getAll();
		
		for(Reimbursement r: reimbList) {
			System.out.println(r.toString());
		}
		
	}
}
