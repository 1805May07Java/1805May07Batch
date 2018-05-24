package com.ex.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> 
{
	
	List<T> getAll();
	T find(I id);
	T save(T obj);
	T update(T obj);
	boolean isUnique(T obj);
	
}