package com.ex.pojos;

public class User {
			
		private int	user_id;
		private String username;
		private String password;
		private String first_name;
		private String last_name;
		private String email;
		private int role_id;
		
		
		public User(int id, String u, String p, String fn, String ln, String e, int rid)
		{
			user_id = id;
			username = u;
			password = p;
			first_name = fn;
			last_name = ln;
			email = e;
			role_id = rid;			
			
		}
		
		public User() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return user_id;
		}
		
		public void setId(int id) {
			user_id = id;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String u) {
			username = u;
		}
		public String getEmail()
		{
			return email;
		}
		
		public void setEmail(String e)
		{
			email = e;
		}
		
		public String getPassword()
		{
			return password;
		}
		
		public void setPassword(String p)
		{
			password= p;
		}
		
		public String getFirst_Name()
		{
			return first_name;
		}
		
		public void setFirst_Name(String fn)
		{
			first_name = fn;
		}
		
		public String getLast_Name()
		{
			return last_name;
		}
		
		public void setLast_Name(String ln)
		{
			last_name = ln;
		}
		
		public int getRoleId() {
			return role_id;
		}
		
		public void setRoleId(int rid) {
			role_id = rid;
		}

	
		
}
		
		
		