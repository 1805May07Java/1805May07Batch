package com.ex.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Author;
import com.ex.beans.Book;
import com.ex.beans.Genre;
import com.ex.util.ConnectionUtil;

public class BookRepositoryHibernate implements BookRepository{

	@Override
	public Book save(Book b) {
		try(Session session = ConnectionUtil
				.getSession()){
			Transaction tx = session
					.beginTransaction();
			for(Author a : b.getAuthors()) {
				session.saveOrUpdate(a);
			}
			session.saveOrUpdate(b.getGenreId());
			int id = (Integer) session.save(b);
			tx.commit();
			b.setId(id);
		}
		
		return b;
	}

	/*
	 * CRITERIA API
	 * Criteria is a simplified API for retrieving entities by
	 * composing Criteria objects. It is a convenient approach 
	 * for functionality like search where there is a variable
	 * number of conditions to be placed upon the result set
	 * 
	 * Take a look at jboss docs for the new and "improved" Criteria API
	 * https://docs.jboss.org/hibernate/entitymanager/3.5/reference/en/html/querycriteria.html
	 */
	@Override
	public List<Book> getAll() {
		List<Book> books = null;
		try(Session session = ConnectionUtil.getSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		//	Root<Book> bookRoot = criteria.from(Book.class);
			books = session.createQuery(criteria).getResultList();
		}
		return books;
	}

	/**
	 * ABOUT RETRIEVING DATA 
	 * 
	 * Often, we will see Hibernate apps that use a mix of 
	 * session.get() and session.load(). Both are used to 
	 * retrieve objects from the db, just with different rules
	 * 
	 * session.get() will always hit the db and return an actual
	 * object with its appropriate data, NOT a proxy
	 * if the row isnt found, get() will return null
	 * 
	 * session.load() will ALWAYS return a "proxy" (Hibernate term)
	 * without hitting the db. In Hibernate, a proxy is an object
	 * with the given identifier value and uninitialized properties. 
	 * It looks like a temporary fake object until a method is called
	 * on the object and its data is retrieved. If no row is found, 
	 * it throws an ObjectNotFoundException, SO, only use this
	 * if you are sure that the object exists. 
	 */
	@Override
	public Book getById(int id) {
		Book b = null;
		try(Session session = ConnectionUtil.getSession()){
			b = session.get(Book.class, id);
		}
		return b;
	}

	@Override
	public List<Book> getByGenre(Genre g) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * QUERY API
	 * Queries use the Hibernate Query Language - not to be 
	 * confused with SQL! The main difference is that HQL
	 * uses class and property names instead of table and
	 * column names, respectively
	 */
	@Override
	public List<Book> getByTitleLike(String title) {
		List<Book> books = null;
		try(Session session = ConnectionUtil.getSession()){
			Query query = session.createQuery("from Book where lower(title) like :param");
			query.setParameter("param", title.toLowerCase());
			books = query.getResultList();
		}
		return books;
	}



}
