package tp.orchestre;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class Principal {

	@Autowired
	private IMusicien pianiste;

	@Autowired
	private IMusicien guitariste;

	public void run(String[] args) throws Exception {
		System.out.println("Choisissez votre Musicien ?");
		System.out.println("1 - Pianiste");
		System.out.println("2 - Guitariste");

		Scanner clavier = new Scanner(System.in);
		int choix = clavier.nextInt();

		if (choix == 1) {
			pianiste.jouer();
		} else if (choix == 2) {
			guitariste.jouer();
		} else {
			throw new Exception("Choix impossible");
		}

		clavier.close();
	}

}
