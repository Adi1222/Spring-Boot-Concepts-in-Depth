package com.example.springrest.service;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.dto.OrderRequest;
import com.example.springrest.entities.Customer;
import com.example.springrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer placeOrder(OrderRequest orderRequest)
    {
        return customerRepository.save(orderRequest.getCustomer());
    }

    @Override
    public List<Customer> findAllOrders()
    {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerProductMapping> getCustomerProducts()
    {
        return customerRepository.getCustomerProducts();
    }

}
