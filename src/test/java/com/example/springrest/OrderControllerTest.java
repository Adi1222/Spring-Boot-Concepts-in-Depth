package com.example.springrest;

import com.example.springrest.controller.OrderController;
import com.example.springrest.entities.Customer;
import com.example.springrest.entities.Product;
import com.example.springrest.repository.CustomerRepository;
import com.example.springrest.service.CustomerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import static org.hamcrest.Matchers.*;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    private MockMvc mockMvc;

    //@Mock
    //private CustomerRepository customerRepository;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(OrderController.class).build();
    }

    Product p1 = new Product(101, "Tshirt", 2, 599);
    Product p2 = new Product(102, "Shirt", 2, 999);
    Product p3 = new Product(103, "Trousers", 1, 1199);
    Product p4 = new Product(104, "Chinos", 1, 1399);
    List<Product> list_p1 = new ArrayList<>(Arrays.asList(p1,p2));
    List<Product> list_p2 = new ArrayList<>(Arrays.asList(p3,p4));
    Customer RECORD_1 = new Customer(1, "Rohan", "rohan@gmail.com", "Male", "Pune", list_p1);
    Customer RECORD_2 = new Customer(2, "Mohan", "mohan@gmail.com", "Male", "Pune", list_p2);


    @Test
    public void getAllOrders_success() throws Exception
    {
        List<Customer> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        //Mockito.when(customerService.findAllOrders()).thenReturn(records);

       // Mockito.when(customerRepository.findAll()).thenReturn(records);

        /*mockMvc.perform(MockMvcRequestBuilders.get("/order/getorders")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));*/

    }

}
