package tp.orchestre;

public class SpringStartup {

	public static void main(String[] args) {
		
		
	}
	
	private static void exempleViaSetter() {
		Guitariste guitariste = new Guitariste(); // application-context.xml - ligne 13 

		Guitare guitare = new Guitare(); // ligne 17
		
		guitariste.setInstrument(guitare); // ligne 14
	}
	
	private static void exempleViaConstructeur() {
		Guitare guitare = new Guitare(); 
		
		Guitariste guitariste = new Guitariste(guitare);  
	}

}
