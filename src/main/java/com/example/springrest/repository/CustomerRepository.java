package com.example.springrest.repository;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.example.springrest.dto.CustomerProductMapping(c.name, p.pname) from Customer c join c.products p")
    public List<CustomerProductMapping> getCustomerProducts();


    @Query(value = "SELECT new com.example.springrest.entities.Product(p.pid, p.pname, p.price, p.qty) from Product p where cp_fk = :cid")
    public List<Product> getProductsOfCustomer(@Param("cid") int cid);

    //  Customer c join c.products where p.pname = :pname

    @Query("SELECT c.cid from Customer c where name = :cname")
    public int getCustomerId(@Param("cname") String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Customer c where name = :cname")
    public boolean checkCustomerByName(@Param("cname") String name); // purely for testing purpose

}
