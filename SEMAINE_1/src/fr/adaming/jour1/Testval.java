package fr.adaming.jour1;

import java.util.*;

public class Testval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner clavier =new Scanner(System.in); // le in represente le flux d'entrée
		
		System.out.println("Entrer une valeur");
		Integer x = clavier.nextInt();
		clavier.nextLine(); //espace
		
		System.out.println("Entrer une valeur");
		Integer y = clavier.nextInt();
		clavier.nextLine(); //espace
		
		System.out.println("Entrez une valeur");
		Integer z = clavier.nextInt();
		clavier.nextLine(); //espace
		
		// on peut aussi faire un readnext
		
		// condition imbriquée
		if (x.equals(y)){
			if (y.equals(z)){
				System.out.println("Vous avez saisi les mêmes valeurs");
			}
		}
		
		// 
		
	}

}
