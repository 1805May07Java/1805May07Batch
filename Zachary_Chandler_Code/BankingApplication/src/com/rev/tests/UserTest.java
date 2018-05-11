package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.service.User;

class UserTest {

	@Test
	void testWithdrawNegative() {
		User u = User.getUser("zachac96@gmail.com", "pass");
		assertThrows(IllegalArgumentException.class, () -> u.withdraw(-2000));
	}

	@Test
	void testWithdrawPositive() {
		User u = User.getUser("zachac96@gmail.com", "pass");
		u.deposit(2000);
		u.withdraw(1000);
		assertEquals(u.getBalance(), 1000);
		u.withdraw(1000);
	}
	
	@Test
	void testWithdrawOverdraw() {
		User u = User.getUser("zachac96@gmail.com", "pass");
		assertThrows(IllegalArgumentException.class, () -> u.withdraw(2000));
	}

	@Test
	void testDepositPostive() {
		User u = User.getUser("zachac96@gmail.com", "pass");
		u.deposit(2000);
		assertEquals(u.getBalance(), 2000);
		u.withdraw(2000);
	}

	@Test
	void testDepositNegative() {
		User u = User.getUser("zachac96@gmail.com", "pass");
		assertThrows(IllegalArgumentException.class, () -> u.deposit(-2000));
	}

	@Test
	void testCreateUserExisting() {
		assertThrows(IllegalArgumentException.class, () -> User.createUser(
				"zachac96@gmail.com", "namae", "namea", "pass2"));
	}

	@Test
	void testGetUserInvalidPassword() {
		assertEquals(User.getUser("zachac96@gmail.com", "pass2"), null);
	}
	
	@Test
	void testGetUserNonexistence() {
		assertEquals(User.getUser("zachac968@gmail.com", "pass"), null);
	}

}
