package com.adaming.myapp.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		 //Declaring LinkedHashSet
	    LinkedHashSet<String> hs=new LinkedHashSet<String>();
	    
	    //Adding Item
	    hs.add("C#");
	    hs.add("Java");
	    hs.add("SQL");
	    hs.add("PHP");
	    hs.add("HTML");
	    
	    //Printing LinkedHashSet
	    Iterator <String> itr=hs.iterator();
	    while(itr.hasNext())
	    {
	      System.out.print(itr.next() + " ");
	    }
	    
	    //Removing an Item
	    System.out.println("\nItem Removed : "+ hs.remove("SQL"));
	    
	    //Printing 
	    System.out.println(hs);
	}
}
