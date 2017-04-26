package com.adaming.myapp.list;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		 //Create Empty Stack
	    Stack<String> stk=new Stack<>();
	    System.out.println("Items on Stack : " + stk);
	    
	    //Adding items to Stack
	    stk.push("A");
	    stk.push("B");
	    stk.push("C");
	    
	    
	   try{
	    //Retrieving Stack
	    System.out.println("Removing Top Items : " + stk.pop());
	    System.out.println("Now items are : " + stk);
	    
	    System.out.println("Removing Top Items : " + stk.pop());
	    System.out.println("Now items are : " + stk);
	    
	    System.out.println("Removing Top Items : " + stk.pop());
	    System.out.println("Now items are : " + stk);
	    
	    System.out.println("Removing Top Items : " + stk.pop());
	    System.out.println("Now items are : " + stk);
	    }
	    catch(EmptyStackException e)
	    {
	      System.out.println("Stack Empty");
	    }
	}
}
