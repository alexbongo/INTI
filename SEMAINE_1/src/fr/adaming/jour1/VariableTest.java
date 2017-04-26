/**
 * 
 */
package fr.adaming.jour1;

import java.util.Scanner;
import java.util.*;

/**
 * @author inti0312
 *
 */
public class VariableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// les types primitifs
		int nomVar =10;
		String nomClient ="";
		char x='A';
		double d= 1.5; // toujour utilisé
		float x2=15.55f; // jamais utilisé
		long x3 =15;
		boolean b= true;
		
		// les types objets ce sont en fait des classe qui encapsulent des types primitifs
		// pour faire certains test c'est mieux ce type
		Integer i = 15;
		Double d2 = 15.5D;
		Character c= 'A';
		Float f= 15.6f;
		Long l= 15L;
		Boolean b2= true;
		
		//Operation arythmetique
		
		// +,*,-,/,%(modulo)
		
		int x1=5;
		int y=10;
		int z=x1+y;
		
		System.out.println("z egal" + z);
		
		// casting
		int x31=5;
		int y2=10;
		int z2=x31/y2; 
		// si on veut le reultat il faut definir double ca la onobtient un entier
		double  z3=(double)(x31/y2);
		
		int x32=5;
		String y3= Integer.toString(x32);
		// l'inverse est possible
		String z31="5";
		int z32=Integer.parseInt(z31);
		
		// recuperer une valeur clavier
		Scanner clavier =new Scanner(System.in); // le in represente le flux d'entrée
		// par défaut c'est le clavier
		//pour utiliser une méthode presente dans une autre class on doit importer la class
		
		System.out.println("Entrer une valeur");
		int userValue = clavier.nextInt();
		clavier.nextLine(); //espace
		System.out.println("entre du text svp");
		String uservalue = clavier.next();
		System.out.println("Entrer une valeur");
		int userValue2 = clavier.nextInt();
		System.out.println("value 1: "+userValue);
		System.out.println("value 2: "+userValue);
		
		//attention next line ne fait que lire la fin de la ligne donc si on demande a lire des caratere
		// quand on saisit l'entier il faut demander à revenir à la ligne
		
		// Condtion
		int i2=10;
		if(i2==10){
			
		}else if (x==12){
			
		}
		else{
			
		}
		
		// Constant
		final int MAX =15;
		
		// decrementation
		int r=5;
		r++; //post incrementation o affiche et on incremente ensuite
		++r; //pre incrementation on incremente puis on affiche
		 int x5=1;
		x5 = x5+1;
		 x5 += 1;
		 
		 //Opérateur
		 
		 // if (x==5 || y==10 ) or
		 // if (x==5 && y==10 ) and
		// if !(x==5  ) nor
		 
		 // Tableau
		 
		 // initialisation
		 int [] tab = {1,2,3};
		 int [] tab2 = new int [3];
		 
		/* for (int i= 0; i<tab.length; i++){
			 System.out.println(i);
		 }*/
		 
		 
		 int xw=0;
		 
		 while(x<tab.length){
			 System.out.println(x);
			 x++;
		 }
		 
		 
		 do{
			 System.out.println(x);
		 }while(x<tab.length);
		 
		 for(Integer s:tab){
			 System.out.println(i);
		 }
		 
		 //initialisation du tableau
		 int [] tabinit= null; // il n' y a pas de valeurs le tableau ne pointe vers rien
		 						//Il n'y a aucune reference
		 // il faut eviter d'instaesier un objetdans une boucle
		 
		 // Tableau multidimensionnel
		 int [][] tab4= {{1,2,3},{4,5,6},{10,50,100}};
		 
		 // Tableau dynamique
		 
		 ArrayList<Integer> tab5= new ArrayList<Integer>();
		 tab5= remplir();
		 Collections.shuffle(tab5);
		 for(Integer i1:tab){
			 if (i1==5){
				 
			 }
		 }
		 
	}
	
	public static ArrayList<Integer> remplir(){
		ArrayList<Integer> tab= new ArrayList<Integer>();
		 for (int i=0; i<150; i++){
			 tab.add(i);
		 }
		return tab;
	}
}
