package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Moto;
import model.Taille;
import model.Utilisateur;
import model.Vehicule;
import model.Voiture;

public class DAOVehicule implements IDAO<Vehicule,Integer> {

	@Override
	public Vehicule findById(Integer id) {
		DAOCompte daoC = new DAOCompte();
		Vehicule v=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from vehicule where proprietaire=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();


			while(rs.next()) {


				Utilisateur user = (Utilisateur) daoC.findById(id);

				if(rs.getString("type_vehicule").equals("moto")) 
				{
					v = new Moto(rs.getInt("id"),rs.getString("marque"), rs.getString("plaque"), user, rs.getInt("roues"));
					//constructeur: public Moto(Integer id, String marque, String plaque, Utilisateur utilisateur,int roues) 

				}
				else if(rs.getString("type_vehicule").equals("voiture")) 
				{
					v = new Voiture(rs.getInt("id"), rs.getString("marque"), rs.getString("plaque"), Taille.valueOf(rs.getString("taille")), user, rs.getInt("nb_place"), rs.getBoolean("decapotable"));
					//Constructeur : public Voiture(Integer id, String marque, String plaque,Taille taille, Utilisateur utilisateur,int nbPlace,boolean decapotable) {

				}
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Vehicule v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT into vehicule (marque, plaque, taille, proprietaire, decapotable, nb_place, roues, type_vehicule) VALUES (?,?,?,?,?,?,?,?)");

			ps.setString(1, v.getMarque());
			ps.setString(2, v.getPlaque());
			ps.setString(3, v.getTaille().toString());
			ps.setInt   (4, v.getUtilisateur().getId());

			if(v instanceof Voiture) 
			{
				Voiture maVoiture = (Voiture) v;
				ps.setBoolean(5, maVoiture.isDecapotable());
				ps.setInt(6, maVoiture.getNbPlace());
				ps.setObject(7, null);
				ps.setString(8, "voiture");
			}
			else if(v instanceof Moto) 
			{
				Moto maMoto = (Moto) v;
				ps.setObject(5, null);
				ps.setObject(6, null);
				ps.setInt(7, maMoto.getRoues());
				ps.setString(8, "moto");
			}

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Vehicule v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("UPDATE vehicule set marque=?,plaque=?,taille=?,proprietaire=?,decapotable=?,nb_place=?,roues=?, type_vehicule=? where id=?");
			ps.setString(1,v.getMarque());
			ps.setString(2,v.getPlaque());
			ps.setString(3,v.getTaille().toString());
			ps.setInt(4,v.getUtilisateur().getId());

			if(v instanceof Moto){
				ps.setObject(5,null);
				ps.setObject(6,null);
				ps.setInt(7,((Moto) v).getRoues());
				ps.setString(8,"moto");
			}
			else if(v instanceof Voiture){
				Voiture vv = (Voiture) v;
				ps.setBoolean(5,vv.isDecapotable());
				ps.setInt(6,vv.getNbPlace());
				ps.setObject(7,null);
				ps.setString(8,"voiture");

			}
			ps.setInt(9,v.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public List<Vehicule> findAllByUtilisateur(Integer idUtilisateur) {
		DAOCompte daoC = new DAOCompte();
		
		List<Vehicule> vehicules = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from vehicule where proprietaire=?");
			ps.setInt(1, idUtilisateur);

			ResultSet rs =  ps.executeQuery();


			while(rs.next()) {
				Vehicule v = null;
				Utilisateur user = (Utilisateur) daoC.findById(idUtilisateur);
				if(rs.getString("type_vehicule").equals("moto")) 
				{
					v = new Moto(rs.getInt("id"),rs.getString("marque"), rs.getString("plaque"), user, rs.getInt("roues"));
					//constructeur: public Moto(Integer id, String marque, String plaque, Utilisateur utilisateur,int roues) 
					vehicules.add(v);
				}
				else if(rs.getString("type_vehicule").equals("voiture")) 
				{
					v = new Voiture(rs.getInt("id"), rs.getString("marque"), rs.getString("plaque"), Taille.valueOf(rs.getString("taille")), user, rs.getInt("nb_place"), rs.getBoolean("decapotable"));
					//Constructeur : public Voiture(Integer id, String marque, String plaque,Taille taille, Utilisateur utilisateur,int nbPlace,boolean decapotable) {
					vehicules.add(v);
				}
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicules;
	}


}
