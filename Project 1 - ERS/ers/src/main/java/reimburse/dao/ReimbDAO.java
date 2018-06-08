package reimburse.dao;

import java.util.ArrayList;

import reimburse.pojo.Reimbursement;

public interface ReimbDAO {
	public ArrayList<Reimbursement> getAll(int id);
	public ArrayList<Reimbursement> getAllByStatus(int id, String status);
//	public Reimbursement resolveTicket();
}
