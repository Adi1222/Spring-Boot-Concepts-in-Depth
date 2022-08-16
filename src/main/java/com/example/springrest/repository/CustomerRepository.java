package com.example.springrest.repository;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.example.springrest.dto.CustomerProductMapping(c.name, p.pname) from Customer c join c.products p")
    public List<CustomerProductMapping> getCustomerProducts();

}
