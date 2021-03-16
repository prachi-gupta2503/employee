package com.adj.logger.modal;

public class Product extends Logger{
	
	int id;
	String company;
	String name;
	public Product(int id, String company, String name) {
		super();
		this.id = id;
		this.company = company;
		this.name = name;
	}
	
	public Product() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	public String toString() {
		return "Id: "+id+" \n Company Name:  "+name+"  \n Product Name :  "+name;
	}
	public  void showProduct(Product p ) {
		
		System.out.println("Company   :"+ p.getCompany() );
		System.out.println("Company   :"+ p.getName() );
	}
}
