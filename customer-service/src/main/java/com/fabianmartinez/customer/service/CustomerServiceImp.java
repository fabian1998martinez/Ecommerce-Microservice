package com.fabianmartinez.customer.service;

import com.fabianmartinez.customer.repository.CustomerRepository;
import com.fabianmartinez.customer.repository.entity.Customer;
import com.fabianmartinez.customer.repository.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByIdRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {

        Customer customerBd = customerRepository.findByNumberId(customer.getNumberId());
        if (customerBd != null){
            return customerBd;
        }
        customer.setState("CREATE");
         customerBd =  customerRepository.save(customer);
        return customerBd ;
    }

    @Override
    public Customer uoDateCustomer(Customer customer) {
        Customer customerBd = customerRepository.findByNumberId(customer.getNumberId());
        if (customerBd == null){
            return null;
        }
        customerBd.setFirsName(customer.getFirsName());
        customerBd.setLastName(customer.getLastName());
        customerBd.setEmail(customer.getEmail());

        return customerRepository.save(customerBd);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerBd = getCustomer(customer.getId());
        if (customerBd == null){
            return null;
        }
        customerBd.setState("DELETE");
        return customerRepository.save(customerBd);
    }
}
