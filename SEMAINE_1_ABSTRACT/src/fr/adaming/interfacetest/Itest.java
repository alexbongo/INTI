package fr.adaming.interfacetest;

public interface Itest extends ItestA{
	
	//public abstract void afficher();
	// les methodes sont implicitement abstract et public
	void Afficher();
	final int max=0;
	static int age=10;
	
	// pour redefinr une lmethode on doit implemener cette interface
	void Add(int x);

}
