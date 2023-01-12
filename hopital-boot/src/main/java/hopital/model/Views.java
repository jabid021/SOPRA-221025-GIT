package hopital.model;

public class Views {
	public static class ViewBase {}
	
	public static class ViewConnexion extends ViewBase {}
	
	public static class ViewConnexionDetail extends ViewConnexion{}
	
	public static class ViewInscription extends ViewBase{}
	
	public static class ViewInscriptionWithMedecin extends ViewInscription{}
	
	public static class ViewInscriptionWithSecretaire extends ViewInscription{}
	
	public static class ViewSecretaire extends ViewBase {}
	
	
	
}
