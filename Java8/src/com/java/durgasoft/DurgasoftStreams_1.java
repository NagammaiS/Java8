package com.java.durgasoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DurgasoftStreams_1 {
	public static void main (String args[]) {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(5);
		list.add(20);
		list.add(15);
		list.add(10);
		list.add(25);
		
		//Java7
		List<Integer> newarr = findElemets(list);
		System.out.println("Filtering list using Java 7 ");
		for(Integer i:newarr) {
			System.out.println(i);
		}
		//Filter even numbers
		List<Integer> list2 = list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("Even numbers");
		list2.forEach(i->System.out.println(i));
		
	    //Add 5 to each element so we use map so that for every object 
		List<Integer> markList = list.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println("Marks+5");
		markList.forEach(i->System.out.println(i));
		
		//Count of numbers less than 15 
		System.out.println("Count of numbers less than 15 are "+list.stream().filter(i->i<15).count());
		System.out.println("Count of numbers in raw stream are "+list.stream().count());
		
		//Sorted list
		System.out.println("Sorted List in direct stream()");
		list.stream().sorted().forEach(i->System.out.println(i));
		
		//Sorted List in filtered stream
		System.out.println("Sorted List with even numbers in filtered stream");
		list.stream().filter(i->i%2==0).sorted().forEach(i->System.out.println(i));
		
		///Sorted and collected stream 
		System.out.println("Sorted and Collected stream with +5");
		List<Integer> mappedStream = list.stream().map(i->i+5).sorted().collect(Collectors.toList());
		mappedStream.forEach(i->System.out.println(i));
		
		System.out.println("Mapped with +5 and ascending order");
		list.stream().map(i->i+5).sorted((i1,i2)->i1.compareTo(i2)).forEach(i->System.out.println(i));
		
		System.out.println("Mapped with +5 and descending order");
		list.stream().map(i->i+5).sorted((i1,i2)->i2.compareTo(i1)).forEach(i->System.out.println(i));
		System.out.println("Descending order with -");
		list.stream().map(i->i+5).sorted((i1,i2)->-i1.compareTo(i2)).forEach(i->System.out.println(i));
		
	}
	public static List<Integer> findElemets(List<Integer> arlist){
		List<Integer> newArr = new ArrayList<Integer>();
		for(Integer i:arlist) {
			if(i%2==0) {
				newArr.add(i);
			}
		}
		return newArr;
	}
}
