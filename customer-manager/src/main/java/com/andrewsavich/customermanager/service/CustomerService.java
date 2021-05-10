package com.andrewsavich.customermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrewsavich.customermanager.model.Customer;
import com.andrewsavich.customermanager.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getAllCustomers(){
		return (List<Customer>) repository.findAll();
	}
}
