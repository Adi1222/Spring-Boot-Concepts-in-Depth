package com.example.springrest.service;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.dto.OrderRequest;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;

import java.util.List;

public interface CustomerService {

    public Customer placeOrder(OrderRequest orderRequest);

    public List<Customer> findAllOrders();

    public List<CustomerProductMapping> getCustomerProducts();

    public List<Product> getProducts(String name);

}
