package com.product.CustomerRelationshipManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.CustomerRelationshipManager.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
