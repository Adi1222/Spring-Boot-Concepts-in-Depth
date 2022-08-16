package com.example.springrest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomerProductMapping {

    private String customer_name;
    private String product_name;

    public CustomerProductMapping(String customer_name, String product_name) {
        this.customer_name = customer_name;
        this.product_name = product_name;
    }

    private int price; // since constructor does not include this attribute, its values will be set to 0 by default in the resultset


}
