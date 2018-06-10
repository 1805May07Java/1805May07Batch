package ers.service;

import java.util.List;

import ers.dao.ReimbursementDAO;
import ers.pojos.Reimbursement;

public class ReimbursementService {
	static ReimbursementDAO rDAO = new ReimbursementDAO();
	
	public List<Reimbursement>getAll() {
		return rDAO.getAll();
	}
	
	public List<Reimbursement> getAllById(int userId) {
		return rDAO.getAllByUser(userId);
	}
	public String getStatus(int id) {
		return rDAO.getStatus(id);
	}
	public void insertRequest(Reimbursement reimb) {
		rDAO.insertRequest(reimb);
	}
	public void modifyStatus(int reimbursementId, int resolverId, int newStatus) {
		rDAO.modifyStatus(reimbursementId, resolverId, newStatus);
	}
}
