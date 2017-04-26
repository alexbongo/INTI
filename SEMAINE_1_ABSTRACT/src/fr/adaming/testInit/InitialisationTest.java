package fr.adaming.testInit;

import java.util.ArrayList;

public class InitialisationTest {
	
	private int a;
	private static int b=20;
	
	{
		// intialisation non statique
		System.out.println("Nous avons initialisé tout pour vous");
	}
	
	static{
		// ce bloc permet d'initialiser les données
		ArrayList<String> data =getData();
		for (String s: data){
			if (s.contains("G")){
				System.out.println("Ok.. data with G");
			}
		}
		// puis on peut faire des traitements ici avant l'apel au constructeur
	}
	
	public InitialisationTest() {
		System.out.println("la valeur de b est "+b);
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<String> getData(){
		
	ArrayList<String> data = new ArrayList<String>();
	data.add("Google");
	data.add("Windows");
	return data;
	
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public static int getB() {
		return b;
	}
	public static void setB(int b) {
		InitialisationTest.b = b;
	}
	
	
	
	
}
