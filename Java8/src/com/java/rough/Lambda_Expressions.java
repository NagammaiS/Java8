package com.java.rough;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda_Expressions {

	public static void main(String args[]) {
		lambdainterface mul = (a,b)->System.out.println(a*b);
		mul.multiply(12, 2);
		
		String name1="Nagammai";
		String name2 = "Aishwarya";
		Comparator<String> names = (s1,s2)->s1.compareTo(s2);
		System.out.println(names.compare(name1, name2));
		
		
		Consumer<String> method1 = (input)->System.out.println(input);
		method1.accept("Hi");
		
		Predicate<String> length1 = s1-> s1.length()<5;
		System.out.println(length1.test("hello"));
		
		Predicate<String> checkeven = s1-> s1.length()%2==0;
		System.out.println(checkeven.test("Helloo"));
		
		System.out.println(checkeven.and(length1).test("Hell"));
		
		System.out.println(length1.or(checkeven).test("Hi"));
		
		System.out.println(length1.negate().test("HELL"));
		
		Function<String, Integer>  func = (s)-> (s.length());
		System.out.println(func.apply("Nagammai"));
		
		Function<Integer,Integer> square = (i)->(i*2);
		System.out.println(square.apply(5));
		
		Function<Integer,Integer> cube = i->i*i*i;
		System.out.println(cube.apply(3));
		
		System.out.println(square.andThen(cube).apply(2));
		System.out.println(square.compose(cube).apply(2));
		
		Consumer<Integer> squareit = (i)->System.out.println(i*i);
		squareit.accept(9);
		
		Consumer<Integer> doubleme = i->System.out.println(2*i);
		doubleme.accept(2);
		
		squareit.andThen(doubleme).accept(3);
		
		
		Supplier<Date> getDate = ()-> new Date();
		System.out.println(getDate.get());
		
		BiFunction<Integer, Integer, Integer> lengthstring =  (i1,i2)->i1+i2;
		System.out.println(lengthstring.apply(3,2));
		
		List<Integer> list1=Arrays.asList(1,2,3,4);
		
		Consumer<Integer>  forlist = (i)->System.out.println(i);
		list1.forEach(forlist);
		list1.forEach(i->System.out.println(i));
	}		
}


