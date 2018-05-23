package pojo;

public class User {
	private int id;
	private String username;
	private String password;
	private int default_account;
	private String firstname;
	private String lastname;

	
	public User() {
		super();
	}
	
	public User(int id, String username, String password, int default_account, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.default_account = default_account;
		this.firstname = firstname;
		this.lastname = lastname;
		
	}

	
	public User(String username, String password, int default_account, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.default_account = default_account;
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	
	public User(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDefault_account() {
		return default_account;
	}

	public void setDefault_account(int default_account) {
		this.default_account = default_account;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", default_account="
				+ default_account + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

//	@Override
//	public String toString() {
//		return "User " + id + ": [" + username + "] " + firstname + " " + lastname;
//	}

	

}
