package fr.adaming.test;

public abstract class Forme {

	protected double longueur;
	protected double largeur;
	
	public abstract double aire(double longueur, double largeur);
		
	protected void afficher(){
		System.out.println("Bonjour");
	}
	
	
	
	
	
}
