package com.product.CustomerRelationshipManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.CustomerRelationshipManager.entity.Customer;
import com.product.CustomerRelationshipManager.repository.CustomerRepository;
@Service
public class CustomerService {
    @Autowired
	private CustomerRepository repo;
	
	public void addCustomer(Customer c) {
		repo.save(c);
	}
	
	public List<Customer> getAllCustomer(){
		 return repo.findAll();
	}
	
	
	public Customer getCustomerById(int id) {
		Optional<Customer> c= repo.findById(id);
		if(c.isPresent()) {
			c.get();
		} 
		return null;
	}
	
	public void deleteCustomerById(int id) {
		repo.deleteById(id);
	}
}
