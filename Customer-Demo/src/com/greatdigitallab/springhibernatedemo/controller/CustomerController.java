package com.greatdigitallab.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatdigitallab.springhibernatedemo.entity.Customer;
import com.greatdigitallab.springhibernatedemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject the Customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getCustomerList(Model model) {

		// Get the Customer List
		List<Customer> customerList = customerService.getCustomerList();

		// Add the Customer List to the Model
		model.addAttribute("customerList", customerList);
		
		return "customer-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// Save the Customer
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		// Get the customer
		Customer customer = customerService.getCustomer(id);
		
		// Set the customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		// Send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {

		// Delete the Customer
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}