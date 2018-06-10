package ers.service;

import java.util.List;

import ers.dao.TypeDAO;
import ers.pojos.Type;

public class TypeService {
	static TypeDAO tDAO = new TypeDAO();
	
	public List<Type> getAll() {
		return tDAO.getAll();
	}
	
	public String getById(int id) {
		List<Type> types = tDAO.getAll();
		for (Type t : types) {
			if (t.getId() == id) {
				return t.getType();
			}
		}
		return null;
	}
	
	public int getByString(String type) {
		List<Type> types = tDAO.getAll();
		for(Type t: types) {
			if (t.getType().equals(type)) {
				return t.getId();
			}
		}
		return -1;
	}
}
