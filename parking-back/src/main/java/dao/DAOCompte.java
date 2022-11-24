package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Civilite;
import model.Compte;
import model.Responsable;
import model.Utilisateur;

public class DAOCompte implements IDAO<Compte,Integer> {

	
	@Override
	public Compte findById(Integer id) {
		Compte compte=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					compte = new Admin(rs.getInt("id"),null,null,rs.getString("nom"),rs.getString("prenom"));
				}
				else if(rs.getString("type_compte").equals("Responsable")) 
				{
					compte = new Responsable(rs.getInt("id"),null,null,rs.getString("nom"),rs.getString("prenom"),rs.getString("entreprise"));
				}
				else if(rs.getString("type_compte").equals("Utilisateur")) 
				{
					compte = new Utilisateur(rs.getInt("id"),null,null,rs.getString("nom"),rs.getString("prenom"),rs.getBoolean("abonnement"),LocalDate.parse(rs.getString("naissance")),rs.getString("mail"),rs.getString("telephone"),Civilite.valueOf(rs.getString("civilite")));
				}

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public List<Compte> findAll() {

		List<Compte> comptes = new ArrayList();
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));
					comptes.add(c);
				}
				else if(rs.getString("type_compte").equals("Responsable")) 
				{
					c = new Responsable(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getString("entreprise"));
					comptes.add(c);
				}
				else if(rs.getString("type_compte").equals("Utilisateur")) 
				{
					c = new Utilisateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getBoolean("abonnement"),LocalDate.parse(rs.getString("naissance")),rs.getString("mail"),rs.getString("telephone"),Civilite.valueOf(rs.getString("civilite")));
					comptes.add(c);
				}

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
	public void insert(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT into compte (login,password,nom,prenom,entreprise,abonnement,naissance,mail,telephone,civilite,type_compte) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getNom());
			ps.setString(4, compte.getPrenom());

			if(compte instanceof Admin) 
			{
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Admin");
			}
			else if(compte instanceof Responsable) 
			{
				ps.setString(5, ((Responsable) compte).getEntreprise());
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Responsable");
			}
			else if(compte instanceof Utilisateur) 
			{
				ps.setString(5, null);
				ps.setBoolean(6, ((Utilisateur) compte).isAbonnement());
				ps.setString(7, ((Utilisateur) compte).getNaissance().toString());
				ps.setString(8, ((Utilisateur) compte).getMail());
				ps.setString(9, ((Utilisateur) compte).getTelephone());
				ps.setString(10, ((Utilisateur) compte).getCivilite().toString());
				ps.setString(11, "Utilisateur");
			}

			ps.executeUpdate();




			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Compte compte ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,nom=?,prenom=?,entreprise=?,abonnement=?,naissance=?,mail=?,telephone=?,civilite=?,type_compte=? where id=?");
			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getNom());
			ps.setString(4, compte.getPrenom());

			if(compte instanceof Admin) 
			{
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Admin");
			}
			else if(compte instanceof Responsable) 
			{
				ps.setString(5, ((Responsable) compte).getEntreprise());
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Responsable");
			}
			else if(compte instanceof Utilisateur) 
			{
				ps.setString(5, null);
				ps.setBoolean(6, ((Utilisateur) compte).isAbonnement());
				ps.setString(7, ((Utilisateur) compte).getNaissance().toString());
				ps.setString(8, ((Utilisateur) compte).getMail());
				ps.setString(9, ((Utilisateur) compte).getTelephone());
				ps.setString(10, ((Utilisateur) compte).getCivilite().toString());
				ps.setString(11, "Utilisateur");
			}

			ps.setInt(12,compte.getId());
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
	
	public Compte seConnecter(String log,String pass) {

		Compte compte=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, log);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					compte = new Admin(rs.getInt("id"),log,pass,rs.getString("nom"),rs.getString("prenom"));
				}
				else if(rs.getString("type_compte").equals("Responsable")) 
				{
					compte = new Responsable(rs.getInt("id"),log,pass,rs.getString("nom"),rs.getString("prenom"),rs.getString("entreprise"));
				}
				else if(rs.getString("type_compte").equals("Utilisateur")) 
				{
					compte = new Utilisateur(rs.getInt("id"),log,pass,rs.getString("nom"),rs.getString("prenom"),rs.getBoolean("abonnement"),LocalDate.parse(rs.getString("naissance")),rs.getString("mail"),rs.getString("telephone"),Civilite.valueOf(rs.getString("civilite")));
				}

			}



			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}


}
