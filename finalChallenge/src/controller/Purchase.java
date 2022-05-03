package controller;

import java.time.LocalDate;

public class Purchase {
	private LocalDate datePurchase;
	private String isbn;
	private int cant;
	private String username;
	
	
	
	public Purchase() {
		super();
	}

	public Purchase(LocalDate datePurchase, String isbn, int cant, String username) {
		super();
		this.datePurchase = datePurchase;
		this.isbn = isbn;
		this.cant = cant;
		this.username = username;
	}

	public LocalDate getDatePurchase() {
		return datePurchase;
	}
	
	public void setDatePurchase(LocalDate datePurchase) {
		this.datePurchase = datePurchase;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getCant() {
		return cant;
	}
	
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Purchase [datePurchase=" + datePurchase + ", isbn=" + isbn + ", cant=" + cant + ", username=" + username
				+ "]";
	}
	
	
	
}
