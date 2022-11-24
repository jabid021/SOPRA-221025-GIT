package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Place;
import model.Reservation;
import model.Vehicule;

public class DAOReservation implements IDAO<Reservation,Integer> {

	@Override
	public Reservation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Reservation resa) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO reservation (jour,prix,paye,vehicule,place) VALUES (?,?,?,?,?)");
			ps.setString(1, resa.getJour().toString());
			ps.setDouble(2,resa.getPrix());
			ps.setBoolean(3, resa.isPaye());
			ps.setInt(4, resa.getVehicule().getId());
			ps.setInt(5, resa.getPlace().getId());

			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Reservation o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
	public List<Reservation> findAllByVehicule(Integer id) {

		DAOVehicule daoV = new DAOVehicule();
		DAOPlace daoP = new DAOPlace();
		List<Reservation> reservations = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+port+bdd,login,password);

			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where vehicule=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Vehicule vehicule = daoV.findById(id);
				Place place = daoP.findById(rs.getInt("place"));
				Reservation r = new Reservation(LocalDate.parse(rs.getString("jour")), rs.getBoolean("paye"),place , vehicule);

				reservations.add(r);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reservations;
	}



}
