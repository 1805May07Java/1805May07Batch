package com.ex.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.beans.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	public User add(User u) {
		int i = (Integer) sf.getCurrentSession().save(u);
		u.setId(i);
		return u ;
	}

	@Override
	public List<User> getAll() {
		return sf.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findOne(int id) {
		return (User) sf.getCurrentSession().get(User.class, id);
	}

	@Override
	public User findByUsername(String username) { // fix
		return (User) sf.getCurrentSession().createQuery("from User where lower(username) = :name").setParameter("name", username.toLowerCase()).list().get(0);
	}

}
