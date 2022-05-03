package controller;

public interface GeneralController {

	public boolean logInAdmin(String username, String passwd);
	
	public boolean buyBook(Book book);
	/*
	TODO ESTE METODO EN LA VENTANA DE CARRITO
	public boolean cleanCart();
	*/
}
