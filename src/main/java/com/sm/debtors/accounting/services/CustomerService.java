package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.CustomerDao;
import com.sm.debtors.accounting.dto.Customer;
import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.exceptions.CustomerNotFoundException;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import com.sm.debtors.accounting.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public List<Customer> getAllCustomers(){
        return customerDao.findAll();
    }

    public Optional<Customer> getByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        return customerDao.findById(code);
    }

    public ResponseEntity<Object> addCustomer(Customer customer) {
        if (ObjectUtils.isEmpty(customer)) {
            throw new InvalidInputException("Item not provided");
        }
        try {
            Customer customerSaved = customerDao.save(customer);
            return ResponseEntity.status(200).body(customerSaved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in adding customer");
        }
    }

    public ResponseEntity<Object> updateCustomer(Customer customer) {
        if (ObjectUtils.isEmpty(customer)) {
            throw new InvalidInputException("Customer not provided");
        }
        Optional<Customer> customerInDB = getByCode(customer.getCode());
        if (customerInDB.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        try {
            Customer customerUpdated= customerDao.save(customer);
            return ResponseEntity.status(200).body(customerUpdated);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in update customer");
        }
    }

    public void deleteCustomer(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        customerDao.deleteById(code);
    }
}
