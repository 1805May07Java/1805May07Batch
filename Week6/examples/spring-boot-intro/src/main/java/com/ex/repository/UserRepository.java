package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameIgnoreCase(String username);
}
