package service;

import java.util.ArrayList;

import dao.ReimbursementDao;
import pojos.Reimbursement;

public class ReimbursementService {
    ReimbursementDao rdao = new ReimbursementDao();

    public ArrayList<Reimbursement> getData(int id, int role) {
        ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
        if(role == 1) {		//Employee Data
            reimbs = rdao.getById(id);
        }
        else {				//Manager Data
            reimbs = rdao.getAll();
        }
        return reimbs;
    }
    public ArrayList<Reimbursement> getByStatus(int status_id){
        return rdao.getByStatus(status_id);
    }
    public void addReimbursement(int id, double amount, String description, int type_id) {
        rdao.addReimbursement(id, amount, description, type_id);
    }
    public void updateReimbursement(int id, int status_id, int resolver_id){
        rdao.updateReimbursement(id, status_id, resolver_id);
    }
    public Reimbursement getByReimbId(int id){
        return rdao.getByReimbId(id);
    }
}