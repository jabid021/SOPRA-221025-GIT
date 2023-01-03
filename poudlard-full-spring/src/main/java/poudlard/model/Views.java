package poudlard.model;

public class Views {
	
	public static class ViewBase {}	

	// COMPETENCES //

	public static class ViewCompetence extends ViewBase{}
	public static class ViewCompetenceWithSorcier extends ViewCompetence{}
	public static class ViewCompetenceWithSort extends ViewCompetence{}
	public static class ViewCompetenceWithAll extends ViewCompetence{}
	
	// SORTS //

	public static class ViewSort extends ViewBase{}

}
