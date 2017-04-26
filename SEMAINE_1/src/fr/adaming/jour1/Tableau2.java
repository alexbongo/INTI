package fr.adaming.jour1;

public class Tableau2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] tab= {{1,2,3},{4,5,6},{10,50,100}};
		
		for (int x=0, len=tab.length;x<len;x++){ // on peut déclarer plusieurs variables
			for (int y=0;y<tab.length;y++){
				
					System.out.println(tab[x][y]);
				
			}
			
		}
		
		
		
	}

}
