package com.project.customerproject.Controller;

import com.project.customerproject.Dao.CustomerRepository;
import com.project.customerproject.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
