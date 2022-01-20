package com.java.rough;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamManipulation {

	public static void main(String args[]) {
		
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,100,25,46);
		list1.forEach(i->System.out.println(i));
		Stream<Integer> s = list1.stream().filter(i->i<4);
		s.forEach(i->System.out.println(i));
		
		list1.stream().filter(i->i<4).forEach(i->System.out.println(i));
		
		Stream s1 = list1.stream().map(i->i*i);
		s1.forEach(i->System.out.println(i));
		
		list1.stream().map(i->i*i).forEach(i->System.out.println(i));
		
		List s3 = list1.stream().filter(i->i<100).collect(Collectors.toList());
		s3.forEach(i->System.out.println(i));
		
		System.out.println(list1.stream().filter(i->i<100).count());
		
		Stream<Integer> s4 = list1.stream().sorted((i1,i2)->i2.compareTo(i1));
				s4.forEach(i->System.out.println(i));
		
				
		System.out.println(list1.stream().max((i1,i2)->i2.compareTo(i1)).get());
		Stream<Integer> s5 = list1.stream().filter(i->i<4);
		Object[] a = s5.toArray();
		String []s6= {"abc","cba","bca"};
		List<String> l1= Stream.of(s6).filter(i->i.length()<5).sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
		l1.forEach(i->System.out.println(i));
		//Stream.of(s6).filter(i->i.length()==3).forEach(i->System.out.println(i));
		
		Stream.of(1,2,3,4,5,6,7).filter(i->i<5).forEach(i->System.out.println(i));
		
		
		
		
		
	}
}
