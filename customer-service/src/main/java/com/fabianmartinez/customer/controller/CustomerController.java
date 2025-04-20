package com.fabianmartinez.customer.controller;


import com.fabianmartinez.customer.repository.entity.Customer;
import com.fabianmartinez.customer.repository.entity.Region;
import com.fabianmartinez.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
   private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomer( @RequestParam(name = "regionId") Long regionId){
       List<Customer> customers = new ArrayList<>();
       if(regionId == null){
           customers = customerService.findCustomerAll();
           if (customers.isEmpty()){
               return ResponseEntity.notFound().build();
           }
       }else {

           Region region = new Region();
           region.setId(regionId);
           customers = customerService.findByIdRegion(region);
           if(customers == null) {
               return ResponseEntity.notFound().build();
           }
       }
       return  ResponseEntity.ok(customers);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") Long id){
        Customer customerBd = customerService.getCustomer(id);
        if (null == customerBd){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerBd);
    }
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody  Customer customer){
     Customer customerBd = customerService.createCustomer(customer);
     return ResponseEntity.status(HttpStatus.CREATED).body(customerBd);

    }
    @PutMapping
    public ResponseEntity<Customer> upDateCustomer(Long id ,Customer customer){

        Customer customerBd = customerService.getCustomer(id);
        if (null == customerBd){
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customerBd = customerService.uoDateCustomer(customer);
        return ResponseEntity.ok(customerBd);

    }
    @DeleteMapping
    public ResponseEntity<Customer> deleteCustomer(Long id){

        Customer customer = customerService.getCustomer(id);
        if (null == customer){
            return ResponseEntity.notFound().build();
        }
        customer = customerService.deleteCustomer(customer);
        return ResponseEntity.ok(customer);
    }
}
