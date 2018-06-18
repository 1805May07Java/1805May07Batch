package com.Banking.dao;

import java.io.Serializable;
import java.util.List;

import com.Banking.pojos.Account;

public interface Dao<T, I extends Serializable> {
	
	List<T> getAll();
	T findOne(I id);
	T save(T obj);
	void update(T obj);
	boolean isUnique(T obj);
	
}
