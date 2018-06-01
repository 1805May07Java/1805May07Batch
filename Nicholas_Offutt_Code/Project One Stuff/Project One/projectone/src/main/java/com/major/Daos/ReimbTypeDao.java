package com.major.Daos;

import java.util.ArrayList;

import com.major.pojos.ReimbType;



public interface ReimbTypeDao 
{
	public ReimbType getType(int id);
	public int getId(String input);
	public ArrayList<ReimbType> getAllTypes();
}
