package quest.model;

public class Views {
	public static class ViewBase {}	
	
	public static class ViewStagiaire extends ViewBase {}
	
	public static class ViewStagiaireDetail extends ViewStagiaire {}
	
	public static class ViewFiliere extends ViewBase {}
	
	public static class ViewFiliereWithStagiaires extends ViewFiliere {}
	
}
