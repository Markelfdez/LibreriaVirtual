package controller;

public class Member extends Users{
	private String username;
	private String name;
	private String surname;
	private String address;
	private int phone;
	private String email;
	private String accountNumber;
	private String preferencesAuthor;
	private String preferencesGenre;
	private boolean active;
	
	
	
	public Member() {
		super();
	}

	public Member(String username, String name, String surname, String address, int phone, String email,
			String accountNumber, String preferencesAuthor, String preferencesGenre, boolean active) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.accountNumber = accountNumber;
		this.preferencesAuthor = preferencesAuthor;
		this.preferencesGenre = preferencesGenre;
		this.active = active;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getPreferencesAuthor() {
		return preferencesAuthor;
	}
	
	public void setPreferencesAuthor(String preferencesAuthor) {
		this.preferencesAuthor = preferencesAuthor;
	}
	
	public String getPreferencesGenre() {
		return preferencesGenre;
	}
	
	public void setPreferencesGenre(String preferencesGenre) {
		this.preferencesGenre = preferencesGenre;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", accountNumber=" + accountNumber + ", preferencesAuthor="
				+ preferencesAuthor + ", preferencesGenre=" + preferencesGenre + ", active=" + active + "]";
	}
	
	
}
