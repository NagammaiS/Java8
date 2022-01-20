package com.java.durgasoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DurgasoftStreams_2 {
  public static void main(String args[]) {
	  List<String> hero = new ArrayList<String>();
	  hero.add("joseph vijay");
	  hero.add("arun vijay");
	  hero.add("surya saravanan");
	  hero.add("ajith kumar");
	  
	  System.out.println("Ascending order");
	  hero.stream().sorted().forEach(i->System.out.println(i));
	  
	  System.out.println("\n"+"Ascending with compare To");
	  hero.stream().sorted((i1,i2)->i1.compareTo(i2)).forEach(i->System.out.println(i));
	  
	  System.out.println("\nDescending order with compareTo");
	  hero.stream().sorted((i1,i2)->i2.compareTo(i1)).forEach(i->System.out.println(i));
	  
	  System.out.println("\nDescending order with -");
	  hero.stream().sorted((i1,i2)->-i1.compareTo(i2)).forEach(i->System.out.println(i));
	  
	  
	  System.out.println("\nSORT BY LENGTH");
	  Comparator<String> c = (i1,i2)->{
		  int l1= i1.length();
		  int l2= i2.length();
		  if(l1<l2) return -1;
		  else if(l1>l2) return +1;
		  else return i1.compareTo(i2);
	  };
	  
	  hero.stream().sorted(c).forEach(i->System.out.println(i));
	  
	  List<String> alphabets = Arrays.asList("A","AAAA","AA","AAAAA","BBBB","NNN","CCCCCC");
	 alphabets.stream().sorted(c).forEach(i->System.out.println(i));

  }
}
