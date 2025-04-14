package com.fabianmartinez.customer.service;


import com.fabianmartinez.customer.repository.entity.Customer;
import com.fabianmartinez.customer.repository.entity.Region;

import java.util.List;


public interface CustomerService {
    public List<Customer> findCustomerAll();
    public List<Customer> findByIdRegion(Region region);
    public Customer createCustomer(Customer customer);
    public Customer uoDateCustomer(Customer customer);
    public Customer getCustomer(Long id);
    public Customer deleteCustomer(Customer customer);
}
