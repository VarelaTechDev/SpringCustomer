package com.project.customerproject.Controller;

import com.project.customerproject.Dao.CustomerRepository;
import com.project.customerproject.Dto.CustomerDTO;
import com.project.customerproject.Entity.Customer;
import com.project.customerproject.Service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Note that in the POST request, the URL does not contain an ID because you are creating a new resource.
    // In contrast, the PUT request requires specifying the ID of the customer you want to update in the URL.

    // http://localhost:8080/customers
    //    {
    //        "firstName": "John",
    //            "lastName": "Doe",
    //            "cardNumber": "1111222233334444",
    //            "cardLimit": 20000,
    //            "cardBalance": 0,
    //            "isDeleted": false
    //    }



    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDto) {
        CustomerDTO newCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // http://localhost:8080/customers/1
    //    {
    //        "firstName": "Jane",
    //            "lastName": "Doe",
    //            "cardNumber": "1111222233334444",
    //            "cardLimit": 25000,
    //            "cardBalance": 100,
    //            "isDeleted": false
    //    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDto, @PathVariable Integer customerId) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerDto, customerId);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
