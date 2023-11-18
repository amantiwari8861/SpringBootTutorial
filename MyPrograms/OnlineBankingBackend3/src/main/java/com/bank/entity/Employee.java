package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String empname;
	public Employee() {
		super();
	}
	public Employee(Long id, String empname) {
		super();
		this.id = id;
		this.empname = empname;
	}
	public Long getEmpid() {
		return id;
	}
	public void setEmpid(Long id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + "]";
	}
	
}
