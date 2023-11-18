package com.google.mypro.service;

import java.util.List;

import com.google.mypro.model.Customer;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public void createCustomer(Customer customer);
}
