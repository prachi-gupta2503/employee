package com.adj.logger.modal;

public class Student extends Logger{

	int id;
	String name;
	String gender;
	int fees;
	
	public Student(int id,String name,String gender,int fees)
	{
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.fees=fees;
	}
	
	public Student() {}
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


	public int getFees() {
		return fees;
	}


	public void setFees(int fees) {
		this.fees = fees;
	}

	public String toString() {
		//return " Id: "+id+" \n Name:  "+name+"  \n Gender :  "+gender+"  \n fees   "+fees;
		return "		"+id+"		"+name+"		"+gender+"		"+fees;
				
	}
	public void showStudent(Student s) {
		
		System.out.println("Name: "+ s.getName());
		System.out.println("Gender: "+ s.getGender());
		System.out.println("Fees: "+ s.getFees());
		
		
	}
}
