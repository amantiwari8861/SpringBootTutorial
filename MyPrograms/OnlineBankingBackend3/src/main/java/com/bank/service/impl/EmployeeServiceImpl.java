package com.bank.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.entity.Employee;
import com.bank.repository.EmployeeRepository;
import com.bank.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Boolean deleteEmployee(Long id) {
		Employee goEmployees = getEmployeeById(id);
		repository.delete(goEmployees);
		return true;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

}
