package com.ex.pojos;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import oracle.sql.BLOB;

public class Reimbursement {
	
		int ID;
		int status;
		int type;
		double amount;
		int author;
		int resolver;
		String description;
		String submitted;
		String resolved;
		//BLOB receipt;		
		
		
		public Reimbursement(double a, int requester, String d)
		{
			amount = a;
			author = requester;
			description = d;
		}
				
		public Reimbursement() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Reimbursement(int newid, int au, int t, int s, double a, int r, String d, String subDate, String resDate) 
		{
			ID = newid;
			author = au;
			type = t;
			status = s;
			amount = a;
			resolver = r;
			description = d;
			submitted = subDate;
			resolved = resDate;
			
			
		//	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			
//			if(this.submitted != null)
//				subDate = df.format(this.submitted);
//			
//			if(this.resolved != null)
//				resDate = df.format(this.resolved);
		}

		public int getID() 
		{
			return ID;
		}

		public void setID(int newid) 
		{
			ID = newid;
		}

		public int getAuthor() 
		{
			return author;
		}

		public void setAuthor(int au) 
		{
			author = au;
		}

		public int getStatus() 
		{
			return status;
		}

		public void setStatus(int s) 
		{
			status = s;
		}
		
		public double getAmount()
		{
			return amount;
		}
		
		public void setAmount(double a)
		{
			amount = a;
		}

		public int getResolver() 
		{
			return resolver;
		}

		public void setResolver(int r) 
		{
			resolver = r;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public void setDescription(String d)
		{
			description = d;
		}
		
		public String getSubmitted()
		{
			return submitted;
		}
		
		public void setSubmitted(String subDate)
		{
			submitted = subDate;
		}
		
		public String getResolved()
		{
			return resolved;
		}
		
		public void setResolvedDate(String resDate)
		{
			resolved = resDate;
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			resDate = df.format(this.resolved);
		}		 

}
