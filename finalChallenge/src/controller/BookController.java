package controller;

import java.util.ArrayList;

public interface BookController {
	
	public void addBookToCart(Book book);
	
	public boolean insertBook(Book book);
	
	public Book checkBoughtBooks();
	
	public Book searchBookByIsbn(String isbn);
	
	public Book searchBookByTitle(String title);
	
	public Book searchBookByAuthor(String nameA);
	
	public Book searchBookByGenre(String nameG);

	public Book searchBookByOffer(boolean offer);
	
	public boolean modifyBook(Book book);
	
	public void deleteBook(String isbn);
	
	public ArrayList<Book> listBooks();
	
	public float calculateTotalAmount(float price, int cant);                                         

	
	
}
