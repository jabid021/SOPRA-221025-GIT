package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TESTJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("quest");
		
		emf.close();
	}

}
