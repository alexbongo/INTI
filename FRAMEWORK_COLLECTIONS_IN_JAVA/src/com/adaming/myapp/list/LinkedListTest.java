package com.adaming.myapp.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
	    list.add("Computer");
	    list.add("Mobile");
	    list.add("Tablet");
	    list.add("iPhone");
	    
	    //Adding an item at the begining of the list
	    list.addFirst("iPad");
	    System.out.println(list);
	    
	    //Adding an item at the last position of the list
	    list.addLast("Laptop");
	    System.out.println(list);
	   
	    //Making clone
	    Object obj=new Object();
	    obj=list.clone();
	    System.out.println("Clone : "+obj);
	    
	    //Remove item at index position 2
	    System.out.println("Items Removed : "+list.remove(2));
	    
	    //Printing Using Iterator
	    Iterator<String> itr=list.iterator();
	    while(itr.hasNext())
	    {
	      System.out.print(itr.next()+" , ");
	    }
	  }
	}

