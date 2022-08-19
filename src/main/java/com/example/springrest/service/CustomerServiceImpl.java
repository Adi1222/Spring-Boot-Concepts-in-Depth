package com.example.springrest.service;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.dto.OrderRequest;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;
import com.example.springrest.exception.CustomerAlreadyExistsException;
import com.example.springrest.exception.NoSuchCustomerExistsException;
import com.example.springrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @ResponseBody
    public List<Product> getProducts(String name)
    {
        int cid = -1;
        try {
            cid = customerRepository.getCustomerId(name);
        }
        catch (Exception e) {
            return new ArrayList<>();
        }

        return customerRepository.getProductsOfCustomer(cid);
    }

    @Override
    public Customer getCustomer(int id)
    {
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchCustomerExistsException("No Such customer exists having id = "  + id)
        );

    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> cusIsPresent = customerRepository.findById(customer.getCid());

        cusIsPresent.orElseThrow(() -> new CustomerAlreadyExistsException("Customer Already Exists"));

        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
