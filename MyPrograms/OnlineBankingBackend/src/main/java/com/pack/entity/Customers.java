package com.pack.entity;

public class Customers {

	private String name;
	private int id;
	private long mobile;
	private double amount;
	
	
	public Customers() {	}
	public Customers(String name, int id, long mobile, double amount) 
	{
		this.name = name;
		this.id = id;
		this.mobile = mobile;
		this.amount = amount;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Customers [name=" + name + ", id=" + id + ", mobile=" + mobile + ", amount=" + amount + "]";
	}	
}
