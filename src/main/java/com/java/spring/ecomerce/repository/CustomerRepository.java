package com.java.spring.ecomerce.repository;

import com.java.spring.ecomerce.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }
    public Customer add(Customer customer){
        customers.add(customer);
        return customer;
    }
    public List<Customer> findAll(){
        return customers;
    }
    public Optional<Customer> findById(int id){
        return customers.stream().filter(customer -> customer.getId() == id).findFirst();
    }
    public Optional<Customer> findByEmail(String email){
        return customers.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }
    public Customer update(Customer customer){
        customers.replaceAll(c->c.getId() == customer.getId()? customer : c);
        return customer;
    }
    public void deleteById(int id){
        customers.removeIf(customer -> customer.getId() == id);
    }
    public void delete(Customer customer){
        customers.remove(customer);
    }

}
