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

    @GetMapping("/getCustomer/{code}")
    public Optional<Customer> getByCode(@PathVariable Integer code) {
       return customerService.getByCode(code);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

   @DeleteMapping("/deleteCustomer/{code}")
    public void deleteCustomer(@PathVariable Integer code) {
       customerService.deleteCustomer(code);
   }
}
