package com.example.springrest;

import com.example.springrest.controller.CustomerController;
import com.example.springrest.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class DemoTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void get_ALLVehiclces_succes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order/getorders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                        .andExpect(result -> System.out.print(result))
                                .andReturn();

        System.out.println("df");


    }

}
