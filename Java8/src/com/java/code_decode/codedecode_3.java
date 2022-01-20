package com.java.code_decode;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class codedecode_3 {

	public static void main(String[] args) {
		
		//Java7
		codedecode_3 java7 = new codedecode_3();
		java7.square(3);
		
		//Consumer
		Consumer<Integer> consumer = i->System.out.println("Square me "+i*i);
		consumer.accept(10);
		
		//Consumer Chaining
		Consumer<Integer> consumer1 = i->System.out.println("Double me "+2*i);
		consumer.andThen(consumer1).accept(3);
		consumer1.andThen(consumer).accept(3);
	//consumer.compose(consumer1).accept(3); will provide compile time error as consumer does not have compose() method like function functional interface
	
		//forEach method in streams takes consumer as input
		System.out.println("forEach method taking consumer as input");
		List<Integer> list= Arrays.asList(2,3);
		list.stream().forEach(consumer);
		
		//Java7 Supplier
		System.out.println("Java7 method to get date "+java7.fetchcurrentDate());
		
		//Supplier 
		Supplier<Date> supplier = ()->new Date();
		System.out.println("Date is "+supplier.get());
		
		//BiPredicate,BiFunction,BiConsumer
		
		BiPredicate<Integer, Integer> bipredicate = (a,b)->(a+b)>5;
		System.out.println("BiPredicate Demo 3+4>5 "+bipredicate.test(3, 4));
		
		BiFunction<String, String, Integer> bifunction = (s1,s2)->s1.length()+s2.length();
		System.out.println("BiFunction Demo sum of length of two strings "+bifunction.apply("Hello", "Hello"));
		
		BiConsumer<Integer, Integer> biconsumer = (a,b)->System.out.println("BiConsumer Demo "+a*b);
		biconsumer.accept(3,2);
	}
	public void square(int i) {
		System.out.println("Java 7 squaring "+i*i);
	}
     
	public Date fetchcurrentDate() {
		return new Date();
	}
	
}
