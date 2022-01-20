package com.java.rough;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EmployeeSort {
	public static void main(String args[]) {
		
		Employee e1 =new Employee("Nagammai",101,50000,2,"SE","F");
		Employee e2 =new Employee("Mathi",102,55000,1,"TL","M");
		Employee e3 =new Employee("Siva",103,75000,1,"TL","M");
		Employee e4 =new Employee("Saradhi",104,50000,2,"TA","M");
		
		
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(e4);
		
		Predicate<Employee> fil = (emp1)->(emp1.getSal()<50000);
		System.out.println(fil.test(e4));
		
		
		emp.stream().filter(e->e.getGender().equals("F")&&e.getRole().equals("SE")).forEach(e->System.out.println(e.getName()+" "+e.getId()+" "+e.getGender()+" "+e.getSal()));
		
		
		emp.stream().filter(e->e.getYearsInOrg()<=1).map(e->{e.setSal(e.getSal()+5000); return e;}).forEach(e->System.out.println(e.getName()+" "+e.getSal()));
		
		
		Stream.of(1,2,3,4,5).map(i->i*i*i).forEach(i->System.out.println(i));
	}
}
