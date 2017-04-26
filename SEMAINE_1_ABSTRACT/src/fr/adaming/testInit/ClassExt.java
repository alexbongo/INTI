package fr.adaming.testInit;

public class ClassExt {
	private static int x;
	
	public ClassExt() {
		// TODO Auto-generated constructor stub
		System.out.println("classe externe");
	}
	
	public class ClassInt extends InitialisationTest{
		
		public ClassInt() {
			x=10;
			// TODO Auto-generated constructor stub
			System.out.println("classe interne");
		}
		
	}
}
