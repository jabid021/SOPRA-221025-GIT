package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Adresse;
import model.Parking;
import model.Responsable;

public class DAOParking implements IDAO<Parking,Integer>{

	
	@Override
	public Parking findById(Integer id) {
		DAOCompte daoC = new DAOCompte();
		Parking parking=null;


		List<Parking> parkings = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from parking where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Responsable resp = (Responsable) daoC.findById(rs.getInt("responsable"));
				Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));

				parking = new Parking(rs.getInt("id"),rs.getDouble("prix"),rs.getInt("etage"),rs.getBoolean("handicap"),rs.getString("description"),resp,adresse);

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return parking;

	}

	@Override
	public List<Parking> findAll() {
		DAOCompte daoC = new DAOCompte();
		List<Parking> parkings = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from parking");
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Responsable resp = (Responsable) daoC.findById(rs.getInt("responsable"));
				Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));

				Parking p = new Parking(rs.getInt("id"),rs.getDouble("prix"),rs.getInt("etage"),rs.getBoolean("handicap"),rs.getString("description"),resp,adresse);

				//Parking park = new Parking(resultat.getInt("id"), resultat.getDouble("prix"), resultat.getInt("etage"), resultat.getBoolean("handicap"), resultat.getString("description"), resultat.getInt("numero"), resultat.getString("voie"), resultat.getString("ville"), resultat.getString("cp"), resultat.resp);
				parkings.add(p);

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return parkings;
	}

	@Override
	public void insert(Parking p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO parking (prix,etage,handicap,description,responsable,numero,voie,ville,cp) VALUES (?,?,?,?,?,?,?,?,?)");

			ps.setDouble(1,p.getPrix());
			ps.setInt(2,p.getEtage());
			ps.setBoolean(3,p.isHandicap());
			ps.setString(4,p.getDescription());
			ps.setInt(5,p.getResponsable().getId());
			ps.setString(6,p.getAdresse().getNumero());
			ps.setString(7,p.getAdresse().getVoie());
			ps.setString(8,p.getAdresse().getVille());
			ps.setString(9,p.getAdresse().getCp());
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void update(Parking p) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("UPDATE parking set prix=?,etage=?,handicap=?,description=?,responsable=?,numero=?,voie=?,ville=?,cp=? where id=?");

			ps.setDouble(1,p.getPrix());
			ps.setInt(2,p.getEtage());
			ps.setBoolean(3,p.isHandicap());
			ps.setString(4,p.getDescription());
			ps.setInt(5,p.getResponsable().getId());
			ps.setString(6,p.getAdresse().getNumero());
			ps.setString(7,p.getAdresse().getVoie());
			ps.setString(8,p.getAdresse().getVille());
			ps.setString(9,p.getAdresse().getCp());
			ps.setInt(10,p.getId());
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

	
	public List<Parking> findAllByResponsable(Integer idResponsable)
	{
		DAOCompte daoC = new DAOCompte();
		List<Parking> parkings = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from parking where responsable=?");
			ps.setInt(1, idResponsable);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Responsable resp = (Responsable) daoC.findById(idResponsable);
				Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));

				Parking p = new Parking(rs.getInt("id"),rs.getDouble("prix"),rs.getInt("etage"),rs.getBoolean("handicap"),rs.getString("description"),resp,adresse);

				parkings.add(p);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return parkings;


	}
	

}
