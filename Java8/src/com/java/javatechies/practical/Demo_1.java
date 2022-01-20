package com.java.javatechies.practical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo_1 {
	static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static void main(String args[]) {
	employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	
	
	// Query 1 : How many male and female employees are there in the organization?
			method1();
			System.out.println("\n");
			// Query 2 : Print the name of all departments in the organization?
			method2();
			System.out.println("\n");
			// Query 3 : What is the average age of male and female employees?
			method3();
			System.out.println("\n");
			// Query 4 : Get the details of highest paid employee in the organization?
			method4();
			System.out.println("\n");
			// Query 5 : Get the names of all employees who have joined after 2015?
			method5();
			System.out.println("\n");
			// Query 6 : Count the number of employees in each department?
			method6();
			System.out.println("\n");
			// Query 7 : What is the average salary of each department?
			method7();
			System.out.println("\n");
			// Query 8 : Get the details of youngest male employee in the product
			// development department?
			method8();
			System.out.println("\n");
			// Query 9 : Who has the most working experience in the organization?
			method9();
			System.out.println("\n");
			// Query 10 : How many male and female employees are there in the sales and
			// marketing team?
			method10();
			System.out.println("\n");
			// Query 11 : What is the average salary of male and female employees?
			method11();
			System.out.println("\n");
			// Query 12 : List down the names of all employees in each department?
			method12();
			System.out.println("\n");
			// Query 13 : What is the average salary and total salary of the whole
			// organization?
			method13();
			System.out.println("\n");
			// Query 14 : Separate the employees who are younger or equal to 25 years from
			// those employees who are older than 25 years.
			method14();
			System.out.println("\n");
			// Query 15 : Who is the oldest employee in the organization? What is his age
			// and which department he belongs to?
			method15();
}
	

	
	public static void method1() {
		System.out.println("Q1 Number of male and female employess");
		//type1
		System.out.println("Number of male employess "+ employeeList.stream().filter(e->e.getGender().equalsIgnoreCase("Male")).count());
		System.out.println("Number of male employess "+ employeeList.stream().filter(e->e.getGender().equalsIgnoreCase("Female")).count());
	
		//type 2 
		Map<String,Long> map1 = employeeList.stream()
				.collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
		System.out.println("Q1 type2 "+map1);
	}
	
	public static void method2() {
		System.out.println("Q2 Print the name of all departments in the organization");
		//type 1 
		HashSet<String> set = new HashSet<String>();
		employeeList.stream().filter(i->set.add(i.getDepartment())).forEach(i->System.out.println(i.getDepartment()));
	
		System.out.println("Q2 TYPE 2");
		employeeList.stream().map(e->e.getDepartment()).distinct().forEach(i->System.out.println(i));
	}
	
	public static void method3() {
		System.out.println("Q3 Average age of male and female employees");
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(e->e.getAge()))));
	}
	
	public static void method4() {
		System.out.println("Q4 Get the details of highest paid employee in the organization?");
	Optional<Employee> o = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())));
	System.out.println(o.get().getName());
	System.out.println(employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary()))).get().getName());
	Optional<Employee> emp = employeeList.stream().max(Comparator.comparingDouble(e->e.getSalary()));
	System.out.println("Highest paid employee "+emp.get().getName());
	
	System.out.println("TYPE 3");
	DoubleSummaryStatistics summary = employeeList.stream().collect(Collectors.summarizingDouble(e->e.getSalary()));
	System.out.println(summary.getMax());
	}
	
	public static void method5() {
		System.out.println("Q5 Get the names of all employees who have joined after 2015?");
		employeeList.stream().filter(e->e.getYearOfJoining()>2015).forEach(e->System.out.println(e.getName()));
	}
	
	public static void method6() {
		System.out.println("Q6 Count the number of employees in each department?");
		Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
		System.out.println("TYPE1 "+map);
		Set<Entry<String, Long>> entrySet = map.entrySet();
		entrySet.forEach(i->System.out.println(i.getKey()+": "+i.getValue()));
	}
	
	public static void method7() {
		System.out.println("Q7 What is the average salary of each department?");
		Map<String, Double> map = employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())));
		System.out.println("MAP PRINT TYPE 1 "+map);
		
		Set<Entry<String, Double>> set = map.entrySet();
		set.forEach(i->System.out.println(i.getKey()+": "+i.getValue()));
	}
	
	public static void method8() {
		System.out.println("Q8 Get the details of youngest male employee in the product development department?");
		Optional<Employee> emp = employeeList.stream().
		filter(e->e.getDepartment().equals("Product Development")&&e.getGender().equals("Male")).
		collect(Collectors.minBy(Comparator.comparingInt(e->e.getAge())));
		
		System.out.println("TYPE 1 "+emp.get().getName()+" "+emp.get().getAge());
		Optional<Employee> youngestemp =
				employeeList.stream()
				.filter(e->e.getDepartment().equals("Product Development")&&e.getGender().equals("Male"))
				.min(Comparator.comparingInt(e->e.getAge()));
		System.out.println("TYPE 2 "+emp.get().getName()+" "+emp.get().getAge());

	}
	
	public static void method9() {
		System.out.println("Q9 Who has the most working experience in the organization?");
		Optional<Employee> emp = employeeList.stream().min(Comparator.comparingInt(e->e.getYearOfJoining()));
		System.out.println("TYPE1 "+emp.get().getName());
		
		Optional<Employee> emp1 = employeeList.stream().sorted(Comparator.comparingInt(e->e.getYearOfJoining())).findFirst();
		System.out.println("TYPE2 "+emp1.get().getName());
		
	}
	
	public static void method10() {
		System.out.println("Q10 How many male and female employees are there in the sales and marketing team?");
		Map<String, Long> count =employeeList.stream().filter(e->e.getDepartment().equals("Sales And Marketing")).
		collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
		System.out.println(count);
	}
	
	public static void method11() {
		System.out.println("Q11 What is the average salary of male and female employees?");
		Map<String, Double> avgsal = employeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getSalary())));
	    System.out.println(avgsal);
	}
	public static void method12() {
		System.out.println("Q12 List down the names of all employees in each department?");
		Map<Object, List<Employee>> emp = employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
		Set<Entry<Object, List<Employee>>> set = emp.entrySet();
		set.forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
	}
	public static void method13() {
		System.out.println("Q13 What is the average salary and total salary of the whole");
		DoubleSummaryStatistics summary = employeeList.stream().collect(Collectors.summarizingDouble(e->e.getSalary()));
		System.out.println("Average "+summary.getAverage());
		System.out.println("Sum "+summary.getSum());
		System.out.println("Max salary "+summary.getMax());
		System.out.println("Min salary "+summary.getMin());
		System.out.println("Count is "+summary.getCount());
	}
	
	public static void method14() {
		System.out.println("Q14 Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
		Map<Boolean,List<Employee>> map=employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));
		Set<Entry<Boolean, List<Employee>>> set = map.entrySet();
		set.forEach(e->System.out.println(e.getKey()));
		
		for (Entry<Boolean, List<Employee>> entry : set) 
		{
		    System.out.println("----------------------------");
		    if (entry.getKey()) 
		    {
		        System.out.println("Employees older than 25 years :");
		    }
		    else
		    {
		        System.out.println("Employees younger than or equal to 25 years :");
		    }
		    System.out.println("----------------------------");        
		    List<Employee> list = entry.getValue();
		    for (Employee e : list) 
		    {
		        System.out.println(e.getName());
		    }
		}
	}
	
	public static void method15() {
		
		System.out.println("Q15 Who is the oldest employee in the organization? What is his age and which department he belongs to?");
		Optional<Employee> emp = employeeList.stream().max(Comparator.comparingInt(e->e.getAge()));
		System.out.println(emp.get().getName());
		System.out.println(emp.get().getAge());
		System.out.println(emp.get().getDepartment());
		
	}
	
	
	
}
