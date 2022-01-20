package com.java.durgasoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DurgasoftStreams_3 {

	
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(10,0,15,5,20);
		
		System.out.println("Returns a optional so use get(): "+list.stream().min((i1,i2)->i1.compareTo(i2)));
		System.out.println("Max from ascending "+list.stream().max((i1,i2)->i1.compareTo(i2)).get());
		System.out.println("Min from ascending "+list.stream().min((i1,i2)->i1.compareTo(i2)).get());
		System.out.println("Max from descending "+list.stream().max((i1,i2)->i2.compareTo(i1)).get());
		System.out.println("Min from descending "+list.stream().min((i1,i2)->i2.compareTo(i1)).get());
		
		System.out.println("List to Array");
		Integer[] arrays = list.stream().toArray(Integer[]::new);
		for(Integer i : arrays) {
			System.out.println(i);
		}
		
		Object[] arrays1 = list.stream().toArray();
		for(Object i : arrays1) {
			System.out.println(i);
		}
		
		System.out.println("Converting list to array and printing array using Stream.of instead of for each loop");
		Stream.of(arrays).forEach(i->System.out.println(i));
		
		//Stream.of
		Stream.of(1,2,3).map(i->i*i).forEach(i->System.out.println("Stream.of demo "+i));
		
		System.out.println("Sorted list to array");
		Integer array1[] = new Integer[] {4,6,3,9,9};
		Object[] array2 = Arrays.asList(array1).stream().sorted().toArray();
		Arrays.asList(array2).forEach(i->System.out.println(i));
		
		
		//Internal implementation of forEach
		Consumer<List<Integer>> c = i->System.out.println(i);
		c.accept(list);
	}
}
