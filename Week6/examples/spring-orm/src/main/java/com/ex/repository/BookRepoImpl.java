package com.ex.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.beans.Author;
import com.ex.beans.Book;

@Repository("bookRepository")
@Transactional
public class BookRepoImpl implements BookRepository{

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Book> getAll() {
		return sf.getCurrentSession().createCriteria(Book.class).list();
	}

	@Override
	public Book getById(int id) {
		return (Book) sf.getCurrentSession().get(Book.class, id);
	}

	@Override
	public Book add(Book b) {
		Session session = sf.getCurrentSession();
		for(Author a : b.getAuthors()) {
			session.saveOrUpdate(a);
		}
		session.saveOrUpdate(b.getGenreId());
		int id = (Integer) session.save(b);
		b.setId(id);
		return b;
		
	}

}
