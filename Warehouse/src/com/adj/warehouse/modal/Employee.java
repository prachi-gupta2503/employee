package com.adj.warehouse.modal;

public class Employee extends Warehouse{
	int id;
	String name;
	String gender;
	int salary;
	public Employee(int id, String name, String gender, int salary) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	public Employee() {}
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		//return "Id: "+id+" \n  Name:  "+name+"  \n Gender :  "+gender+"  \n Salary   "+salary;
		//return "   id:         Name       Gender           Salary   \n  " + id +"       "+name+"        "+gender+"    "+salary;
	     
		return "		"+id+"		"+name+"		"+gender+"		"+salary;
	
	}
	public void showEmployee(Employee e) {
		
		System.out.println("Name:"+ e.getName());
		System.out.println("Gender:"+ e.getGender());
		System.out.println("Salary:"+ e.getSalary());
		
		
	}
	
}
