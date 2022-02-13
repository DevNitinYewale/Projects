package com.inventry.system;

public class Employee {
	
	private int name;
	private int password;
	private String model;
	
	public Employee(int name, int password,String model) {
		this.model=model;
		this.name = name;
		this.password = password;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", model=" + model + "]";
	}
	
	
	
	
	
	public void verify() {
		
	}
	
	public void addItetm() {
		
	}
	
	public void updatePrice() {
		
	}
}
