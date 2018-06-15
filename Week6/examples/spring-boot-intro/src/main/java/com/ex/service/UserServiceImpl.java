package com.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ex.model.User;
import com.ex.repository.UserRepository;

@Service
@Transactional //defines the scope of a DB transaction
public class UserServiceImpl implements UserService	{

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public User addUser(User u) {
		if(u == null) {
			return null;	
		} else if(u.getUsername() == null || u.getPassword() == null){
			return null;
		} 
		return userRepo.save(u);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsernameIgnoreCase(username);
	}

}
