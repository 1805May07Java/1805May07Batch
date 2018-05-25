package com.ex.service;

import java.util.List;

import com.ex.dao.AuthorDao;
import com.ex.dao.Dao;
import com.ex.pojos.Author;

public class AuthorService {
	
	static Dao<Author, Integer> authordao = new AuthorDao();
	
	public void add(Author a) {
		authordao.save(a);
	}
	
	public List<Author> getAll(){
		return authordao.getAll();
	}

}
