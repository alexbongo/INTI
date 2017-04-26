package com.adaming.myapp.queue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeTest {

	public static void main(String[] args) {
		
		ArrayDeque<String> aq=new ArrayDeque<String>();
	    aq.push("C#");
	    aq.push("Java");
	    aq.push("HTML");
	    aq.push("ASP.Net");
	    
	    //Printing ArrayDeque
	    Iterator <String> itr=aq.iterator();
	    while(itr.hasNext())
	    {
	      System.out.print(itr.next()+ " ");
	    }
	    
	    //Removing one Item
	    System.out.println("\nItem Removed : " + aq.pop());
	    
	    //Printing ArrayDeque Again
	    System.out.println(aq);
	    
	    //Adding Element at First Position
	    aq.addFirst("PHP");
	    //Adding Element at Last Position
	    aq.addLast("JavaScript");
	    
	    //Printing ArrayDeque
	    System.out.println(aq);
	    
	    //Finding Element
	    if(aq.contains("Java"))
	    {
	      System.out.println("Java is found in this list");
	    }
	  }
}
