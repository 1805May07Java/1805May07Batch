package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByCustomerId(int id);
}
