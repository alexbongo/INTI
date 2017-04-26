package fr.adaming.testRH;

import java.util.*;

public class EmployeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employe user1 = new Commercial(20, "Alex");
		 user1.salaire(user1);

		Employe user2 = new Vente(25, "Nour");
		// user2.salaire(25, "Nour");

		Employe user3 = new Manutention(30, "Stephane");
		// user3.salaire(30, "Stephane");

		ArrayList<Employe> TabEmploye = new ArrayList<Employe>();
		TabEmploye.add(user1);
		//TabEmploye.add(user2);
		//TabEmploye.add(user3);
		for (Employe employe : TabEmploye) {
			System.out.println(employe.salaire(new Commercial(20, "Alex")));
			System.out.println(employe.getClass().getName());
		}

	}

}
