package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Duc", "duc@codegym.vn", "Ha noi"));
        customers.put(2, new Customer(2, "Quy", "quy@codegym.vn","Ha noi"));
        customers.put(3, new Customer(3, "Hau","hau@codegym.vn", "Ha noi"));
        customers.put(4,new Customer(4, "Hoang","hoang@codegym.vn", "Ha noi"));

    }
    public List<Customer> findAll(){
        return new ArrayList<>(customers.values());
    }
    public void save(Customer customer){
        customers.put(customer.getId(),customer);
    }
    public Customer findById(int id){
        return customers.get(id);
    }
    public void update(int id, Customer customer){
        customers.put(id, customer);
    }
    public void remove(int id){
        customers.remove(id);
    }
}
