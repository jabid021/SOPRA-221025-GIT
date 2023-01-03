package quest.model;

public class Views {
	public static class ViewBase {}	
	
	public static class ViewStagiaire extends ViewBase {}
	
	public static class ViewStagiaireDetail extends ViewStagiaire {}
	
	public static class ViewFiliere extends ViewBase {}
	
	public static class ViewFiliereWithStagiaires extends ViewFiliere {}
	
	public static class ViewFiliereWithMatieres extends ViewFiliere {}
	
	public static class ViewFiliereWithAll extends ViewFiliere {}
	
	public static class ViewMatiere extends ViewBase {}
	
	public static class ViewOrdinateur extends ViewBase {}
	
	public static class ViewOrdinateurWithStagiaire extends ViewOrdinateur {}
	
}
