package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
		
		emf.close();
	}

}
