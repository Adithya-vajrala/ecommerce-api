package com.java.spring.ecomerce.service.impl;

import com.java.spring.ecomerce.enums.Gender;
import com.java.spring.ecomerce.enums.Status;
import com.java.spring.ecomerce.exception.CustomerAlreadyExistsException;
import com.java.spring.ecomerce.exception.CustomerNotFoundException;
import com.java.spring.ecomerce.model.Customer;
import com.java.spring.ecomerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService implements com.java.spring.ecomerce.service.CustomerService {
    private final CustomerRepository repository;

    @Override
    public Customer add(Customer customer) throws CustomerAlreadyExistsException {
        repository.findByEmail(customer.getEmail()).ifPresent(c->{
            throw new CustomerAlreadyExistsException("Customer already there with this id:" + customer.getId());
        });
        customer.setStatus(Status.INACTIVE);
        repository.add(customer);
        return customer ;
    }

    @Override
    public Customer getById(int id) throws CustomerNotFoundException {
       return repository.findById(id).orElseThrow(()->{
            throw new CustomerNotFoundException("Customer not found with this id:" + id);
        });
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFoundException {
        repository.findById(customer.getId()).orElseThrow(()->{
            throw new CustomerNotFoundException("Customer not found with this id" + customer.getId());
        });
        return repository.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) throws CustomerNotFoundException {
        repository.findById(id).orElseThrow(()->{
            throw new CustomerNotFoundException("Customer not found with this id" + id);
        });
        repository.deleteById(id);
    }
}
