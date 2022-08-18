package com.example.springrest.controller;

import com.example.springrest.entities.Customer;
import com.example.springrest.exception.CustomerAlreadyExistsException;
import com.example.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomer/{cid}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("cid") String cid)
    {
        return customerService.getCustomer(Integer.parseInt(cid));
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        throw  new CustomerAlreadyExistsException("Customer Already Exists");
    }

}
