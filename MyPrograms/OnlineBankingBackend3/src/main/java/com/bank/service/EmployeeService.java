package com.bank.service;

import java.util.List;

import com.bank.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee user);
	public Employee updateEmployee(Employee user);
	public Boolean deleteEmployee(Long id);
	public Employee getEmployeeById(Long id);
	public List<Employee> getAllEmployees();
}
