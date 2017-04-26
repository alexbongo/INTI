package fr.adaming.testRH;

public class Manutention extends Employe {


	@Override
	public double salaire(Employe user) {
		// TODO Auto-generated method stub
		thoraire=20;
		double sal= thoraire*user.temps;
		System.out.println("Le salaire de l'employé "+user.idNom+ " est "+sal+ " €");
		return sal;
	}
	public Manutention(double thoraire,String idNom) {
		// TODO Auto-generated constructor stub
		super(thoraire, idNom);
		this.thoraire=thoraire;
		this.idNom=idNom;
	}

}
