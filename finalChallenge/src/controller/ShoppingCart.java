package controller;

import java.util.ArrayList;

public class ShoppingCart {
	
	
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(ArrayList<Book> books) {
		super();
		this.books = books;
	}

	private static ArrayList<Book> books = new ArrayList<>();

	public ArrayList<Book> getBooks() {
		return books;
	}

	public static void addBook(Book book) {
		books.add(book);
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [books=" + books + "]";
	}
	
	
}
