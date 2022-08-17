package com.example.springrest.onetomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    private String address;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL) // search for emp in Employee class. In Employee class, a new column is created by @JoinColumn
    private List<Employee> employees;

}
