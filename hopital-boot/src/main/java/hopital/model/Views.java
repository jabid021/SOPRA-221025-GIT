package hopital.model;



public class Views {
	public static class ViewBase {}
	
	public static class ViewMedecin extends ViewBase {}
	
	public static class ViewMedecinDetail extends ViewMedecin {}
	public static class ViewPatient extends ViewBase {}
	public static class ViewVisite extends ViewBase {}
}
