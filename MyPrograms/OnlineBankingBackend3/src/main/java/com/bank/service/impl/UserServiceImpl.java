package com.bank.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.entity.Customer;
import com.bank.exceptions.AccountDoesNotExistsException;
import com.bank.exceptions.UserDoesNotExistsException;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

	@Override
	public Customer saveUser(Customer user) {
		return repository.save(user);
	}

	@Override
	public Customer updateUser(Customer user) {
		return repository.save(user);
	}

	@Override
	public Boolean deleteUser(Long id) {
		Customer goUsers = getUserById(id);
		repository.delete(goUsers);
		return true;
	}

	@Override
	public Customer getUserById(Long id) {
		Optional<Customer> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new UserDoesNotExistsException("The User with id " + id + " does not exists");
	}

	@Override
	public Customer getUserByAccountNumber(Long accountNumber) {
		Optional<Customer> byAccountNumber = repository.findByAccountNumber(accountNumber);
		if(byAccountNumber.isPresent()) {
			return byAccountNumber.get();
		}
		throw new AccountDoesNotExistsException("Account Number "+accountNumber+" does not exists");
	}

	@Override
	public List<Customer> getAllUsers() {
		return repository.findAll();
	}

	
}
