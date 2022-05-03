package controller;

import java.util.ArrayList;

public interface AuthorController {

	public boolean insertAuthor(Author author);

	public boolean modifyAuthor(Author author);
	
	public void retireAuthor(String nameA);
	
	public Author searchAuthor(String nameA);
	
	public ArrayList<Author> listAuthors();

}
