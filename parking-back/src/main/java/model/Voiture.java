package model;

public class Voiture extends Vehicule {
private boolean decapotable;
private int nbPlace;

public Voiture(String marque, String plaque,Taille taille, Utilisateur utilisateur,int nbPlace,boolean decapotable) {
	super(marque, plaque,taille, utilisateur);
	this.nbPlace = nbPlace;
	this.decapotable=decapotable;


}

public Voiture(Integer id,String marque, String plaque,Taille taille, Utilisateur utilisateur,int nbPlace,boolean decapotable) {
	super(id,marque, plaque,taille, utilisateur);
	this.nbPlace = nbPlace;
	this.decapotable=decapotable;


}

public boolean isDecapotable() {
	return decapotable;
}

public void setDecapotable(boolean decapotable) {
	this.decapotable = decapotable;
}

public int getNbPlace() {
	return nbPlace;
}

public void setNbPlace(int nbPlace) {
	this.nbPlace = nbPlace;
	
}

@Override
public String toString() {
	return "Voiture [id= "+id+" , decapotable=" + decapotable + ", nbPlace=" + nbPlace + ", marque=" + marque + ", plaque=" + plaque
			+ ", carburants=" + carburants + ", taille=" + taille + ", utilisateur=" + utilisateur + "]";
}



}