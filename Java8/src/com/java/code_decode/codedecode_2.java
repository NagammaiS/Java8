package com.java.code_decode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class codedecode_2 {
	
	public static void main(String args[]) {
		
		//Predicate Java1.7
		codedecode_2 java7 = new codedecode_2();
		System.out.println("Finding String length using Java 7 " + java7.testStringlength("Hello Nagammai"));
		
		//Predicate Initialization , declaration , Implementation 
		Predicate<String> predicate1 = (s)->s.length()>=5;
		System.out.println("Finding String length using Functional Interface "+predicate1.test("Hello Nagammai"));
		
		//Filter method is a predicate using the predicate implementation in stream 
		List<String> list  = Arrays.asList("Hello","Hi","Naga");
		list.stream().filter(predicate1).forEach(i->System.out.println(i));
		
		//Predicate Joining using and or and negate
		Predicate<String>  predicate2 = s->s.length()%2==0;
		System.out.println("PREDICATE JOINING");
		System.out.println("Predicate joining using and "+ predicate1.and(predicate2).test("Hell"));//length is lesser than 5 and divisible by 2 true
		System.out.println("Predicate joining using or "+ predicate1.or(predicate2).test("NagammaiS"));//length is greater than 5 || not divisible by 2 but true
		System.out.println("Predicate joining using negate "+ predicate1.negate().test("NagammaiS"));// length is greater then 5 negate so false 
		
		//Function Java1.7
		System.out.println("Finding square using Java7 "+ java7.square(2));
		
		//Function takes one input and one output 
		Function<Integer, Integer> function1 = a->a*2;
		System.out.println("Double a number "+function1.apply(7));
		
		//Using a function inside a map as map accepts a function as input
		List<Integer> list2 = Arrays.asList(1,2,3);
		list2.stream().map(function1).forEach(i->System.out.println("Doubled number "+i));
		
		System.out.println("FUNCTIONAL CHAINING");
		//Function Chaining using andThen and compose(alternate)
		Function<Integer, Integer> function2 = a->a*a;
		System.out.println("Double and then Square the output using andThen "+ function1.andThen(function2).apply(3));
		
		//both are same
		System.out.println("Square and Double the output using andThen with reverse "+function2.andThen(function1).apply(3));
		System.out.println("Square and Double the output using compose "+function1.compose(function2).apply(3));
		
		//Function.identity always returns its input element ,
		//identity() is static method of function
		Function<String,String> f = Function.identity();
		System.out.println("Returns the same input again as result "+f.apply("Hello"));
	
	}	
	public boolean testStringlength(String s) {
		if(s.length()>=5) {
			return true;
		}
		else {
			return false;
		}
	}
	public int square(int i) {
		return i*i;
	}
}
