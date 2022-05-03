package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneralControllerImplementation implements GeneralController{
	

	private Connection con;
	private PreparedStatement stmt;
	
	//TODO PREGUNTAR A CARMEN PORK NO HAY COMILLAS EN LAS ?
	final String searchAdmin= "SELECT u.username, a.username FROM users u, administrator a WHERE u.username=? and u.passwd=? and a.username=u.username";
	final String insertBuyBook= "INSERT into purchase select b.isbn, m.username, curdate(),? from book b, member m";
	final String searchPurchases = "SELECT b.title, p.datePurchase, p.cant FROM purchase p, book b, member m WHERE b.isbn=p.isbn and m.username=p.username";
	
	private void openConnection() {
		try {
			 String url ="jdbc:mysql://localhost:3306/virtualbookshop?serverTimezone=Europe/Madrid&useSSL=false";
			 con = DriverManager.getConnection(url,"root" ,"abcd*1234");
			} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			}
	}
	
	private void closeConnection() throws SQLException{
		if (stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();	
		}
	}

	@Override
	public boolean logInAdmin(String username, String passwd) {
		boolean loged =false;
		try {
			openConnection();
			
			stmt = con.prepareStatement(searchAdmin);
			stmt.setString(1, username);
			stmt.setString(2, passwd);
			ResultSet rs = stmt.executeQuery();
			
			if (rs != null) {
				loged = true;
			}
			
			closeConnection();
				
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		return loged;
	}

	@Override
	public boolean buyBook(Book book) {
		//INSERT into purchase select b.isbn, m.username, curdate(),? from book b, member m
		//SELECT b.title, p.datePurchase, p.cant FROM purchase p, book b, member m WHERE b.isbn=p.isbn and m.username=p.username
		
		//TODO COGER LA CANT DE LOS LIBROS
		boolean bought=false;
		try {
			openConnection();
			stmt = con.prepareStatement(insertBuyBook);
			stmt.setInt(1, 17);
			ResultSet rs = stmt.executeQuery();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bought;
	}


}
