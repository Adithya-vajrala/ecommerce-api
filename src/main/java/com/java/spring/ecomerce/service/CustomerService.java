package com.java.spring.ecomerce.service;

import com.java.spring.ecomerce.exception.CustomerAlreadyExistsException;
import com.java.spring.ecomerce.exception.CustomerNotFoundException;
import com.java.spring.ecomerce.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer) throws CustomerAlreadyExistsException;
    Customer getById(int id) throws CustomerNotFoundException;
    Customer update(Customer customer) throws ClassNotFoundException;
    List<Customer> getAll();
    void deleteById(int id) throws CustomerNotFoundException ;
}
