package test;

import java.sql.Timestamp;
import java.util.ArrayList;

import reimburse.dao.ReimbEmployeeDAOImpl;
import reimburse.dao.ReimbManagerDAOImpl;
import reimburse.dao.UserDAOImpl;
import reimburse.pojo.Reimbursement;
import reimburse.pojo.User;

public class App {
	public static void main(String[] args) {
		UserDAOImpl userdao = new UserDAOImpl();
		ArrayList<User> list = userdao.getAll();
//		userdao.insertUser("anothertest", "password", "ye", "gge", "anoth@yahoo.com", "finance manager");
//		
//		for(User u : list) {
//			System.out.println(u);
//		}
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        
//        StatusLookupImpl s = new StatusLookupImpl();
//        TypeLookupImpl t = new TypeLookupImpl();
//        ArrayList<Status> slist = s.getAll();
//        ArrayList<Type> tlist = t.getAll();
//        
//        for(Status status : slist) {
//        	System.out.println(status.getId() + ": " + status.getStatus());
//        }
//        for(Type type : tlist) {
//        	System.out.println(type.getId() + ": "+ type.getType());
//        }
//        System.out.println("------------------------------");
//        System.out.println(s.get(1));
//        System.out.println(t.get(3));
        
        User guy = userdao.getUser(14);
        ReimbEmployeeDAOImpl r = new ReimbEmployeeDAOImpl();
        ReimbManagerDAOImpl rm = new ReimbManagerDAOImpl();

//        r.insertTicket(-500, new Timestamp(System.currentTimeMillis()), "testing new insert", guy, "Food");
        rm.resolveTicket(3, 2, true);
//        ArrayList<Reimbursement> rlist = r.getAllByStatus(guy.getId(), "pending");
//        ArrayList<Reimbursement> rlist = rm.getAllByStatus(guy.getId(), "approved");
        ArrayList<Reimbursement> rlist = rm.getAll(guy.getId());
        for(Reimbursement re : rlist) {
        	System.out.println(re);
        }
        
        System.out.println("END");
	}
}
