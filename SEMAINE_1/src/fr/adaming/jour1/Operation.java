package fr.adaming.jour1;

import java.util.*;

public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner clavier =new Scanner(System.in); // le in represente le flux d'entrée
		
		System.out.println("Entrer une valeur");
		int x = clavier.nextInt();
		clavier.nextLine(); //espace
		
		System.out.println("Entrer une valeur");
		int y = clavier.nextInt();
		clavier.nextLine(); //espace
		
		System.out.println("Quelle opération souhaitez vous?");
		String calcul = clavier.next();
		
		int z1= x*y;
		int z2=x+y;
		int z3=x/y;
		
		// equalsIgnoreCase permet de lire et tester la valeur et pas l'instance quelle que soit le case
		// l'eg	alité teste l'instance et non la valeur
			// Produit
			if (calcul.equalsIgnoreCase("produit")){ 
				System.out.println("Vous avez demandé : " +calcul);
				System.out.println("Produit: " +z1);
			}
			// Somme
			else if (calcul.equalsIgnoreCase("Somme")){
				System.out.println("Vous avez demandé : " +calcul);
				System.out.println("Somme: "+z2);
			}
			// Division
			else if (calcul.equalsIgnoreCase("Division")){
				System.out.println("Vous avez demandé : " +calcul);
				System.out.println("Division: "+z3);
			}
			// Erreur
			else {
				System.out.println("Vous avez fait erreur");
			}
		
		
		
		
	}

}
