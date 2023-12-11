package com.product.CustomerRelationshipManager.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.CustomerRelationshipManager.entity.Customer;
import com.product.CustomerRelationshipManager.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;
	@GetMapping("/")
	public String home(Model m) {
		List<Customer> customer=service.getAllCustomer();
		m.addAttribute("customer", customer);
		return "index";
	}
	@GetMapping("/addcustomer")
	public String addCustomer() {
		return "add_customer";
	}
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute Customer c, HttpSession session) {
		service.addCustomer(c);
		session.setAttribute("msg", "customer added sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editCustomer(@PathVariable int id, Model m) {
		Customer c=service.getCustomerById(id);
		m.addAttribute("customer", c);
		return "edit_customer";
	}
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id, HttpSession session) {
		service.deleteCustomerById(id);
		session.setAttribute("msg", "customer deleted succesfully");
		return "redirect:/";
	}

}
