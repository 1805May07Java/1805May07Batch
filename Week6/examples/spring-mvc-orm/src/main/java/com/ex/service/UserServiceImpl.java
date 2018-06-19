package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.User;
import com.ex.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;

	@Override
	public List<User> findAll() {
		return dao.getAll();
	}

	@Override
	public User add(User u) {
//		if(dao.findByUsername(u.getUsername())==null) {
//			return null;
//		}
		return dao.add(u);
	}

}
