package fr.adaming.jour1;

import java.util.*;


public class Tableau {
	public static void main(String[] args) {
		
		int [] tab1 ={1,2,50,80,100};
		int [] tab2 = new int [tab1.length];
		
		// remplir
		
		for (int x= 0; x<tab1.length; x++){
			 tab2[x]=tab1[x];
		 }

		System.out.println("Affiche for tab2: "+tab2[0]+" " +tab2[1]+" "+tab2[2]+" "+tab2[3]+" "+tab2[4] );
		 
		 int x=0;
		 while(x<tab1.length){
			 tab2[x]=tab1[x];
			 x++;
		 }
		 System.out.println("Affiche while tab2: "+tab2[0]+" " +tab2[1]+" "+tab2[2]+" "+tab2[3]+" "+tab2[4] );
			
		 
		 x=0;
		 do{
			 tab2[x]=tab1[x];
		 x++;}while(x<tab1.length);
		 System.out.println("Affiche do while tab2: "+tab2[0]+" " +tab2[1]+" "+tab2[2]+" "+tab2[3]+" "+tab2[4] );
			
		 x=0;
		 for(int m:tab1){
			 tab2[x]=m;x++;
		 }
		 System.out.println("Affiche for each tab2: "+tab2[0]+" " +tab2[1]+" "+tab2[2]+" "+tab2[3]+" "+tab2[4] );
			
	}
		

	
	
}


