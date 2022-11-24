package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Parking;
import model.Place;
import model.Taille;

public class DAOPlace implements IDAO<Place,Integer> {

	@Override
	public Place findById(Integer id) {
		DAOParking daoP = new DAOParking();
		Place p=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from place where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Parking parking = daoP.findById(rs.getInt("parking"));
				p = new Place(rs.getInt("id"), parking, Taille.valueOf(rs.getString("taille")) , rs.getInt("emplacement"));
				//places.add(p);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Place> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Place p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);
			//public Place(Integer id,Parking parking, Taille taille, int emplacement)
			PreparedStatement ps = conn.prepareStatement("INSERT into place (emplacement ,taille,parking) VALUES ( ?, ?, ?)");

			ps.setInt(1,p.getEmplacement());
			ps.setString(2, p.getTaille().toString());
			ps.setInt(3, p.getParking().getId());


			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Place p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);
			//public Place(Integer id,Parking parking, Taille taille, int emplacement)
			PreparedStatement ps = conn.prepareStatement("UPDATE place set emplacement=?,taille=?,parking=? where id =?");

			ps.setDouble(1,p.getEmplacement());
			ps.setString(2, p.getTaille().toString());
			ps.setInt(3, p.getParking().getId());
			ps.setInt(4, p.getId());


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

	
	public List<Place>findAllByParking(Integer idParking) {
		DAOParking daoP = new DAOParking();
		List<Place> places = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from place where parking=?");
			ps.setInt(1, idParking);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Parking parking = daoP.findById(rs.getInt("parking"));
				Place p = new Place(rs.getInt("id"), parking, Taille.valueOf(rs.getString("taille")) , rs.getInt("emplacement"));
				places.add(p);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return places;
	}

}
