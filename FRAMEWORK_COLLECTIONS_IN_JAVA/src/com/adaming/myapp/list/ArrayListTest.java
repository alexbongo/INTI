package com.adaming.myapp.list;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args)
	  {
	    ArrayList<String> alist=new ArrayList<>();
	    alist.add("Table");
	    alist.add("Chair");
	    alist.add("Speaker");
	    alist.add("Guitar");
	    alist.add("Fan");
	    
	    //Printing arraylist item
	    System.out.print("All Array List Items are ");
	    System.out.println(alist);
	    
	    //Adding new item at index position 2
	    alist.add(2, "Calculator");
	    System.out.println("Adding Calculator : "+alist);
	    
	    //Removing item Calculator
	    alist.remove("Calculator");
	    System.out.println("Removing Calculator : "+alist);
	    
	    //Get element name at specified index position
	    System.out.println("Element at Index Position 2 : " + alist.get(2));
	    
	    //Get total size of arraylist
	    System.out.println("ArrayList Size are : " + alist.size());
	    
	    //Clear the arraylist
	    alist.clear();
	    System.out.println("After clearing arraylist " + alist);
	  }
	
}
