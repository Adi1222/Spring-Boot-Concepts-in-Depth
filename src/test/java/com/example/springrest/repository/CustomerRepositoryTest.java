package com.example.springrest.repository;

import com.example.springrest.dto.CustomerProductMapping;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;


    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        /**
         *  We don't have to write this piece of code as we have used the @ExtendWith(MockitoExtention.class)
         *   which will open and close the mocks for us
         */
        // autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        //this.autoCloseable.close();
        System.out.println("Finished");
    }



    @Test
    @Disabled
    void getCustomerProducts() {
    }

    @Test
    @Disabled
    void getProductsOfCustomer() {
    }

    @Test
    @Disabled
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
        boolean exp = customerRepository.checkCustomerByName(name);

        // then
        assertThat(exp).isTrue();
    }
}