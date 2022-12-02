package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.Carburant;
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

			PreparedStatement ps = conn.prepareStatement("SELECT * from vehicule where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();


			while(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("SELECT * from carburant where vehicule=?");
				ps2.setInt(1, id);
				ResultSet rs2 =  ps2.executeQuery();
				List<Carburant> carburants = new ArrayList();
				while(rs2.next()) 
				{
					carburants.add(Carburant.valueOf(rs2.getString("type_carburant")));
				}

				Utilisateur user = (Utilisateur) daoC.findById(rs.getInt("proprietaire"));

				if(rs.getString("type_vehicule").equals("moto")) 
				{
					v = new Moto(rs.getInt("id"),rs.getString("marque"), rs.getString("plaque"), user, rs.getInt("roues"));
					v.setCarburants(carburants);
					//constructeur: public Moto(Integer id, String marque, String plaque, Utilisateur utilisateur,int roues) 

				}
				else if(rs.getString("type_vehicule").equals("voiture")) 
				{
					v = new Voiture(rs.getInt("id"), rs.getString("marque"), rs.getString("plaque"), Taille.valueOf(rs.getString("taille")), user, rs.getInt("nb_place"), rs.getBoolean("decapotable"));
					v.setCarburants(carburants);
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

			PreparedStatement ps = conn.prepareStatement("INSERT into vehicule (marque, plaque, taille, proprietaire, decapotable, nb_place, roues, type_vehicule) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

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
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				for(Carburant c : v.getCarburants()) {
					PreparedStatement ps2 = conn.prepareStatement("INSERT into carburant (vehicule,type_carburant) VALUES (?,?)");
					ps2.setInt(1,rs.getInt(1));
					ps2.setString(2,c.toString());
					ps2.executeUpdate();
				}
			}
				
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

			PreparedStatement ps2 = conn.prepareStatement("DELETE from carburant where vehicule=?");
			ps2.setInt(1, v.getId());
			ps2.executeUpdate();
			ps2.close();
			
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
			
			for(Carburant c : v.getCarburants()) {
				PreparedStatement ps3 = conn.prepareStatement("INSERT into carburant (vehicule,type_carburant) VALUES (?,?)");
				ps3.setInt(1,v.getId());
				ps3.setString(2,c.toString());
				ps3.executeUpdate();
				ps3.close();
			}

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);
			
			PreparedStatement ps = conn.prepareStatement("DELETE from carburant where vehicule=?");
			PreparedStatement ps2 = conn.prepareStatement("DELETE from vehicule where id=?");
			
			ps.setInt(1,id);
			ps2.setInt(1,id);
			

			ps.executeUpdate();
			ps2.executeUpdate();
			
			ps.close();
			ps2.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
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
				PreparedStatement ps2 = conn.prepareStatement("SELECT * from carburant where vehicule=?");
				ps2.setInt(1, rs.getInt("id"));
				ResultSet rs2 =  ps2.executeQuery();
				List<Carburant> carburants = new ArrayList();
				while(rs2.next()) 
				{
					carburants.add(Carburant.valueOf(rs2.getString("type_carburant")));
				}


				Utilisateur user = (Utilisateur) daoC.findById(idUtilisateur);
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
				v.setCarburants(carburants);
				vehicules.add(v);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicules;
	}


}
