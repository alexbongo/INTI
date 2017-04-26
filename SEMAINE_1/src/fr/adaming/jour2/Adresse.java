/**
 * 
 */
package fr.adaming.jour2;

import java.util.*;

public class Adresse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		lancerquiz();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void lancerquiz(){

		String repo=Pose_et_lit("Voulez vous un quizz \"Capitales\" ou \"CP\" ");
		lequiz(repo);
	}
	
	
	
	public static void lequiz(String repo){
		if (repo.equalsIgnoreCase("Capitales")){
			caseCapitale();
		}else if (repo.equalsIgnoreCase("CP")){
			caseCP();
		}else {
			System.out.println("Valeur non valide");
		}
	}
	
	public static void caseCP(){
	Scanner Clavier= new Scanner(System.in);
	int scorecp=Scorequizzcp("Quelle ville à pour code postal ");
	System.out.println("Votre score est de:" +scorecp);
	System.out.println("Souhaitez vous faire le second quizz (oui/non)?");
	String repo2= Clavier.next();
		if (repo2.equalsIgnoreCase("non")){
			System.out.println("Merci d'avoir joué avec nous!");
		}else if (repo2.equalsIgnoreCase("oui")){
			int scorecap=Scorequizzcap("Quel est la capital de ");
			System.out.println("Votre score est de:" +scorecap);
		}else {
			System.out.println("Merci d'avoir joué avec nous!");
		}
	}
	
	public static void Afficher(String [] tab){
		
		int taille=tab.length;
		
		String monout="";
		
		for (int i=0; i<(taille-1); i++){
			monout=monout.concat(tab[i]).concat("+");
		}
		monout=monout.concat(tab[taille]);
		System.out.println(monout);
	}
	
	
	public static void caseCapitale(){
		Scanner Clavier= new Scanner(System.in);
		int scorecap=Scorequizzcap("Quel est la capital de ");
		System.out.println("Votre score est de:" +scorecap);
		System.out.println("Souhaitez vous faire le second quizz (oui/non)?");
		String repo2= Clavier.next();
			if (repo2.equalsIgnoreCase("non")){
				System.out.println("Merci d'avoir joué avec nous!");
			}else if (repo2.equalsIgnoreCase("oui")){
				int scorecp=Scorequizzcp("Quelle ville à pour code postal ");
				System.out.println("Votre score est de:" +scorecp);
			}else {
				System.out.println("Merci d'avoir joué avec nous!");
			}
	}
		
	public static int Scorequizzcap(String quest){
		
		Scanner Clavier= new Scanner(System.in);
		
		
		String [][] Tabquizz= {{"France", "Paris" },{"Belgique","Bruxelle"},{"Cameroun","Yaounde"},{"Canada","Ottawa"},{"Angleterre","Londres"}};
	
		int nbreQuestionv= Tabquizz.length;
		
		System.out.println("Ce quizz comporte "+nbreQuestionv+ " questions, c'est parti!");
		
		ArrayList<Integer> Ordre=desordre(nbreQuestionv);
		
		int score=questionscore( nbreQuestionv, Tabquizz, Ordre, quest);
		
		return score;
		}
	
		public static int Scorequizzcp(String quest){
			
		Scanner Clavier= new Scanner(System.in);
		
		
		String [][] Tabquizz= {{"75", "Paris" },{"31","Toulouse"},{"33","Bordeau"},{"92","Nanterre"},{"64","Bayonne"}};
	
		int nbreQuestionv= Tabquizz.length;
		
		System.out.println("Ce quizz comporte "+nbreQuestionv+ " questions, c'est parti!");
		
		ArrayList<Integer> Ordre=desordre(nbreQuestionv);
		
		int score=questionscore( nbreQuestionv, Tabquizz, Ordre, quest);
		
		return score;
		}
		
		public static ArrayList<Integer> desordre(int nbreQuestionv){
		Integer [] Ordrequizz= new Integer [nbreQuestionv];
		
		for (int i=0; i<nbreQuestionv;i++ ){
			Ordrequizz[i]=i;
		} 
		ArrayList<Integer> Ordre = new ArrayList<Integer>(Arrays.asList(Ordrequizz)); // utiliser Arrays.
		Collections.shuffle(Ordre);
		
		return Ordre;
}
		public static int questionscore(int nbreQuestionv, String [][] Tabquizz,ArrayList<Integer> Ordre, String quest){
			Scanner Clavier= new Scanner(System.in);
			int score=0;
			int nbreessai=1;
			
			for (int i=0; i<nbreQuestionv;i++){
				
				System.out.println( quest + Tabquizz[Ordre.get(i)][0]);
				String reponse= Clavier.next();
				
				if (Tabquizz[Ordre.get(i)][1].equalsIgnoreCase(reponse)){
					score=score+1;
					System.out.println("Bravo");
				}else {
					System.out.println("Mauvaise réponse");
					while (nbreessai<3){
					nbreessai=nbreessai+1;
					System.out.println("Dernier essai,"+ quest + Tabquizz[Ordre.get(i)][0]);
					String reponse2= Clavier.next();
					if (Tabquizz[Ordre.get(i)][1].equalsIgnoreCase(reponse2)){
						score=score+1;
						System.out.println("Bravo, essai concluant");
					}else {
						System.out.println("C'est encore une mauvaise réponse");
					}
					} System.out.println(nbreessai);
				}
			}
			return score;
		}
		
		public static String Pose_et_lit(String question){
			Scanner Clavier= new Scanner(System.in);
			System.out.println(question);
			String reponse= Clavier.next();
			return reponse;
		}
	
	
}
