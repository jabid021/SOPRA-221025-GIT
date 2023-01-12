package hopital.model;


public class Views {

	public static class ViewBase {}
	
	public static class ViewPatient extends ViewBase {}
	
	public static class ViewVisite extends ViewBase {}

	public class ViewVisiteWithPatient extends ViewVisite {}

	public class ViewVisiteWithMedecin extends ViewVisite {}

	public class ViewVisiteWithAll extends ViewVisite {}

	public class ViewMedecin extends ViewBase {}

	public class ViewMedecinWithVisites extends ViewMedecin {}
	public static class ViewCompte extends ViewBase {}
}
