package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookControllerImplementation implements BookController{
	
	private Connection con;
	private PreparedStatement stmt;
	//TODO PROCEDURE
	// Sentencias SQL
	final String INSERTbook = "INSERT INTO book(isbn, title, descrip, editorial, publiDate, price, offer, discountRate, stock, codG, codAu) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String OBTENERbookIsbn = "SELECT * FROM book WHERE isbn = ?";
	final String OBTENERbookTitle = "SELECT * FROM book WHERE title LIKE '%?%'";
	final String OBTENERbookAuthor = "SELECT b.* FROM book b, author a WHERE a.nameA LIKE '%?%'  and b.codAu= a.codAu";
	final String OBTENERbookGenre = "SELECT b.* FROM book b, genre g WHERE g.nameG LIKE '%?%' and b.codG=g.codG";
	final String OBTENERbookOffer= "SELECT * FROM book WHERE offer=1";
	final String UPDATEbook = "UPDATE book SET title = ?, descrip = ?, editorial = ?, publiDate = ?, price = ?, offer = ?, discountRate = ?, stock = ?, codG = ?, codAu = ? WHERE isbn = ?";
	
	
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
	 //TODO
	@Override
	public void addBookToCart(Book book) {
			ShoppingCart.addBook(book);
	}

	@Override
	public boolean insertBook(Book book) {
		boolean inserted = false;
		// Abrimos la conexión

					// Meto los valores del propietario dentro del stmt:
					try {
						this.openConnection();

						stmt = con.prepareStatement(OBTENERbookIsbn);

						stmt.setString(1, book.getIsbn());
						ResultSet rs = stmt.executeQuery();

						if(rs.next())
						{
							//Error de que el libro ya existe, no hay next(), está vacío
							System.out.println("El libro ya existe");
							try {
								this.closeConnection();
							} catch (SQLException e) {
								System.out.println("Error en cierre de la BD");
								e.printStackTrace();
							}
						}
						else	
						{	//El libro no existe, puedo darlo de alta

							stmt = con.prepareStatement(INSERTbook);

							stmt.setString(1, book.getIsbn());
							stmt.setString(2, book.getTitle());
							stmt.setString(3, book.getDescrip());
							stmt.setString(4, book.getEditorial());
							stmt.setDate(5, Date.valueOf(book.getPubliDate()));
							stmt.setFloat(6, book.getPrice());
							stmt.setBoolean(7, book.isOffer());
							stmt.setInt(8, book.getDiscountRate());
							stmt.setInt(9, book.getStock());
							stmt.setInt(10, book.getCodG());
							stmt.setString(11, book.getCodAu());

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
	//TODO
	@Override
	public Book checkBoughtBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
				ResultSet rs = null;
				Book book = null;
				
				// Abrimos la conexi�n
				this.openConnection();

				try {
					stmt = con.prepareStatement(OBTENERbookIsbn);

					// Cargamos los par�metros
					stmt.setString(1, isbn);

					rs = stmt.executeQuery();
					
					if (rs.next()) {
						book = new Book();
						book.setIsbn(rs.getString("Isbn"));
						book.setTitle(rs.getString("Title"));
						book.setDescrip(rs.getString("Descrip"));
						book.setEditorial(rs.getString("Editorial"));
						book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
						book.setPrice(rs.getFloat("Price"));
						book.setOffer(rs.getBoolean("Offer"));
						book.setDiscountRate(rs.getInt("DiscountRate"));
						book.setStock(rs.getInt("Stock"));
						book.setCodG(rs.getInt("CodG"));
						book.setCodAu(rs.getString("CodAu"));
					} else
						book = null;
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

				return book;
			}

	@Override
	public Book searchBookByTitle(String title) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Book book = null;
		
		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERbookTitle);

			// Cargamos los par�metros
			stmt.setString(1, title);

			rs = stmt.executeQuery();
			
			if (rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("Isbn"));
				book.setTitle(rs.getString("Title"));
				book.setDescrip(rs.getString("Descrip"));
				book.setEditorial(rs.getString("Editorial"));
				book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
				book.setPrice(rs.getFloat("Price"));
				book.setOffer(rs.getBoolean("Offer"));
				book.setDiscountRate(rs.getInt("DiscountRate"));
				book.setStock(rs.getInt("Stock"));
				book.setCodG(rs.getInt("CodG"));
				book.setCodAu(rs.getString("CodAu"));
			} else
				book = null;
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

		return book;
	}

	@Override
	public Book searchBookByAuthor(String nameA) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Book book = null;
		
		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERbookAuthor);

			// Cargamos los par�metros
			stmt.setString(1, nameA);

			rs = stmt.executeQuery();
			
			if (rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("Isbn"));
				book.setTitle(rs.getString("Title"));
				book.setDescrip(rs.getString("Descrip"));
				book.setEditorial(rs.getString("Editorial"));
				book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
				book.setPrice(rs.getFloat("Price"));
				book.setOffer(rs.getBoolean("Offer"));
				book.setDiscountRate(rs.getInt("DiscountRate"));
				book.setStock(rs.getInt("Stock"));
				book.setCodG(rs.getInt("CodG"));
				book.setCodAu(rs.getString("CodAu"));
			} else
				book = null;
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

		return book;
	}

	@Override
	public Book searchBookByGenre(String nameG) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Book book = null;
		
		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERbookGenre);

			// Cargamos los par�metros
			stmt.setString(1, nameG);

			rs = stmt.executeQuery();
			
			if (rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("Isbn"));
				book.setTitle(rs.getString("Title"));
				book.setDescrip(rs.getString("Descrip"));
				book.setEditorial(rs.getString("Editorial"));
				book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
				book.setPrice(rs.getFloat("Price"));
				book.setOffer(rs.getBoolean("Offer"));
				book.setDiscountRate(rs.getInt("DiscountRate"));
				book.setStock(rs.getInt("Stock"));
				book.setCodG(rs.getInt("CodG"));
				book.setCodAu(rs.getString("CodAu"));
			} else
				book = null;
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

		return book;
	}

	@Override
	public Book searchBookByOffer(boolean offer) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Book book = null;
		
		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERbookOffer);

			// Cargamos los par�metros
			stmt.setBoolean(1, offer);

			rs = stmt.executeQuery();
			
			if (rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("Isbn"));
				book.setTitle(rs.getString("Title"));
				book.setDescrip(rs.getString("Descrip"));
				book.setEditorial(rs.getString("Editorial"));
				book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
				book.setPrice(rs.getFloat("Price"));
				book.setOffer(rs.getBoolean("Offer"));
				book.setDiscountRate(rs.getInt("DiscountRate"));
				book.setStock(rs.getInt("Stock"));
				book.setCodG(rs.getInt("CodG"));
				book.setCodAu(rs.getString("CodAu"));
			} else
				book = null;
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

		return book;
	}

	@Override
	public boolean modifyBook(Book book) {
		boolean change=false;
		
		try {
			// Abrimos la conexi�n
			this.openConnection();
			
			stmt = con.prepareStatement(OBTENERbookIsbn);

			stmt.setString(1, book.getIsbn());
			ResultSet rs = stmt.executeQuery();

			if(rs.next())
			{

			// Meto los valores del libro dentro del stat:
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(UPDATEbook);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getDescrip());
			stmt.setString(3, book.getEditorial());
			stmt.setDate(4, Date.valueOf(book.getPubliDate()));
			stmt.setFloat(5, book.getPrice());
			stmt.setBoolean(6, book.isOffer());
			stmt.setInt(7, book.getDiscountRate());
			stmt.setInt(8, book.getStock());
			stmt.setInt(9, book.getCodG());
			stmt.setString(10, book.getCodAu());
			stmt.setString(11, book.getIsbn());

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

	@Override
	public void deleteBook(String isbn) {
		Book book = searchBookByIsbn(isbn);
		if (book == null) {
			
		}else {
			book.setActive(false);
			try {
				modifyBook(book);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public ArrayList<Book> listBooks() {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Book book = null;
		ArrayList <Book> books = new ArrayList<>(); 

		// Abrimos la conexi�n
		this.openConnection();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM book WHERE active = 1");

			rs = stmt.executeQuery();

			// Leemos de uno en uno los propietarios devueltos en el ResultSet
			while (rs.next()) {
				book = null;
				book = new Book();
				book.setActive(true);
				book.setIsbn(rs.getString("Isbn"));
				book.setTitle(rs.getString("Title"));
				book.setDescrip(rs.getString("Descrip"));
				book.setEditorial(rs.getString("Editorial"));
				book.setPubliDate(rs.getDate("PubliDate").toLocalDate());
				book.setPrice(rs.getFloat("Price"));
				book.setOffer(rs.getBoolean("Offer"));
				book.setDiscountRate(rs.getInt("DiscountRate"));
				book.setStock(rs.getInt("Stock"));
				book.setCodG(rs.getInt("CodG"));
				book.setCodAu(rs.getString("CodAu"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		
		if (books.isEmpty())
			System.out.println("No se ha encontrado ningun libro.");
		return books;

}
	//TODO
	@Override
	public float calculateTotalAmount(float price, int cant) {
		float result = price*cant;
		return result;
		
	}	
}
