package com.java.rough;
public class Employee {
    public int id;
    public String name;
    private int sal;
    private double yearsInOrg;
    private String role;
    private String gender;

    public Employee(String name, int id, int sal, double years, String role, String gender) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.yearsInOrg = years;
        this.role = role;
        this.gender = gender;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public double getYearsInOrg() {
		return yearsInOrg;
	}

	public void setYearsInOrg(double yearsInOrg) {
		this.yearsInOrg = yearsInOrg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	public void printName() {
		System.out.println("Print name "+getName());
	}
}




