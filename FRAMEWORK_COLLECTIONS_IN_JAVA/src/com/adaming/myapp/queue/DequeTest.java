package com.adaming.myapp.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeTest {

	public static void main(String[] args) {
		 Deque<String> d=new LinkedList<String>();
		    
		    d.addLast("Tail1");
		    d.addLast("Tail2");
		    d.addFirst("Head1");
		    d.addFirst("Head2");
		    
		    //Print Deque using Iterator
		    Iterator itr=d.iterator();
		    while(itr.hasNext())
		    {
		      System.out.print(itr.next() + " ");
		    }
		    System.out.println("\nPeek Last Value : "+d.peekLast());
		    System.out.println("Remove Last Value : "+d.pollLast());
		    //Adding new value to last
		    d.addLast("Hello");
		    System.out.println("printing : "+d);
		  }
	}

