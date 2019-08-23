package com.greatdigitallab.springhibernatedemo.service;

import java.util.List;

import com.greatdigitallab.springhibernatedemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
