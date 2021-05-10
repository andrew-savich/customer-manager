package com.andrewsavich.customermanager.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		
		model.put("customer", new Customer());
		
		return "new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView modelAndView = new ModelAndView("edit_customer");
		Customer customer = service.getCustomer(id);
		modelAndView.addObject("customer", customer);
		
		return modelAndView;
	}

}
