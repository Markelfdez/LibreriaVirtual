package controller;

import java.time.LocalDate;

public class Book {
	private String isbn;
	private String title;
	private String descrip;
	private String editorial;
	private LocalDate publiDate;
	private float price;
	private boolean offer;
	private int discountRate;
	private int stock;
	private int codG;
	private String codAu;
	private boolean active;
	
	
	
	public Book() {
		super();
	}

	public Book(String isbn, String title, String descrip, String editorial, LocalDate publiDate, float price,
			boolean offer, int discountRate, int stock, int codG, String codAu, boolean active) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.descrip = descrip;
		this.editorial = editorial;
		this.publiDate = publiDate;
		this.price = price;
		this.offer = offer;
		this.discountRate = discountRate;
		this.stock = stock;
		this.codG = codG;
		this.codAu = codAu;
		this.active = active;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescrip() {
		return descrip;
	}
	
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public LocalDate getPubliDate() {
		return publiDate;
	}
	
	public void setPubliDate(LocalDate publiDate) {
		this.publiDate = publiDate;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean isOffer() {
		return offer;
	}
	
	public void setOffer(boolean offer) {
		this.offer = offer;
	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getCodG() {
		return codG;
	}
	
	public void setCodG(int codG) {
		this.codG = codG;
	}
	
	public String getCodAu() {
		return codAu;
	}
	
	public void setCodAu(String codAu) {
		this.codAu = codAu;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", descrip=" + descrip + ", editorial=" + editorial
				+ ", publiDate=" + publiDate + ", price=" + price + ", offer=" + offer + ", discountRate="
				+ discountRate + ", stock=" + stock + ", codG=" + codG + ", codAu=" + codAu + ", active=" + active
				+ "]";
	}
	
	
	
}
