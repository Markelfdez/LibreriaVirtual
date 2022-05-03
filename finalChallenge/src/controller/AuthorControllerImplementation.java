package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//TODO poner el active en true cuando se inserte
public class AuthorControllerImplementation implements AuthorController {
	private Connection con;
	private PreparedStatement stmt;

	final String INSERTauthor = "INSERT INTO author(codAu, nameA, surname, birthDate,deathDate) VALUES(?, ?, ?, ?, ?)";
	final String OBTENERauthorNameA = "SELECT * FROM book WHERE nameA LIKE '%?%'";
	final String UPDATEauthor = "UPDATE author SET codAu = ?, nameA = ?, surname = ?, birthDate = ?, deathDate = ? WHERE nameA LIKE '%?%'";

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/virtualbookshop?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("There was an error while trying to open the DB");
		}
	}

	private void closeConnection() throws SQLException {
		System.out.println("Connection closed.");
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		System.out.println("------------------------");
	}

	@Override
	public boolean insertAuthor(Author author) {
		boolean inserted = false;
		try {
			this.openConnection();

			stmt = con.prepareStatement(OBTENERauthorNameA);

			stmt.setString(1, author.getNameA());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("The author already exist");
				try {
					this.closeConnection();
				} catch (SQLException e) {
					System.out.println("There was an error while closing the DB");
					e.printStackTrace();
				}
			} else {

				stmt = con.prepareStatement(INSERTauthor);

				stmt.setString(1, author.getCodAu());
				stmt.setString(2, author.getNameA());
				stmt.setString(3, author.getSurname());
				stmt.setDate(4, Date.valueOf(author.getBirthDate()));
				stmt.setDate(5, Date.valueOf(author.getDeathDate()));

				stmt.executeUpdate();
				inserted = true;
			}
		} catch (SQLException e1) {
			System.out.println("There was an error while registering the SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("There was an error while closing the DB");
				e.printStackTrace();
			}
		}

		return inserted;

	}

	@Override
	public boolean modifyAuthor(Author author) {
		boolean change = false;

		try {
			this.openConnection();
			stmt = con.prepareStatement(OBTENERauthorNameA);

			stmt.setString(1, author.getNameA());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				stmt = con.prepareStatement(UPDATEauthor);

				stmt.setString(1, author.getCodAu());
				stmt.setString(2, author.getNameA());
				stmt.setString(3, author.getSurname());
				stmt.setDate(4, Date.valueOf(author.getBirthDate()));
				stmt.setDate(5, Date.valueOf(author.getDeathDate()));

				if (stmt.executeUpdate() == 1) {
					change = true;
				} else {
					System.out.println("The author doesn't exist");
					try {
						this.closeConnection();
					} catch (SQLException e) {
						System.out.println("There was an error while closing the DB");
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e1) {
			System.out.println("There was an error while modifying the SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("There was an error while closing the DB");
				e.printStackTrace();
			}
		}

		return change;
	}

	@Override
	public void retireAuthor(String nameA) {
		
		Author author = searchAuthor(nameA);
		if (author == null) {

		} else {
			author.setActive(false);
			try {
				modifyAuthor(author);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Author searchAuthor(String nameA) {
		ResultSet rs = null;
		Author author = null;
		
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERauthorNameA);
			
			stmt.setString(1, nameA);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				author = new Author();
				author.setCodAu(rs.getString("codAu"));
				author.setNameA(rs.getString("nameA"));
				author.setSurname(rs.getString("surname"));
				author.setBirthDate(rs.getDate("birthDate").toLocalDate());
				author.setDeathDate(rs.getDate("deathDate").toLocalDate());
			} else
				author = null;
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

		return author;
	}

	@Override
	public ArrayList<Author> listAuthors() {
		ResultSet rs = null;
		Author author = null;
		ArrayList<Author> authors = new ArrayList<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement("SELECT * FROM author WHERE active = 1");
			rs = stmt.executeQuery();

			while (rs.next()) {
				author = null;
				author = new Author();
				author.setActive(true);
				author.setCodAu(rs.getString("codAu"));
				author.setNameA(rs.getString("nameA"));
				author.setSurname(rs.getString("surname"));
				author.setBirthDate(rs.getDate("birthDate").toLocalDate());
				author.setDeathDate(rs.getDate("deathDate").toLocalDate());
				authors.add(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("There was an error while closing the DB");
				e.printStackTrace();
			}
		}

		if (authors.isEmpty())
			System.out.println("Author not found");
		return authors;
	}

}
