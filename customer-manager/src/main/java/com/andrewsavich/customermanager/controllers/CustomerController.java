package com.andrewsavich.customermanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.andrewsavich.customermanager.model.Customer;
import com.andrewsavich.customermanager.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		List<Customer> customers = service.getAllCustomers();
		
		modelAndView.addObject("customers", customers);
		
		return modelAndView;
	}

}
