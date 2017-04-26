package fr.adaming.jour2;

import java.util.*;

public class Tabdyn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	ArrayList<Integer>	tab1 = new ArrayList<>();
	ArrayList<Integer>	tab2 = new ArrayList<>();
	ArrayList<Integer>	tab3 = new ArrayList<>();
	
	tab1= remplir(10);
	tab2= remplir (10);
	System.out.println("Table 1 is: "+ tab1.size());
	System.out.println("Table 2 is: "+ tab2.size());
	
	tab3= difference(tab1,tab2);
	System.out.println("Table 1 is: "+ tab1.size());
	System.out.println("Table 2 is: "+ tab2.size());
	
	
	System.out.println("Difference between Tables 1 and 2 is: "+ tab3);
			
	}
	
	public static ArrayList<Integer> remplir(int taille){
		ArrayList<Integer> tab= new ArrayList<Integer>();
		 for (int i=0; i<taille; i++){
			 tab.add((int)(Math.random()*20));
		 }
		return tab;
	}
	
	public static ArrayList<Integer> difference(ArrayList<Integer> tab1, ArrayList<Integer> tab2){
		
		ArrayList<Integer> tabWork = new ArrayList<>();
		ArrayList<Integer> tabInt = new ArrayList<>();
		
		tabWork.addAll(tab2);//A F, ZER
		System.out.println("tab2 diff" +tab2);
		for (int m: tab1 ){
			for (int m2: tab2){
				if (m==m2){
					tabInt.add(m);
				}
			}
		}
		tabWork.removeAll(tabInt);
		System.out.println("tab2 diff" +tab2);
		return tabWork;
	}
	
	
}
