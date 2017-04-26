package fr.adaming.testRH;

public class Vente extends Employe {


	@Override
	public double salaire(Employe user) {
		// TODO Auto-generated method stub
		thoraire=25;
		double sal= thoraire*temps;
		System.out.println("Le salaire de l'employé "+idNom+ " est "+sal+ " €");
		return sal;
	}
	
	public Vente(double thoraire,String idNom) {
		// TODO Auto-generated constructor stub
		super(thoraire, idNom);
		this.thoraire=thoraire;
		this.idNom=idNom;
	}

}
