package com.java.code_decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.rough.Employee;

public class codedecode_4 {
	public static void main(String args[]) {
	
		
		Employee e1 =new Employee("Nagammai",101,50000,2,"SE","F");
		Employee e2 =new Employee("Mathi",102,55000,1,"TL","M");
		Employee e3 =new Employee("Siva",103,75000,1,"TL","M");
		Employee e4 =new Employee("Saradhi",104,50000,2,"TA","M");
		
		List<Employee> emp = Arrays.asList(e1,e2,e3,e4);
		
		//Intermediate operations no output 
		emp.stream().filter(e->e.getId()%2==0).map(e->{
			e.printName(); 
			return e.getId();
		});
		
		//Terminal Operations
		System.out.println("Terminal Operation");
		emp.stream().filter(e->e.getId()%2==0).map(e->{
			e.printName();
			return e.getId();
		}).forEach(e->System.out.println(e));
		
		//PEEK
		System.out.println("Peek Operations");
		//if we stop till peek it will not produce anny output as 
		
		emp.stream().filter(e->e.getId()%2==0).peek(e->System.out.println("Peek "+e)).forEach(e->System.out.println(e));
		System.out.println("\nFILTER ,PEEK , FILTER");
		emp.stream().filter(e->e.getId()%2==0).peek(e->System.out.println("Peek "+e)).filter(e->e.getSal()>50000).forEach(e->System.out.println(e));
	
		//REDUCE
		System.out.println("\nReduce operations");
		Integer i = emp.stream().map(e->e.getSal()).reduce(0,(e11,e22)->e11+e22);
		System.out.println("Salary is: "+i);
	
		List<Integer> list1 = Arrays.asList(12,32,43,45,56,67,78);
		System.out.println("Sum of array list "+list1.stream().reduce((a,b)->a+b).get());
		
		//limit()
		System.out.println("Limit Demo");
		list1.stream().limit(5).forEach(j->System.out.println(j));
		
		//skip()
		System.out.println("Skip demo");
		list1.stream().skip(3).forEach(j->System.out.println(j));
	}

}
