package com.adaming.myapp.list;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//Initial size is 2
	    Vector<String> v=new Vector<>(2);
	    v.addElement("Laptop");
	    v.addElement("Desktop");
	    v.addElement("iPhone");
	    
	    System.out.println(v);
	    System.out.println("Vector Size is "+v.size());
	    System.out.println("Default Capacity Increment is "+v.capacity());
	    System.out.println("If Contains iPhone : "+v.contains("iPhone"));
	    System.out.println("First Element is : "+v.firstElement());
	    System.out.println("Last Element is : "+v.lastElement());
	    System.out.println("Index Position of Desktop : "+v.indexOf("Desktop"));
	    System.out.println("Is Vector Empty ? : " +v.isEmpty());
	    //Adding Mobile at index position 2
	    v.add(2,"Mobile");
	    System.out.println("New List is after adding Mobile : "+v);
	    //Removing Desktop
	    v.remove("Desktop");
	    System.out.println("New List is after removing Desktop : "+v);
	    
	    //Iterate through Iterator Interface
	    System.out.println("Elements are : ");
	    Iterator itr=v.iterator();    
	    while(itr.hasNext())
	    {
	      System.out.print(itr.next() + " , ");
	    }
	    
	    //Traverse using Enumertion
	    System.out.println("\nElements are : ");
	    Enumeration <String> en=v.elements();
	    while(en.hasMoreElements())
	    {
	      System.out.print(en.nextElement() + " , ");
	    }    
	  }
	}

