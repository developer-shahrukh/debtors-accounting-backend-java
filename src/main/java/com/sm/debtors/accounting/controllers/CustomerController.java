package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Customer;
import com.sm.debtors.accounting.services.CustomerService;
import com.sm.debtors.accounting.services.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@ApiIgnore
@RestController
@RequestMapping("api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation( value="To all customers")
    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){ return customerService.getAllCustomers();}

    @GetMapping("/{code}")
    public ResponseEntity<Customer> getCustomerByCode(@PathVariable Integer code) {
        Optional<Customer> user = customerService.getByCode(code);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createUser(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Customer> updateUser(@PathVariable Integer code, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = customerService.getByCode(code);
        if (customer.isPresent()) {
            Customer updatedCustomer = customer.get();
            //updatedCustomer.setName(customerDetails.getName());
            //updatedCustomer.setEmail(customerDetails.getEmail());
            customerService.addCustomer(updatedCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer code) {
        if (customerService.getByCode(code).isPresent()) {
            customerService.deleteCustomer(code);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
