package com.example.springrest.controller;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.dto.OrderRequest;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;
import com.example.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/orders/placeorder", consumes = "application/json")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return customerService.placeOrder(orderRequest);
    }


    @GetMapping(path = "/order/getorders")
    public List<Customer> getAllOrders()
    {
        return customerService.findAllOrders();
    }

    @GetMapping("/order/customerproducts")
    public List<CustomerProductMapping> getCustomerProducts()
    {
        return customerService.getCustomerProducts();
    }

    @GetMapping("/orders/customer")
    public List<Product> getProducts(@RequestParam(name = "name") String name)
    {
        return customerService.getProducts(name);
    }
}
