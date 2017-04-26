package com.adaming.myapp.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> h=new HashSet<String>();
	    
	    //Adding items in Hash Table
	    h.add("PHP");
	    h.add("Java");
	    h.add("HTML");
	    h.add("SQL");
	    h.add("C#");
	    
	    //printing HashTable
	    Iterator <String> itr=h.iterator();
	    while(itr.hasNext())
	    {
	      System.out.print(itr.next() + " ");
	    }
	   
	    //Removing item from HashSet    
	    System.out.println("\nItem Removed : "+h.remove("Java"));
	    
	    //Printing HashTable
	    System.out.println(h);
	}
}
