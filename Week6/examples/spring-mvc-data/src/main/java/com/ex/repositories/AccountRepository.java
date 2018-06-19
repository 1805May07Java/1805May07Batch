package com.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
