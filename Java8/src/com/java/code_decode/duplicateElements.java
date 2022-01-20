package com.java.code_decode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Input : [10,28,87,10,20,76,28,80]
//Output :[10,28]
public class duplicateElements {
	public static void main(String args[]) {
		
		List<Integer> list = Arrays.asList(10,28,87,10,20,76,28,80,80,80);
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("Unique elements");
		list.stream().filter(i->set.add(i)).forEach(i->System.out.println(i));
		System.out.println("Set "+set);
		
		System.out.println("Duplicate elements alone but checks more than once for 80");
		HashSet<Integer> set1 = new HashSet<Integer>();
		//set.add will return 10 and 28 false we are negating to true and printing it but only unnique elements are added to the set
		list.stream().filter(i->!set1.add(i)).forEach(i->System.out.println(i));
		System.out.println("Set1 "+set1);
		
		System.out.println("Collecting duplicates in a set");
		HashSet<Integer> set2 = new HashSet<Integer>();
		Set<Integer> result = list.stream().filter(i->!set2.add(i)).collect(Collectors.toSet());
		System.out.println(result);
	}
}
