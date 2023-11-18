package com.bank.service;

import java.util.List;

import com.bank.entity.Customer;

public interface UserService 
{
	public Customer saveUser(Customer user);
	public Customer updateUser(Customer user);
	public Boolean deleteUser(Long id);
	public Customer getUserById(Long id);
	public List<Customer> getAllUsers();
	Customer getUserByAccountNumber(Long accountNumber);
}
