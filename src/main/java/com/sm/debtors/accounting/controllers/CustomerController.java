package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Customer;
import com.sm.debtors.accounting.services.CustomerService;
import com.sm.debtors.accounting.services.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation( value="To all customers")
    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){ return customerService.getAllCustomers();}
}
