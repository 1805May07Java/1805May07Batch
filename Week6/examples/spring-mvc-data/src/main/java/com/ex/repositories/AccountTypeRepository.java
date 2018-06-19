package com.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.models.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{

}
