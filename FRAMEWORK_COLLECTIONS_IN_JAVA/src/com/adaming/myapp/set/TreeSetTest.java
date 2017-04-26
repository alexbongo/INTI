package com.adaming.myapp.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
 
	public static void main(String[] args) {
		//Declaration
	    TreeSet<String> ts=new TreeSet<>();
	    
	    //Adding Item into TreeSet
	    ts.add("C#");
	    ts.add("Java");
	    ts.add("PHP");
	    ts.add("SQL");
	    ts.add("HTML");
	    ts.add("CSS");
	    
	    //Printing TreeSet
	    Iterator <String> itr=ts.iterator();
	    while(itr.hasNext())
	    {
	     System.out.print(itr.next() + " "); 
	    }
	    
	    //Removing Item
	    System.out.println("\nItem Removed : " + ts.remove("SQL"));
	    
	    //Printing
	    System.out.println(ts);
	}
}
