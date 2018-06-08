package reimburse.dao;

import java.util.ArrayList;

public interface LookupDAO<T> {
	public ArrayList<T> getAll();
	public String get(int id);
	public int get(String str);
}
