package fabianmartinez.ecommerce.store.costumer.service;

import fabianmartinez.ecommerce.store.customer.repository.CustomerRepository;
import fabianmartinez.ecommerce.store.customer.entity.Customer;
import fabianmartinez.ecommerce.store.customer.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomersByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {

        Customer customerDb = customerRepository.findByNumberId(customer.getNumberId());
        if(customerDb != null){
            return customerDb;
        }
        customerDb.setState("CREATED");
        customerDb = customerRepository.save(customer);
        return customerDb;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDb = getCustomer(customer.getId());
        if(customerDb == null){
            return null;
        }
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setEmail(customer.getEmail());
        customerDb.setPhotoUrl(customer.getPhotoUrl());

        return customerRepository.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDb = getCustomer(customer.getId());
        if(customerDb == null){
            return null;
        }
        customerDb.setState("DELETED");

        return customerRepository.save(customerDb);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
