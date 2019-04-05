package sopra.formation.model;

public class Views {
	public static class ViewCommon {}
	
	public static class ViewFormation extends ViewCommon {}
	
	public static class ViewFormationWithClient extends ViewFormation {}
	
	public static class ViewSalle extends ViewCommon {}
	
	public static class ViewSalleWithFormation extends ViewSalle {}
	
	public static class ViewPersonne extends ViewCommon {}
}
