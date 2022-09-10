package com.example.springrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "cust_prod_map",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.springrest.dto.CustomerProductMapping.class,
                        columns = {
                                @ColumnResult(name = "cn", type = String.class),
                                @ColumnResult(name = "pn", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Customer.customer_product_sqlresultsetmapping",
        query = "SELECT c.name as cn, p.pname as pn from Customer c join product p",
        resultSetMapping = "cust_prod_map"
)

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int cid;
    private String name;
    private String email;
    private String gender;
    private String address;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "cid") // here the catch is --> one product belongs to only one customer
    private List<Product> products; // One customer can buy many products


}
