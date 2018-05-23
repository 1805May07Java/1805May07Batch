package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.PersonDao;
import com.ex.pojos.Person;

public class PersonService {
	
	static PersonDao persondao = new PersonDao();
	
	public Person add(Person obj) {
		return persondao.save(obj);
	}
	
	public List<Person> getAll() {
		return persondao.getAll();
	}
	
	//TODO
	public boolean exists(Person obj) {
		return persondao.isUnique(obj);
	}
	
	//TODO
	public boolean checkPassword(String username, String password) {
		return false;
		
	}
	
	public Person getByUsername(String username) {
		return persondao.getPersonByUsername(username);
	}
}
