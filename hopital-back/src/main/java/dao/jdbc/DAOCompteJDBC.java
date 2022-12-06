package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import model.Compte;
import model.Medecin;
import model.Secretaire;

public class DAOCompteJDBC implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("Secretaire")) {

					c = new Secretaire(rs.getInt("id"), rs.getString("login"), rs.getString("password"));

				} else if (rs.getString("type_compte").equals("Medecin")) {
					c = new Medecin(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {

		List<Compte> comptes = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Compte c = new Compte(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
				comptes.add(c);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;

	}

	@Override
	public void insert(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			if (c instanceof Medecin) {

				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login, password, type_compte) VALUES (?,?,?)");
				ps.setString(1, c.getMail());
				ps.setString(2, c.getPassword());
				ps.setString(3, "Medecin");

				ps.executeUpdate();

				ps.close();
			} else if (c instanceof Secretaire) {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login, password, type_compte) VALUES (?,?,?)");
				ps.setString(1, c.getMail());
				ps.setString(2, c.getPassword());
				ps.setString(3, "Secretaire");

				ps.executeUpdate();

				ps.close();
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE compte SET login=?, password=?");
			ps.setString(1, c.getMail());
			ps.setString(2, c.getPassword());

			ps.executeUpdate();

			ps.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Compte seConnecter(String login, String password) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("Medecin")) {
					c = new Medecin(rs.getInt("id"), rs.getString("login"), rs.getString("password"));

				} else if (rs.getString("type_compte").equals("Secretaire")) {
					c = new Secretaire(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
