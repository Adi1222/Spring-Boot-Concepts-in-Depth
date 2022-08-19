package com.example.springrest.repository;

import com.example.springrest.entities.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    void tearDown() {
        System.out.println("Finished");
    }

    @Test
    void getCustomerProducts() {
    }

    @Test
    void getProductsOfCustomer() {
    }

    @Test
    void getCustomerId() {
        //Customer expectedCustomer = new Customer(4, "Barney", "barney@gmail.com", "male", "New York");

        //assertThat(expectedCustomer).isEqualTo(expectedCustomer);
    }

    @Test
    void checkCustomerByName()
    {
        // given
        String name = "Alex";

        // when
        //boolean exp = customerRepository.checkCustomerByName(name);

        // then
        //assertThat(exp).isTrue();
    }
}