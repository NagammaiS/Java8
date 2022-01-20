package com.java.code_decode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNoOfWords {

	//Input => welcome to code decode and code decode wlecomes you
	//Output => code=2 and=1 to=1 decode=2 welcome=2 you=1
	public static void main(String args[]) {
		
		//Function always returns its input element 
		Function<String,String> f = Function.identity();
		System.out.println("Returns the same input again as result "+f.apply("Hello"));
		
		String s= "welcome to code decode and code decode wlecomes you";
		List<String> list = Arrays.asList(s.split(" "));
		list.stream().forEach(i->System.out.println(i));
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		System.out.println("\nCount of words "+ list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	}
}
