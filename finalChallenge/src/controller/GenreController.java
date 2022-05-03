package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface GenreController {
	
	public boolean insertGenre(Genre genre);
	/*
	public boolean modifyGenre(Genre genre) throws SQLException;
	
	public void deleteGenre(String nameG);
	*/
	public Genre searchGenre(String nameG);
	
	public ArrayList<Genre> listGenres();

}
