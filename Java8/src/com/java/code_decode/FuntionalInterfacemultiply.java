package com.java.code_decode;

import java.util.function.BiFunction;

//Multiply using functional interface
public class FuntionalInterfacemultiply {

	public static void main(String[] args) {
	
		BiFunction<Integer,Integer,Integer> function = (a,b)->a*b;
		System.out.println(function.apply(3,6));
		
		multiplyFUNCINTER object = (a,b)->a*b;
		System.out.println(object.multiply(4, 3));

	}
}
