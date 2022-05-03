package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenreControllerImplementation implements GenreController {

	private Connection con;
	private PreparedStatement stmt;

	// Sentencias SQL
	final String INSERTgenre = "INSERT INTO genre(codG, nameG) VALUES( ?, ?)";
	final String OBTENERgenre = "SELECT * FROM genre WHERE nameG = ?";
	//final String UPDATEgenre = "UPDATE genre SET nameG = ? WHERE codG = ? AND active = ?";
	
	
	private void openConnection(){
		 try {
		  String url ="jdbc:mysql://localhost:3306/virtualbookshop?serverTimezone=Europe/Madrid&useSSL=false";
		  con =  DriverManager.getConnection(url,"root" ,"abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		 }	
		}

	 //Metodo que nos permite desconectarnos de la base de datos
	 // @throws SQLException en caso de que ocurra algun error
	 private void closeConnection() throws SQLException {
		System.out.println("Conexion Cerrada.");
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		System.out.println("------------------------");
	}
	
	@Override
	public boolean insertGenre(Genre genre) {
		boolean inserted= false;
		// Abrimos la conexión

			// Meto los valores del propietario dentro del stmt:
			try {
				this.openConnection();

				stmt = con.prepareStatement(OBTENERgenre);

				stmt.setString(1, genre.getNameG());
				ResultSet rs = stmt.executeQuery();

				if(rs.next())
				{
					//Error de que el género ya existe, no hay next(), está vacío
					System.out.println("El género ya existe");
					try {
						this.closeConnection();
					} catch (SQLException e) {
						System.out.println("Error en cierre de la BD");
						e.printStackTrace();
					}
				}
				else	
				{	//El género no existe, puedo darlo de alta

					stmt = con.prepareStatement(INSERTgenre);

					stmt.setLong(1, genre.getCodG());
					stmt.setString(2, genre.getNameG());
					stmt.setBoolean(3, genre.isActive()); 

					stmt.executeUpdate();
					inserted = true;
				}
				} catch (SQLException e1) {
					System.out.println("Error en alta SQL");
					e1.printStackTrace();
				} finally {
					try {
						this.closeConnection();
					} catch (SQLException e) {
						System.out.println("Error en cierre de la BD");
						e.printStackTrace();
					}
				}
			
		return inserted;
	}

	
	/*
	@Override
	public boolean modifyGenre(Genre genre) throws SQLException {
		boolean change=false;
		
		try {
			// Abrimos la conexi�n
			this.openConnection();
			
			stmt = con.prepareStatement(OBTENERgenre);

			stmt.setString(1, genre.getNameG());
			ResultSet rs = stmt.executeQuery();

			if(rs.next())
			{

			// Meto los valores del genero dentro del stat:
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(UPDATEgenre);

			stmt.setLong(1, genre.getCodG());
			stmt.setString(2, genre.getNameG());
			stmt.setBoolean(3, genre.isActive()); 

			if (stmt.executeUpdate()==1) 
				change=true;
			}
			else {
				System.out.println("El género no existe");
				try {
					this.closeConnection();
				} catch (SQLException e) {
					System.out.println("Error en cierre de la BD");
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} 
		
		finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		
		return change;
	}
	*/
	/*

	@Override
	public void deleteGenre(String nameG) {	
		Genre genre = searchGenre(nameG);
		if (genre == null)
			System.out.println("No se ha encontrado ningún género con el nombre " + nameG + ".");
		else {
			genre.setActive(false);
			try {
				modifyGenre(genre);
			} catch (SQLException sqle) {
				System.out.println("Ha habido un error.");
			}
		}
	}
	*/

	@Override
	public Genre searchGenre(String nameG) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Genre genre = null;

		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERgenre);

			// Cargamos los par�metros
			stmt.setString(1, nameG);

			rs = stmt.executeQuery();
			
			if (rs.next()) {
				genre = new Genre();
				genre.setCodG(rs.getInt("codG"));
				genre.setNameG(rs.getString("name"));
			} else
				genre = null;
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}

		return genre;
	}

	@Override
	public ArrayList<Genre> listGenres() {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
				ResultSet rs = null;
				Genre genre = null;
				ArrayList <Genre> genres = new ArrayList<>(); 

				// Abrimos la conexi�n
				this.openConnection();
				
				try {
					stmt = con.prepareStatement("SELECT * FROM genre");

					rs = stmt.executeQuery();

					// Leemos de uno en uno los propietarios devueltos en el ResultSet
					while (rs.next()) {
						genre = null;
						genre = new Genre();
						genre.setCodG(rs.getLong("codG"));
						genre.setNameG(rs.getString("nameG"));	
						// Se añaden todos los géneros a la lista.
						genres.add(genre);
					}
				} catch (SQLException e) {
					System.out.println("Error de SQL");
					e.printStackTrace();
				} finally {
					// Cerramos ResultSet
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException ex) {
							System.out.println("Error en cierre del ResultSet");
						}
					}
					try {
						this.closeConnection();
					} catch (SQLException e) {
						System.out.println("Error en el cierre de la BD");
						e.printStackTrace();
					}
				}
				
				if (genres.isEmpty())
					System.out.println("No se ha encontrado ningun género.");
				return genres;
		
	}

}
