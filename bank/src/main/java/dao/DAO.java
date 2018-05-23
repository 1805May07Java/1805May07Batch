package dao;

import java.util.ArrayList;

public interface DAO<T> {
	public ArrayList<T> getAll();
//	public T insert(String...inputs);
}
