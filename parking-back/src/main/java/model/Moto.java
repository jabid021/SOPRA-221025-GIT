package model;

public class Moto extends Vehicule{

private int roues;

public Moto(String marque, String plaque, Utilisateur utilisateur,int roues) {
	super(marque, plaque, Taille.Petit, utilisateur);
	this.roues=roues;	

}


public Moto(Integer id,String marque, String plaque, Utilisateur utilisateur,int roues) {
	super(id,marque, plaque, Taille.Petit, utilisateur);
	this.roues=roues;	

}

public int getRoues() {
	return roues;
}

public void setRoues(int roues) {
	this.roues = roues;
}

@Override
public String toString() {
	return "Moto [id= "+id+", roues=" + roues + ", marque=" + marque + ", plaque=" + plaque + ", carburants=" + carburants
			+ ", taille=" + taille + ", utilisateur=" + utilisateur + "]";
}








}
