package com.ex.service;

import java.util.List;

import com.ex.beans.Author;

public interface AuthorService {
	
	List<Author> getAll();
	Author findById(int id);
	Author findByName(String name);

}
