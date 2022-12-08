package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import context.Singleton;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Medecin;
import model.Patient;
import model.Visite;

public class DAOVisiteJDBC  {

/*	IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
    IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();


	@Override
	public Visite findById(Integer id) {
        Visite v = null;

        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where numero=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
                Patient p = daoPatient.findById(rs.getInt("id_patient"));
                Medecin m = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));

				v = new Visite(rs.getInt("numero"),p, m, rs.getDouble("prix"), rs.getInt("salle"), LocalDate.parse(rs.getString("date_visite")));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public List<Visite> findAll() {
        List<Visite> visites = new ArrayList();

        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite");


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
                Patient p = daoPatient.findById(rs.getInt("id_patient"));
                Medecin m = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));

				Visite v=new Visite(rs.getInt("numero"),p, m, rs.getDouble("prix"), rs.getInt("salle"), LocalDate.parse(rs.getString("date_visite")));	
				visites.add(v);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return visites;
	}

    public List<Visite> findAllByIdPatient(Integer id) {
        List<Visite> visites = new ArrayList();

        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite WHERE id_patient = ?");

            ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
                Patient p = daoPatient.findById(rs.getInt("id_patient"));
                Medecin m = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));

				Visite v=new Visite(rs.getInt("numero"),p, m, rs.getDouble("prix"), rs.getInt("salle"), LocalDate.parse(rs.getString("date_visite")));	
				visites.add(v);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return visites;
	}

	@Override
	public void insert(Visite v) {

        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (id_patient, id_medecin, prix, salle, date_visite) VALUES (?,?,?,?,?)");
			ps.setInt(1,v.getPatient().getId());
            ps.setInt(2,v.getMedecin().getId());
            ps.setDouble(3,v.getPrix());
            ps.setInt(4,v.getSalle());
            ps.setString(5,v.getDateVisite().toString());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

	@Override
	public void update(Visite v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
*/
}
