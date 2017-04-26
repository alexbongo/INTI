package fr.adaming.jour2;

import java.util.*;

public class Tabdyn2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	ArrayList<String>	tab1 = new ArrayList<>();
	ArrayList<String>	tab2 = new ArrayList<>();
	ArrayList<String>	tab3 = new ArrayList<>();
	
	tab1= remplir (5,5);
	tab2= remplir (5,5);
	System.out.println("Table 1 is: "+ tab1);
	System.out.println("Table 2 is: "+ tab2);
	
	tab3= difference(tab1,tab2);
	//System.out.println("Table 1 is: "+ tab1.size());
	//System.out.println("Table 2 is: "+ tab2.size());
	
	System.out.println("Difference between Tables 1 and 2 is: "+ tab3);
			
	}
	
	public static ArrayList<String> remplir(int tailleMot,int nbreMot){
		ArrayList<String> tab= new ArrayList<String>();
		String tabString = "abcdefghijklmnopqrstuvwxyz";
		String motAdd="";
		int x=0;
		while (x<nbreMot) {
		for (int i=0; i<tailleMot; i++){
			
			int valString=(int)(Math.random()*26);//25
			char motAdd2 = tabString.charAt(valString);
			motAdd=motAdd+motAdd2;
		 }
		tab.add(motAdd);
		motAdd="";
		x++;
		}
		return tab;
	}
	
	public static ArrayList<String> difference(ArrayList<String> tab1, ArrayList<String> tab2){
		
		ArrayList<String> tabWork = new ArrayList<>();
		ArrayList<String> tabInt = new ArrayList<>();
		
		tabWork.addAll(tab2);//A F, ZER
		//System.out.println("tab2 diff" +tab2);
		for (String m: tab1 ){
			for (String m2: tab2){
				if (m==m2){
					tabInt.add(m);
				}
			}
		}
		tabWork.removeAll(tabInt);
		//System.out.println("tab2 diff" +tab2);
		return tabWork;
	}
	
	
}
