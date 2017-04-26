package fr.adaming.testRH;

public class Commercial extends Employe {

	protected double thoraire;
	protected String idNom;

	@Override
	public double salaire(Employe user) {
		// TODO Auto-generated method stub
		thoraire=20;
		double sal= thoraire*user.temps;
		System.out.println("Le salaire de l'employé "+user.idNom+ " est "+sal+ " €");
		return sal;
	}

	public Commercial(double thoraire,String idNom) {
		// TODO Auto-generated constructor stub
		super(thoraire, idNom);
		this.thoraire=thoraire;
		this.idNom=idNom;
	}
	
	
	
}
