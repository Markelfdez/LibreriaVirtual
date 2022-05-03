package controller;

import controller.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberControllerImplementation implements MemberController {

	private Connection con;
	private PreparedStatement stmt;

	// TODO PROCEDURE
	// Sentencias SQL
	final String SEARCHmember = "SELECT U.* FROM USERS U, MEMBER M WHERE U.USERNAME = ? AND PASSWD = ? AND M.ACTIVE=1 AND M.USERNAME=U.USERNAME ";
	final String addMemberToMember = "INSERT INTO MEMBER (username, name, surname, address, phone, email, accountNumber, preferencesAuthor, preferencesGenre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String addMemberToUsers = "INSERT INTO USERS (username, passwd) VALUES (?, ?)";
	final String UPDATEmember = "UPDATE FROM MEMBER SET name=?, surname=?, address=?, phone=?, email=?, accountNumber=?, preferencesAuthor=?, preferencesGenre=? WHERE USERNAME=?";

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/virtualbookshop?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error when trying to open the Data Base");
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	@Override
	public Member searchMember(String username) {
		ResultSet resultado = null;
		Member member = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SEARCHmember);

			stmt.setString(1, username);
			resultado = stmt.executeQuery();
			if (resultado.next()) {
				member = new Member();
				member.setUsername(resultado.getString("Username"));
				member.setName(resultado.getString("Name"));
				member.setSurname(resultado.getString("Surname"));
				member.setAddress(resultado.getString("Address"));
				member.setPhone(resultado.getInt("Phone"));
				member.setAccountNumber(resultado.getString("AccountNumber"));
				member.setPreferencesAuthor(resultado.getString("PreferencesAuthor"));
				member.setPreferencesGenre(resultado.getString("PreferencesGenre"));
			} else
				member = null;
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			if (resultado != null) {
				try {
					resultado.close();
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

		return member;
	}

	@Override
	public ArrayList<Member> listMember() {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet resultado = null;
		Member member = null;
		ArrayList<Member> members = new ArrayList<>();

		// Abrimos la conexi�n
		this.openConnection();

		try {
			stmt = con.prepareStatement("SELECT * FROM MEMBER WHERE active = 1");

			resultado = stmt.executeQuery();

			// Leemos de uno en uno los propietarios devueltos en el ResultSet
			while (resultado.next()) {
				member = null;
				member = new Member();
				member.setActive(true);
				member.setUsername(resultado.getString("Username"));
				member.setName(resultado.getString("Name"));
				member.setSurname(resultado.getString("Surname"));
				member.setAddress(resultado.getString("Address"));
				member.setPhone(resultado.getInt("Phone"));
				member.setAccountNumber(resultado.getString("AccountNumber"));
				member.setPreferencesAuthor(resultado.getString("PreferencesAuthor"));
				member.setPreferencesGenre(resultado.getString("PreferencesGenre"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (resultado != null) {
				try {
					resultado.close();
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

		if (members.isEmpty())
			System.out.println("No se ha encontrado ningun miembro");
		return members;

	}

	@Override
	public boolean signUp(Member member, Users users) {

		boolean inserted = false;

		try {
			this.openConnection();

			stmt = con.prepareStatement(SEARCHmember);
			stmt.setString(1, member.getUsername());
			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {
				// Error de que el miembro ya existe, no hay next(), está vacío
				System.out.println("El miembro ya existe");
				try {
					this.closeConnection();
				} catch (SQLException e) {
					System.out.println("Error en cierre de la BD");
					e.printStackTrace();
				}
			} else {
				// El libro no existe, puedo darlo de alta

				stmt = con.prepareStatement(addMemberToMember);
				stmt.setString(1, member.getUsername());
				stmt.setString(2, member.getName());
				stmt.setString(3, member.getSurname());
				stmt.setString(4, member.getAddress());
				stmt.setInt(5, member.getPhone());
				stmt.setString(6, member.getEmail());
				stmt.setString(7, member.getAccountNumber());
				stmt.setString(8, member.getPreferencesAuthor());
				stmt.setString(9, member.getPreferencesAuthor());

				stmt.executeUpdate();

				stmt = con.prepareStatement(addMemberToUsers);
				stmt.setString(1, users.getUsername());
				stmt.setString(2, users.getPasswd());

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

	@Override
	public boolean logIn(String username, String passwd) {
		boolean logged = false;
		try {
			this.openConnection();

			stmt = con.prepareStatement(SEARCHmember);
			stmt.setString(1, username);
			stmt.setString(2, passwd);
			ResultSet resultado = stmt.executeQuery();

			if (resultado != null) {
				logged = true;
			}

			closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return logged;
	}

	@Override
	public void deleteMember(String username) {

		Member member = searchMember(username);
		if (member == null) {

		} else {
			member.setActive(false);
			try {
				modifyProfile(member);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public boolean modifyProfile(Member member) {
		boolean change = false;
		
		try {
			// Abrimos la conexi�n
			this.openConnection();

			// Meto los valores del libro dentro del stat:
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(UPDATEmember);

			stmt.setString(1, member.getName());
			stmt.setString(2, member.getSurname());
			stmt.setString(3, member.getAddress());
			stmt.setInt(4, member.getPhone());
			stmt.setString(5, member.getEmail());
			stmt.setString(6, member.getAccountNumber());
			stmt.setString(7, member.getPreferencesAuthor());
			stmt.setString(8, member.getPreferencesGenre());
			stmt.setString(9, member.getUsername());

			if (stmt.executeUpdate()==1) 
				change = true;
			
				System.out.println("El género no existe");
				try {
					this.closeConnection();
				} catch (SQLException e) {
					System.out.println("Error en cierre de la BD");
					e.printStackTrace();
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
}
