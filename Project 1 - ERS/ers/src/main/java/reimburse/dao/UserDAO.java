package reimburse.dao;

import java.util.ArrayList;

import reimburse.pojo.User;

public interface UserDAO {
	public ArrayList<User> getAll();
	public User getUser(String username);
	public User getUser(int id);
	public User insertUser(String...inputs);
}
