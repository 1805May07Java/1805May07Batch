package com.ex.data;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.ex.beans.User;
import com.ex.util.ConnectionUtil;

public class UserRepository implements Repository<User, Integer> {

	@Override
	public List<User> getAll() {
		List<User> users = null;
		try(Session session = ConnectionUtil.getSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			users = session.createQuery(criteria).getResultList();
		}
		return users;
	}

	@Override
	public User findOne(Integer id) {
		User u = null;
		try(Session session = ConnectionUtil.getSession()){
			u = session.get(User.class, id);
		}
		return u;
	}

	@Override
	public User save(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		User u = null;
		try(Session session = ConnectionUtil.getSession()){
			Query query = session.createQuery("from User where lower(username) = :uname");
			query.setParameter("uname", name);
			u = (User) query.getResultList().get(0);
		}
		return u;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub

	}


}
