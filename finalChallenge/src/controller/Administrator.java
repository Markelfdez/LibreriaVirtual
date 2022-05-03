package controller;

public class Administrator extends Users{
	private String username;
	private int yearsWorked;
	
	
	
	public Administrator() {
		super();
	}

	public Administrator(String username, int yearsWorked) {
		super();
		this.username = username;
		this.yearsWorked = yearsWorked;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getYearsWorked() {
		return yearsWorked;
	}
	
	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	@Override
	public String toString() {
		return "Administrator [username=" + username + ", yearsWorked=" + yearsWorked + "]";
	}
	
	
}
