package fabianmartinez.ecommerce.store.costumer.controller;

import fabianmartinez.ecommerce.store.customer.entity.Customer;
import fabianmartinez.ecommerce.store.customer.entity.Region;
import fabianmartinez.ecommerce.store.costumer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomer(@RequestParam(name = "customerId",required = false) Long customerId ){
        List<Customer> customers = new ArrayList<>();
        if(null==customerId){
            customers = customerService.findCustomerAll();
            if (customers.isEmpty()){
                return ResponseEntity.notFound().build();
            }

        }else {
            Region region = new Region();
            region.setId(customerId);
            customers = customerService.findCustomersByRegion(region);
            if (null==customers) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(customers);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        Customer customerDb = customerService.getCustomer(id);
        if(null == customerDb){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(customerDb);
    }
    @PostMapping
    public ResponseEntity<Customer> createdCustomer(@RequestBody Customer customer, BindingResult result){
           if(null == customer){
               return ResponseEntity.notFound().build();
           }
           Customer customerDb = customerService.createCustomer(customer);

           return ResponseEntity.status(HttpStatus.CREATED).body(customerDb);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){

        Customer currentCustomer = customerService.getCustomer(id);
        if(null==currentCustomer){
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
       Customer customerDb = customerService.updateCustomer(customer);
       return  ResponseEntity.ok(customerDb);
    }
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "id") Long id){

        Customer customerDb = customerService.getCustomer(id);
        if(null == customerDb){
            return  ResponseEntity.notFound().build();
        }
     Customer customer01 = customerService.deleteCustomer(customerDb);
        return ResponseEntity.ok(customer01);
    }

}
