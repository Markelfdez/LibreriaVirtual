package controller;

public class Users {
	private String username;
	private String passwd;
	
	
	
	public Users() {
		super();
	}

	public Users(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", passwd=" + passwd + "]";
	}
	
	
}
