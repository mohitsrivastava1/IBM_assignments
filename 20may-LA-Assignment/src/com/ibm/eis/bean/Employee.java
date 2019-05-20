package com.ibm.eis.bean;
public class Employee {
	private String name;
	private int id;
	private String designation;
	private int salary;
	private String insuranceScheme;
	
	public Employee(int id, String name, int salary, String designation)	{

		this.id = id;

		this.name = name;

		this.salary = salary;

		this.designation = designation;

		this.insuranceScheme = "none";

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}


 public String getInsuranceScheme() { 
	 return insuranceScheme; 
	 }
 public void setInsuranceScheme(String insuranceScheme) {
	 this.insuranceScheme =insuranceScheme; 
	 }

public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	/*
	 * @Override public String toString() { return "Employee [name=" + name +
	 * ", id=" + id + ", designation="+ designation +"]"; }
	 */
	
}
