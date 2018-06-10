package ers.service;

import java.util.List;
import java.util.Optional;

import ers.dao.UserDAO;
import ers.pojos.User;

public class UserService {
	static UserDAO uDAO = new UserDAO();
	static List<User> users = uDAO.getAll();

	public List<User> getAll() {
		return uDAO.getAll();
	}
	
	public boolean isUser(String username) {
		return users.stream().
				filter(u -> u.getUsername().equalsIgnoreCase(username)).count() != 0;
	}
	
	public User login(String username, String password) {
		Optional<User> user = users.stream().
				filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst();
		if (user.isPresent()) { //user is found
			User u = user.get();
			if (u.getPassword().equals(password)) { //password must match
				return u;
			}
		}
		return null; //if invalid credentials, return NULL
	}
	public String getNameById(int id) {
		String name = "";
		List<User> users = uDAO.getAll();
		for (User u: users) {
			if(u.getId() == id) {
				name = u.getFirstName() + " " + u.getLastName();
				return name;
			}
		}
		return name;
	}
}
