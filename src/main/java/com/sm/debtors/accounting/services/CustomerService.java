package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.CustomerDao;
import com.sm.debtors.accounting.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Customer> getByCode(Integer code){
        return customerDao.findById(code);
    }
    public Customer addCustomer(Customer customer){
       return customerDao.save(customer);
    }
    public void deleteCustomer(Integer code){
        customerDao.deleteById(code);
    }
}