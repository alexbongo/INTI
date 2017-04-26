package fr.adaming.test;

public class Cercle extends Forme {

	@Override
	public double aire(double longueur, double largeur) {
		double a=longueur*largeur*Math.PI;// TODO Auto-generated method stub
		return a;
	}
	
	@Override
	protected void afficher(){
		System.out.println("Bonjour");
	}
	
	public Cercle() {
		// TODO Auto-generated constructor stub
		super.afficher();
	}

}
