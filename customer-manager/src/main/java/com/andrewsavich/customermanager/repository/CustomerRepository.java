package com.andrewsavich.customermanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.andrewsavich.customermanager.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
}
