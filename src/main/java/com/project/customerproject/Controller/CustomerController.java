package com.project.customerproject.Controller;

import com.project.customerproject.Dao.CustomerRepository;
import com.project.customerproject.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // Create simple methods to allow the following
    // GET all
    @GetMapping
    public List<Customer> getAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        if(customerList.isEmpty()){
            return null;
        }

        return customerList;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId){

        Optional<Customer> customer = customerRepository.findById(customerId);

        if(customer.isPresent()){
            return customer.get();
        }

        throw new RuntimeException("Customer not found");
    }

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }


}
