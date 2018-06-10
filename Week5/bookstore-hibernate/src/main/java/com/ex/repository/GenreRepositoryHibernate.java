package com.ex.repository;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Genre;
import com.ex.util.ConnectionUtil;

public class GenreRepositoryHibernate implements GenreRepository{

	@Override
	public Genre addGenre(Genre g) {	

		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			int id = (Integer) session.save(g);
			g.setId(id);
			tx.commit();
		}	
		return g;
	}

	@Override
	public List<Genre> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* When updating an entity, we are attempting to bring a detached
	 * object back into the persistent state. This can be done in various ways:
	 * 
	 * session.update() 
	 * 	- A hibernate session can only associate one Entity object for a given 
	 *   db row. This is because the Persistence Context acts as an in-memory 
	 *   cache and only one entity is associated with a given key
	 *  - An entity can be reattached only if there is no other object matching
	 *   the same row already associated with the current session
	 *  - In sum: Use when you are sure the session does not contain an already
	 *   persistent instance with the same identifier
	 *   
	 *   
	 * session.merge()
	 *  - This method copies the detached entity state to a managed entity 
	 *  	instance. If the merging entity has no equivalent in the current 
	 *  	Session, one will be fetched from the database.
	 *  - The detached object instance will continue to remain detached even 
	 *  	after the merge operation
	 *  - In sum: Use this method to merge modification at any time without 
	 *  	consideration of the state of the session
	 */
	@Override
	public Genre updateGenre(Genre g) {
		try(Session session = ConnectionUtil.getSession()){
			Transaction tx = session.beginTransaction();
			session.update(g);
			tx.commit();
		}
		return g;
	}

}
