package com.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Author;
import com.ex.repository.AuthorRepository;

@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public List<Author> getAll() {
		return authorRepo.findAll();
	}

	@Override
	public Author findById(int id) {
		return authorRepo.findOne(id);
	}

	@Override
	public Author findByName(String name) {
		return authorRepo.findByFirstname(name);
	}

}
