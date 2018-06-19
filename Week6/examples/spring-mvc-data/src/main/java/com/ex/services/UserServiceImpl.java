package com.ex.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.models.User;
import com.ex.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User add(User u) {
		return userRepo.save(u);
	}

	@Override
	public User findById(int id) {
		return userRepo.findOne(id);
	}

	@Override
	public User findByUsername(String username) {
		System.out.println("in find by username");
		return userRepo.findByUsernameIgnoreCase(username);
	}

	@Override
	public User update(User u) {
		return null;
	}

}
