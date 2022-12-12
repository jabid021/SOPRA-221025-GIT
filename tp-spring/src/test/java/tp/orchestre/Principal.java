package tp.orchestre;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		System.out.println("Choisissez votre Musicien ?");
		System.out.println("1 - Pianiste");
		System.out.println("2 - Guitariste");
		
		Scanner clavier = new Scanner(System.in);
		int choix = clavier.nextInt();
		
		IMusicien musicien = null;
		
		if(choix == 1) {
			musicien = context.getBean("pianiste", IMusicien.class);
		} else if(choix == 2) {
			musicien = context.getBean("guitariste", IMusicien.class);
		} else {
			throw new Exception("Choix impossible");
		}
		
		musicien.jouer();

		
		
		context.close();
	}

}
