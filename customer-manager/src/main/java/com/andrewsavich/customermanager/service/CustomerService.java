package com.andrewsavich.customermanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrewsavich.customermanager.model.Customer;
import com.andrewsavich.customermanager.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public List<Customer> getAllCustomers() {
		return (List<Customer>) repository.findAll();
	}

	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}

	public Customer getCustomer(long id) {
		Optional<Customer> result = repository.findById(id);
		return result.get();
	}
	
	public void deleteCustomer(long id) {
		repository.deleteById(id);
	}
}
