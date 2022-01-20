package com.java.code_decode;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.java.rough.DemoInterface;

public class codedecode_1 {
	public static  void main(String args[]) {
	
		//Java 1.7
		codedecode_1 code = new codedecode_1();
		code.add(2, 4);
		
		//Java 1.8 Biconsumer takes two inputs but no output 
		BiConsumer<Integer, Integer> add = (a,b)->System.out.println(a+b);
		add.accept(2,4);
		
		//Comparator Functional Interface
		Comparator<String> c = (s1,s2)-> s1.compareTo(s2);
		System.out.println(c.compare("Hello", "Helloo"));
		
		//Custom FunctionalInterface
		DemoInterface demo = (a,b)->(a-b);
		System.out.println(demo.subtract(10, 5));
	}
	
	//Java 7
	public void add(int a, int b) {
		System.out.println(a+b);
	}
}
