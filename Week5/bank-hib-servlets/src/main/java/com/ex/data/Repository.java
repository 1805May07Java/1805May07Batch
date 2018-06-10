package com.ex.data;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, I extends Serializable> {
	
	List<T> getAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	T findByName(String name);
	void delete (T obj);

}
