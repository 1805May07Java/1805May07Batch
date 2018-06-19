package com.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsernameIgnoreCase(String name);
	
}
