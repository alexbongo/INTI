package com.adaming.myapp.queue;

import java.util.Iterator;
import java.util.PriorityQueue;



public class PriorityQueueTest {

	public static void main(String[] args) {
		 PriorityQueue<String> p=new PriorityQueue<String>();
		    //Adding Element in PriorityQueue
		    p.add("C#");
		    p.add("Java");
		    p.add("C++");    
		    p.add("HTML");
		    p.add("VB.Net");
		    
		    //Printing PriorityQueue
		    Iterator <String> itr=p.iterator();
		    while(itr.hasNext())
		    {
		     System.out.print(itr.next()+" "); 
		    }
		    
		    //Adding Elements
		    p.add("PHP");
		    System.out.println("\n" + p);
		    
		    //Accessing Top Element
		    System.out.println("Top Element is "+ p.element());
		    
		    //Removing Top Element
		    System.out.println("Item Removed : " + p.remove());
		    
		    //Prining PriorityQueue
		    System.out.println(p);
		    
	}
}
