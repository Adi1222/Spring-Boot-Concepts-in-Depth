package com.example.springrest.controller;

import com.example.springrest.entities.Customer;
import com.example.springrest.exception.CustomerAlreadyExistsException;
import com.example.springrest.repository.CustomerRepository;
import com.example.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/getCustomer/{cid}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("cid") String cid)
    {
        return customerService.getCustomer(Integer.parseInt(cid));
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        //throw  new CustomerAlreadyExistsException("Customer Already Exists");
        try {
            Customer exp = customerService.addCustomer(customer);
            return exp;
        } catch (CustomerAlreadyExistsException e)
        {
            throw e;
        }
    }

    @GetMapping("/customer/{cname}")
    public boolean checkByName(@PathVariable String cname)
    {
        return customerRepository.checkCustomerByName(cname);
    }
}
