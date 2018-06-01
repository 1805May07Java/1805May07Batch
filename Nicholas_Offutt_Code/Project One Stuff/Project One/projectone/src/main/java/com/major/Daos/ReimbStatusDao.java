package com.major.Daos;

import java.util.ArrayList;

import com.major.pojos.ReimbStatus;

public interface ReimbStatusDao 
{
	public ReimbStatus getStatus(int id);
	public int getId(String input);
	public ArrayList<ReimbStatus> getAllStatuses();
}
