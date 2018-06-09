package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.ReimTypes;
import com.rev.pojos.Reimburse;

public interface ReimburseDAO {
	public ArrayList<Reimburse> getAllReimb();
	public Reimburse addReimb(Reimburse r);
	public void updateReimb(int id, int status, int person);
	public String getType(int typeId);
	public String getStatus(int statusId);
	public Reimburse getReimb(int reimId);
	public ArrayList<ReimTypes> getAllReimbTypes();
	public ArrayList<Reimburse> getAllReimb(int userID);
	public ArrayList<Reimburse> getAprReim();
	public ArrayList<Reimburse> getDenReim();
	public ArrayList<Reimburse> getPendReim();
}
