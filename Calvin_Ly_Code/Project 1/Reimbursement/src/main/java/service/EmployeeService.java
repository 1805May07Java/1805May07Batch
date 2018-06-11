package service;

import dao.UserDao;
import pojos.User;

public class EmployeeService {
    UserDao udao = new UserDao();

    public User validate(String username, String pw) {
        System.out.println("in user service");
        if(udao.validate(username, pw) == 1) {
            return udao.getByUsername(username);
        }
        else return null;
    }

}