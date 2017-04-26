package fr.adaming.testRH;

import java.util.ArrayList;

public abstract class Employe {
	protected double thoraire;
	protected final double temps =150;
	protected String idNom;
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	public Employe(double thoraire, String idNom) {
		this.thoraire = thoraire;
		this.idNom = idNom;
	}
	
	//public abstract void nom(Employe user);

	public abstract double salaire(Employe user);
	//public abstract double salaire(double thoraire, String idNom);

	@Override
	public String toString() {
		return "Employe [thoraire=" + thoraire + ", temps=" + temps
				+ ", idNom=" + idNom + "]";
	}
	
	
}
